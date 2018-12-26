2018-12-16

## LockSupport

### 两个函数
1. public native void unpark(Thread jthread);
2. public native void park(boolean isAbsolute, long time);

### 许可
1. unpark函数为线程提供 许可(permit)
2. 线程调用park函数则等待 许可
3. 这个有点像信号量，但是这个“许可”是不能叠加的，“许可”是一次性的。

### 顺序无关
1. unpark函数可以先于park调用
2. 比如线程B调用unpark函数，给线程A发了一个“许可”，那么当线程A调用park时，它发现已经有“许可”了，那么它会马上再继续运行。

### vs wait/notify/notifyAll
1. wait 和 notify/notifyAll 需要严格的调用顺讯顺序
2. **park/unpark模型真正解耦了线程之间的同步，线程之间不再需要一个Object或者其它变量来存储状态，不再需要关心对方的状态。**