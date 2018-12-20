208-12-20

## Timer
1. 可以按计划执行重复的任务或者定时执行指定任务
2. 线程安全

### TimerThread
1. 真正的执行线程
2. 也只有一个

### TimeTask
1. 实现了 Ruunable 接口, 需要自己扩展

### TaskQueue
1. TimerTask[]的优先队列
2. 数组实现, 二叉堆
3. [readme.md](https://github.com/t734070824/tq.java/blob/master/tq.java.arithmetic/src/main/java/_book/_algorithms_4th_edition/_2_rank/_2_4_priority_queue/readme.md)

### 问题
1.Timer在执行所有定时任务时只会创建一个线程。如果某个任务的执行时间长度大于其周期时间长度，那么就会导致这一次的任务还在执行，而下一个周期的任务已经需要开始执行了，当然在一个线程内这两个任务只能顺序执行，有两种情况：对于之前需要执行但还没有执行的任务，一是当前任务执行完马上执行那些任务（按顺序来），二是干脆把那些任务丢掉，不去执行它们。至于具体采取哪种做法，需要看是调用schedule还是scheduleAtFixedRate。 
2.如果TimerTask抛出了一个未检出的异常，那么Timer线程就会被终止掉，之前已经被调度但尚未执行的TimerTask就不会再执行了，
    新的任务也不能被调度了。