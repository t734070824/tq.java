2019-03-26

## ConcurrentLinkedQueue 
1. http://www.importnew.com/27052.html

### 队列的状态机模型
1. 状态机模型和是否需要并发无关, 一个类不管是否是线程安全的, 其状态模型从类被实现(此时, 所有类的行为都是确定的)
    开始确认的
2. 理想的线程安全队列中，**入队和出队之间不应该存在竞争**，这样入队的状态机模型和出队的状态机模型可以完全解耦，互不影响 
3. 对状态机做两个假设
    - 只支持入队和出队两种行为
    - 入队和出队不存在竞争, 即****入队模型与出队模型是对偶、独立的两个状态机
    
### 状态机定义
1. 存在2个生产者P1、P2，同时触发入队操作。
    - 单线程环境, 入队操作
        ```java
        public class States{
            void offer(E e){
                //准备
                newNode.next = null;
                curTail = tail;
                //入队前
                //状态 S1
                assert tail == curTail && tail.next = null;
                //开始入队
                //事件 E1
                tail.next = newNode;
                //入队中
                //状态 S2
                assert tail == curTail && tail.next == newNode;
                //事件 E2
                tail = tail.next;
                //结束入队
                //入队后
                //状态 S3  合并到状态 S1
                assert tail == newNode && tail.next = null;
            }
        }
        ```
    - 涉及两个域的改变: tail.next, tail, 随着操作的进行, 队列会经历两种状态
        - 状态S1：事件E1执行前，tail指向实际的尾节点curTail，tail.next==null。
            如生产者P1、P2都还没有触发入队时，队列处于状态S1；生产者P1完成入队P2还没触发入队时，队列处于状态S1。
        - 状态S2：事件E1执行后、E2执行前，tail指向旧的尾节点curTail，tail.next==newNode。
        - 状态S3：事件E2执行后，tail指向新的尾节点newNode，tail.next==null。同状态S1，合并。
        
### 自撸ConcurrentLinkedQueue
1. 依赖CAS，两个状态转换T1、T2都可以实现为原子操作。留给我们的问题是，**如何维护合法的状态转换**。
2. 入队方法offer()
    - 思路1：让同一个生产者P1连续完成两个状态转换T1、T2，保证P2不会插入进来
        - 悲观策略, 一次只放入一个生产者, 
    - 思路2：生产者P1完成状态转换T1后，P2代劳完成状态转换T2
        - 打开大门，欢迎任何“有能力”的生产者完成T2，是典型的乐观策略。
3. 减少无效竞争
    - 两种实现的第一步都是cas尝试T1, 失败就退化成一次探查,
    - 发起cas之前, 可能队列已经处于S2, 这时 CAS 尝试就是一种浪费, 只需要探查即可
    

### 出队方法 poll()
1. 存在2个消费者C1、C2，同时触发出队操作。
2. 哨兵node
    - 解决当队列为空或只有一个节点, 出队和入队竞争同一个锁的问题
3. 状态机
    - 先将要移除的item拿出来, 设置null, 然后 dummy指向dummy.next
        ```java
        public class Dummy{
            public Dummy(){
                dummy = new Node(null, null);
            }
            
            void poll(){
                curDummy = dummy;
                curNext = curDummy.next;
                oldItem = curNext.item;
                //出队前
                //状态 S1
                assert dummy == curDummy && dummy.next.item == oldItem;
                //开始出队
                //事件 E1
                dummy.next.item = null;
                //出队中
                //状态S2
                assert dummy = curDummy && dummy.next.item = null;
                //事件E2
                dummy = dummy.next;
                //结束出队
                //出队后
                //状态 S3, 合并为S1
                assert dummy= curNext && dummy.next.item != null;
            }
        }
        ```
        - 状态
            - 状态S1：事件E1执行前，dummy指向实际的dummy节点curDummy，dummy.next.item== oldItem。
                如消费者C1、C2都还没有触发出队时，队列处于状态S1；消费者C1完成入队C2还没触发出队时，队列处于状态S1。
            - 状态S2：事件E1执行后、E2执行前，dummy指向旧的dummy节点curDummy，dummy.next.item==null。
            - 状态S3：事件E2执行后，dummy指向新的dummy节点curNext，dummy.next.item!=null。这在本质上同状态S1是一致的，合并。
            
        - 状态转换：
            - 状态转换T1：S1->S2，即dummy.next.item = null。
            - 状态转换T2：S2->S1，即dummy = dummy.next。
   
    - 先将 dummy = dummy.next, 然后返回 oldItem
        ```java
        public class Dummy{
            public Dummy(){
                dummy = new Node(null, null);
            }
            
            void poll(){
                curDummy = dummy;
                curNext = curDummy.next;
                oldItem = curNext.item;
                // 出队前
                // 状态S1
                assert dummy == curDummy && dummy.item == null; 
                // 开始出队
                dummmy = dummy.next; // 事件E1
                // 出队中
                // 状态S2
                assert dummy == curNext && dummy.item == oldItem; 
                // 事件E2
                dummy.item = null; 
                // 结束出队
                // 出队后
                // 状态S3，合并到状态S1
                assert dummy == curNext && dummy.item == null; 
            }
        }
        ```
        - 状态
            - 状态S1：事件E1执行前，dummy指向实际的dummy节点curDummy，dummy.item == null。
                如消费者C1、C2都还没有触发出队时，队列处于状态S1；消费者C1完成入队C2还没触发出队时，队列处于状态S1。
            - 状态S2：事件E1执行后、E2执行前，dummy指向新的dummy节点curNext，dummy.item == oldItem。
            - 状态S3：事件E2执行后，dummy指向新的dummy节点curNext，dummy.item == null。显然同状态S1，合并。
            
        - 状态转换：
            - 状态转换T1：S1->S2，即dummmy = dummy.next。
            - 状态转换T2：S2->S1，即dummy.item = null。
4. 一个 trick
    - 可以去掉dummy node，用head维护头结点+一步状态转换完成出队。
    - 去掉了dummy node，那么head.item的初始状态就是非空的，下面是简化的状态机。
    ```java
    public class Head{
        void poll(){
            curHead = head;
            curNext = head.next;
            oldItem = curHead.item;
            //出队前
            // S1
            assert head == curHead;
            //出队
            // E1
            head = head.next;
            //出队后
            assert head == curNext;
        }
    }
    ```
    - 单状态的状态机
        - 状态S1：head指向实际的头节点curHead。队列始终处于状态S1。
        - 状态S2：head指向新的头节点curNext。同S1，合并
    - 状态转换
        - 状态转换T1：S1->S1，即head = head.next。
        
### 其他特殊情况
1. 队列空
    - 队列处于一个特殊的状态，从该状态出发，仅能完成入队相关的状态转换——通俗讲就是队列空时只允许入队操作。
    - 这时消除竞争很简单，只允许入队不允许出队即可
2. 队列长度等于1