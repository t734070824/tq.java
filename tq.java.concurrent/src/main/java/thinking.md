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