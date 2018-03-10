2017-11-16

### ThreadPoolExecutor
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