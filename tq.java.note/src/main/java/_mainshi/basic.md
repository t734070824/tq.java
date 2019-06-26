### 基础
1. Concurrenthashmap 
    - 为什么要用红黑树？为何不用其他的树，平衡二叉树，b+？
        - ***
        - 20181220 数据结构部分 未看
        - AVL 树是高度平衡的，频繁的插入和删除，会引起频繁的reblance，导致效率下降
        - 红黑树不是高度平衡的，算是一种折中，插入最多两次旋转，删除最多三次旋转
        - BTree vs 平衡二叉树(红黑树)
            - 因为都在内存中, 红黑树可以了
            - 大量数据(文件系统) 就需要用到 Btree 
    - 数据结构
        - 数组 + 链表 + 红黑树
    - 锁分段, 读是否加锁, 迭代器是强一致性还是 弱一致性
        - TODO
    - 如何提高并发度
        - ForwardNode, 多线程并发扩容
1. hashmap
    - 如何给hashmap的key对象设计他的 hashcode
        - 扰动函数, 高低位异或
    - HashMap 多线程下的扩容死循环问题
        - jdk1.7
            - 转移数据操作 = 按旧链表的正序遍历链表、在新链表的头部依次插入，即在转移数据、扩容后，容易出现链表逆序的情况
            - 并发扩容--环形链表
            - 查询死循环
        - jdk1.8
            - 按旧链表的逆序遍历链表, 转移后如果在同一个index 顺序不变
    - hashmap的底层实现
        - 数组+链表+红黑树
        - 16, 8
        - 0.75f
        - 扩容 2次幂
            - length -1 正好是一个低位掩码, 直接做移位操作
            - 在扩容的时候, 老的元素要么在 oldIndex, 要么在 oldIndex + oldCap
    - vs LinkedHashMap vs TreeMap
        - Map 
        - Map + 链表
            - 访问数据
            - LRU 
        - compare + 红黑树
            - 不再有数组
    - 为什么不推荐可变对象 key
        - hashcode 会变化
        - 有可能 出现 同一个对象 充当多个key
1. 对象相同 x.equals(y) == true, 会出现 x.hashcode != y.hashcode
    - 规范是  x.equals(y) == true -->  x.hashcode == y.hashcode
    - 不按规范来 或者 不重写 hashcode 可以出现这个情况
1. ArrayList
    - 数据结构
        - 数组
    - 初始容量
        - 10, 最好设置初始容量, 防止频繁扩容
    - 扩容
        - size + 1 > capacity
        - newCapacity = oldCapacity + oldCapacity >> 1
        - 1.5倍
2. LinkedList
    - 链表, 无容量限制
3. bytes --> long
4. lru Cache
    - 链表+hashMap
    - LinkedHashMap
6. CAS, 什么情况下不适合用CAS
    - 循环时间长开销大(争用比较激烈)
    - 只能保证一个共享变量的原子操作
    - ABA

8. 线程池 参数的意义
    - 核心
    - 最大
    - 时间单位
    - 时间
    - 任务队列
    - 工厂
    - 队列满的任务拒绝策略
9. 使用无界阻塞队列会出现的问题
    - OOM
11. ThreadLocal
    - 基础
        - Thread --> ThreadLocalMap --> Entry=ThreadLocalMap.get(this)
        - 当前 ThreadLocal 为 key, 链表逐个比较, **不是一个 MAP**
    - 内存泄漏
        - key --> ThreadLocal Weak
        - gc 回收 null --> value无法被回收
        - 没有调用 get set remove
    - 为什么不用 强引用
        - 强引用无法被回收, 因为有 Thread --> threadLocal --> threadLocalMap 引用链
        - 根本问题 不是是否使用强引用的问题 而是 ThreadLocal 和 Thread 的生命周期一样
        - 主动 remove
    - ThreadLocal的使用场景
        - 不是用来解决多线程并发的
        - 想共享又不想加锁
        - connection
12. ThreadPoolExecutor 内部原理
13. NIO
    - IO 和  NIO的区别 
        - TODO
    - 零拷贝, 堆外内存
        - Direct Buffers
        - CompositeByteBuf
        - wrap(byte[]) 
        - ByteBuf.silce
        - FileRegion 包装的FileChannel.tranferTo
14. 顺序加锁
15. 快速失败(fast-fail) 和 安全失败(fail-safe)的区别
    - [](../../../../../tq.java.basic/src/main/java/_collection/fast_safe_fail.md)        
    - 如果迭代过程中发生了改变, 但是灭有 next调用 迭代, 那么 CME 就不会抛出
    - fast-fail
        - 报错, 线程不安全
    - fail-safe
        - 线程安全的类
        - 数据不一致
