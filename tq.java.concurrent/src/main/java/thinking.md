2018-12-19

## 思考
1. 为什么 唤醒方法 必须在synchronized代码块或者synchronized方法调用
2. TimingThreadPool.addWorker(null, false/true), 增加一个 firsttask=null 的原因
    - TODO 
3. 在addWorker中, 有new Worker(), 其中有ThreadFactory.newThread(this) 的操作, 但是没有看到对这个Thread的调用啊
    - TODO 
3. ThreadPoolExecutor 是如何实现线程超时回收的
    - 借助 getTask 的超时
    - 阻塞队列
3. stream **单向, 不可往复, 只遍历一次**
    - 水流的方向, 
    - 所有的操作对于一条数据只执行一遍, 所有数据也只是遍历一遍, 
    - **就像水流的栅栏, 所留 只经过 所有的栅栏一次**
4. steam中 Intermediate 和 Terminal 操作的分界是什么
    - 

5. weak reference引用的对象是有价值被cache
    - gc
    - 容易被构建的
    - 价值较高的
1. 线程池为什么能维持线程不释放，随时运行各种任务？
    - 在 getTask() 中是一个死循环, 借助任务阻塞队列 workQueue, workQueue.take()方法
    - 工作队列workQueue会一直去拿任务，属于核心线程的会一直卡在 workQueue.take()方法，直到拿到Runnable 然后返回，
    - 非核心线程会 workQueue.poll(keepAliveTime, TimeUnit.NANOSECONDS) ，如果超时还没有拿到，
    - 下一次循环判断compareAndDecrementWorkerCount就会返回null,
    - Worker对象的run()方法循环体的判断为null,任务结束，然后线程被系统回收