2017-11-16

## ThreadPoolExecutor

### 源码分析
1. 变量
    - private final AtomicInteger **ctl** = new AtomicInteger(ctlOf(RUNNING, 0));
        - 所有有效线程的数量(低29位)
        - 各个线程状态(runState)(高3位)
            - RUNNING:-536870912
            - SHUTDOWN:0
            - STOP:536870912
            - TIDYING:1073741824
            - TERMINATED:1610612736
    - corePoolSize
    - keepAliveTime
2. 方法
    - public void execute(Runnable command)
        - 活动线程小于corePoolSize的时候创建新的线程；
        - 活动线程大于corePoolSize时都是先加入到任务队列当中；
        - 任务队列满了再去启动新的线程，如果线程数达到最大值就拒绝任务。
2. 内部类
    - final class Worker extends AbstractQueuedSynchronizer implements Runnable ...
        - 内部类Worker是对任务的封装，所有submit的Runnable都被封装成了Worker，
        - 它本身也是一个Runnable， 
        - 然后利用AQS框架实现了一个简单的非重入的互斥锁， 
        - **实现互斥锁主要目的是为了中断的时候判断线程是在空闲还是运行**
        - 之所以不用ReentrantLock是为了避免任务执行的代码中修改线程池的变量，如setCorePoolSize，因为ReentrantLock是可重入的。

### 任务执行
1. 当调用 execute() 方法添加一个任务时
    - 如果正在运行的线程数量小于 corePoolSize，那么马上创建线程运行这个任务
    - 如果正在运行的线程数量大于或等于 corePoolSize，那么将这个任务放入队列
    - 如果这时候队列满了，而且正在运行的线程数量小于 maximumPoolSize，那么还是要创建线程运行这个任务
    - 如果队列满了，而且正在运行的线程数量大于或等于 maximumPoolSize，那么线程池会抛出异常，告诉调用者“我不能再接受任务了”
2. 当一个线程完成任务时，它会从队列中取下一个任务来执行
3. 当一个线程无事可做，超过一定的时间（keepAliveTime）时，线程池会判断，如果当前运行的线程数大于 corePoolSize，那么这个线程就被停掉。
所以线程池的所有任务完成后，它最终会收缩到 corePoolSize 的大小    
4. 举例: 假设队列大小为 10，corePoolSize 为 3，maximumPoolSize 为 6，那么当加入 20 个任务时，执行的顺序就是这样的
    - 首先执行任务 1、2、3，然后任务 4~13 被放入队列
    - 这时候队列满了，任务 14、15、16 会被马上执行，而任务 17~20 则会抛出异常
    - 最终顺序是：1、2、3、14、15、16、4、5、6、7、8、9、10、11、12、13
    

### old
1. 只有任务都是同类型的并且相互独立时,线程池的性能才能达到最佳.如果将运行时间较长的任务和运行时间较短的任务
	混合在一起,除非线程池很大,否则将可能造成阻塞.如果提交的任务依赖与其他任务,除非线程池无限大,否则可能造成死锁
	---摘自 java并发编程实战
2. 带有时间监控的 ThreadPoolExecutor-->TimingThreadPool,
3. 当工作队列被填满的后,没有预定义的饱和策略来阻塞execute.然而,可以通过使用Semaphore(信号量)来限制
   任务的到达率,设置信号量的上界设置为线程池的大小加上可排队的任务的数量,这是因为信号量需要控制正在执行的和等待
   执行的任务的数量-->BoundedExecutor
4. 内部类Worker是对任务的封装,所有的submit的Runnable都封装成了Worker,他本身也是一个Runnable，然后利用AQS实现一个简单
非重入的互斥锁.实现互斥锁主要目的是为了中断的时候判断线程是在空闲还是运行
5. Q: 为什么是不可重入,比如使用ReentrantLock?
6. A: 是为了避免任务执行的代码中修改线程池的变量，如setCorePoolSize，因为ReentrantLock是可重入的。

### 线程创建
```$xslt
// Check if queue empty only if necessary.
// 这条语句等价：rs >= SHUTDOWN && (rs != SHUTDOWN || firstTask != null ||
// workQueue.isEmpty())
// 满足下列调价则直接返回false，线程创建失败:
// rs > SHUTDOWN:STOP || TIDYING || TERMINATED 此时不再接受新的任务，且所有任务执行结束
// rs = SHUTDOWN:firtTask != null 此时不再接受任务，但是仍然会执行队列中的任务
// rs = SHUTDOWN:firtTask == null见execute方法的addWorker(null,
// false)，任务为null && 队列为空
// 最后一种情况也就是说SHUTDONW状态下，如果队列不为空还得接着往下执行，为什么？add一个null任务目的到底是什么？
// 看execute方法只有workCount==0的时候firstTask才会为null结合这里的条件就是线程池SHUTDOWN了不再接受新任务
// 但是此时队列不为空，那么还得创建线程把任务给执行完才行。
if (rs >= SHUTDOWN && !(rs == SHUTDOWN && firstTask == null && !workQueue.isEmpty()))
    return false;
```

### shutdown
1. **Shutdown 不阻塞**