16. finalize()
    - 对象不可达 判断是否需要调用
    - 唯一一次逃逸的机会
    - 只有一次
    - 不保证运行完
17. 反射(反射机制, 反射性能, 如何优化) private
    - 可以理解为一个标签
    - 至于你想那这个标签干什么, 那是 后面解析器的事情
    - AOP,DI 动态代理只是 反射应用罢了, 而不是说: 反射是用代理实现的
18. 乐观锁
    - CAS
    - 先获取, 修改, 然后假设没有其他人获取锁
19. hash冲突
    - equal
    - 链表
    - 红黑树
20. 锁类型(偏向锁, 轻量级锁, 自旋锁, 锁升级)
    - TODO
    - 升级和降级
    - [](../../../../../tq.java.concurrent/src/main/java/_synchronized/readme.md)
21. JDK1.8 新特性
    - lambda
    - stream
22. java线程之间通信
    - sync, notify, wait
    - lock, condition
    - volatile
    - queue
24. 同步器
    - countDownLatch
    - Semaphore
    - ReentrantLock
25. String为什么可以用 + 操作, StringBuffer StringBuilder
    - 实现 TODO
26. 两个方法完全相同可以重载吗
    - ***
    - 20181219 跳过
27. try里面的return, finally 在 return, 哪个会返回, 字节码如何体现的
29. 如何让一个线程放弃锁, 放弃锁之后什么时候才可以再次获取锁
    - wait
    - yield
30. 如何实现自定义注解
    - 这就是一个标记
    - 需要一解析器
    - 反射
31. final finally finalize
32. (short s1 =1;s1 = s1 +1) (short s1 =1;s1 += 1)
33. runtimeException
    - error : 无需捕获, 系统错误
    - Exception
        - runtimeException, IOException
34. 分析线程池的实现原理和线程的调度过程
    - core: 有任务直接创建
    - max: queue 满创建
    - queue: 达到 core, 添加进 queue
    - queue满, max, 任务拒绝策略
35. Java 8的内存分代改进
     - ***
     - 20181220 跳过
36. 用hashmap实现redis有什么问题（死锁，死循环，可用 ConcurrentHashmap）
    - 死循环 
    - ConcurrentHashmap 源码 
    - 扩容
37. 线程的状态
    - new Thread() 
    - Runnable 
    - Running 
    - Block
        - wait
        - lock pool
        - sleep, join
    - dead 
38. 线程的阻塞的方式
    - wait
    - lock pool
    - sleep, join
39. sleep和wait的区别
    - 锁
41. 两个Integer的引用对象传给一个swap方法在方法内部交换引用，返回后，两个引用的值是否会发现变化
    - TODO
    - 不会变化 TODO
    - java 内存模型 主内存 线程本地内存
    - 内存的拷贝
42. IO会阻塞吗？
    - readLine是不是阻塞的??
43. 字符串的格式化方法 （20，21这两个问题问的太低级了）
44. 时间的格式化方法
45. 定时器用什么做的
    - TODO
46. 线程如何退出结束
    - TODO
    - 正常停止
    - while
    - interrupt
47. java有哪些锁？
    - 乐观锁 
    - 悲观锁 
    - synchronized 
    - 可重入锁 
    - 读写锁,
    - reentrantlock与 synchronized 的区别
        - 锁中断
        - 尝试获取
        - 底层实现
        - synchronized
            - monitorenter, monitorexit
49. ConcurrentHashmap的锁是如何加的？是不是分段越多越好
    - jdk7 VS jdk8
    - TODO
50. hashmap如果只有一个写其他全读会出什么问题
    - 死锁
51. volatile的用途
    - 免锁
    - 单例
    - 主内存
    - java内存模型
        - 保证可见性
    - 防止重排序
    - **和 CAS 结合 保证一致性**
52. 读写锁
    - 读时复制
    - 写独锁
    - 读读
53. 线程安全的单例模式
    - volatile    
54. concurrenthashmap 求size是如何加锁的，如果刚求完一段后这段发生了变化该如何处理
    - jdk7 全部加锁
    - TODO jdk8
    - LongAdder
55. 可重入的读写锁，可重入是如何实现的？
    - Thread身份
    - TODO
56. 可重入锁中对应的wait和notify
    - await()
    - signal
57. java线程池中基于缓存和基于定长的两种线程池，当请求太多时分别是如何处理的？定长的事用的队列，如果队列也满了呢？
    交换进磁盘？基于缓存的线程池解决方法呢？
    - TODO
