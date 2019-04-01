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
        