58. 可重入锁中的lock和trylock的区别
    - trylock 失败 直接放入队列
    - lock 失败 自旋
59. LinkedHashmap的底层实现
    - map+链表
    - LRU
60. java的反射是如何实现的【阿里巴巴面试题目含答案】
    - RTTI
61. 动态代理的几种实现方式及优缺点
    - jdk
    - cglib
62. 按线程池内部机制.当提交新任务时.有哪些异常要考虑？
    - 任务拒绝异常
63. private
    - private 修饰的方法可以通过反射访问, 那么private的意义是什么?
        - private 并不是一种安全机制, 仅是一种作用域的声明
        - private 的存在可以让一个类看起来不是那么复杂
64. java类的初始化顺序
    - 父类--静态变量
    - 父类--静态初始化块
    - 子类--静态变量
    - 子类--静态初始化块
    - 父类--变量
    - 父类--初始化块
    - 父类--构造器
    - 子类--变量
    - 子类--初始化块
    - 子类--构造器
65. 局部变量使用前需要显式的赋值, 否则编译不了, 为什么这么设计
    - 对于成员变量而言，其赋值和取值访问的先后顺序具有不确定性，对于成员变量可以在一个方法调用前赋值，
    也可以在方法调用后进行，这是运行时发生的，编译器确定不了，交给jvm去做比较合适。
    - 而对于局部变量而言，其赋值和取值访问顺序是确定的。
    - 这样设计是一种约束，尽最大程度减少使用者犯错的可能
66. ReadWriteLock 读写之间互斥吗
    - 只有读读 不互斥
    - 写 和 其他都互斥
    - **如果读取执行情况很多，写入很少的情况下，使用 ReentrantReadWriteLock 可能会使写入线程遭遇饥饿（Starvation）问题，
        也就是写入线程吃吃无法竞争到锁定而一直处于等待状态**
67. 同步与互斥
    - Barrier，Semaphore是专门来解决同步的
    - 互斥是通过竞争对资源的独占使用，彼此之间不需要知道对方的存在，执行顺序是一个乱序。
    - 同步是协调多个相互关联线程合作完成任务，彼此之间知道对方存在，执行顺序往往是有序的。
68. AQS
    - 双向队列
    - 队列的第一个开始运行
    - tryLock, tryRelease
69. JDK9 模块化
    - TODO
1. StampedLock 锁原理的理解？
1. 谈下对基于链表的非阻塞无界队列 ConcurrentLinkedQueue 原理的理解？
    - 无锁
    - cas, 减少cas 次数
    - 出队入队无竞争, 哨兵节点
    - 延迟设置 tail
    - **允许不一致**
1. ConcurrentLinkedQueue 内部是如何使用 CAS 非阻塞算法来保证多线程下入队出队操作的线程安全？
    - 状态机
1. 基于链表的阻塞队列 LinkedBlockingQueue 原理。
    - put,take Lock
    - Condition
1. 阻塞队列 LinkedBlockingQueue 内部是如何使用两个独占锁 ReentrantLock 以及对应的条件变量保证多线程先入队出队操作的线程安全？
    - 放入前队列满: notFull.await()
    - 放入后队列不满: notFull.signal()
    - 放入前队列=0: notEmpty.signal()
1. 分析下JUC 中倒数计数器 CountDownLatch 的使用与原理？
1. CountDownLatch 与线程的 Join 方法区别是什么？
    - CountDownLatch:
        - AQS 队列, LockSupport
    - Join
        - Object.wait()
1. 讲讲对JUC 中回环屏障 CyclicBarrier 的使用？
1. CyclicBarrier内部的实现与 CountDownLatch 有何不同？
1. Semaphore 的内部实现是怎样的？
1. 并发组件 CopyOnWriteArrayList 是如何通过写时拷贝实现并发安全的 List？
    - lock.lock()
1. 进程和线程的区别
    - TODO
1. Nio select() 不阻塞的原因
    - 在部分Linux的2.6的kernel中，poll和epoll对于突然中断的连接socket会对返回的eventSet事件集合置为POLLHUP，
    - 也可能是POLLERR，eventSet事件集合发生了变化，这就可能导致Selector会被唤醒
1. fair unfair 的区别
    - fair
        - acquire(1)
    - unfair
        - **compareandSetState**
        - setExclusiveOwnerThread
1. AQS 如何来竞争锁
    - compareandSetState(curState, expState)
1. Iterator 是什么
    - 一种设计模式
    - 顺序访问聚合数据的一个对象, 屏蔽底层实现细节
1. ArrayList vs Array
    - ArrayList
        - 可变长度
        - TODO
    - Array
        - 固定长度