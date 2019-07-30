2018-04-19

## CountDownLatch

### 原理
1. state标识 需要释放(countDown)的次数
1. CountDownLatch(num): 标识要释放几次锁
2. 主线程 await(): 
    - tryAcquireShared(1), 查看当前是否已经全部释放 
    - protected int tryAcquireShared(int acquires) {return (getState() == 0) ? 1 : -1;}
        - 检查当前的state 是否被释放完
        - 使用 tryAcquireShared 方法 和 它起到的作用和方法名有差异
3. 没有全部释放, 加入等待队列, 设置 Signel, LockSupport.park() 
4. 当最后一次 countDown 之后, 由当前线程(countDown线程)唤醒靠近队列头部最近的等待node

### 使用场景
1. 实现最大的并行性：有时我们想同时启动多个线程，实现最大程度的并行性。例如，我们想测试一个单例类。
如果我们创建一个初始计数为1的CountDownLatch，并让所有线程都在这个锁上等待，那么我们可以很轻松地完成测试。我
们只需调用 一次countDown()方法就可以让所有的等待线程同时恢复执行。
2. 开始执行前等待n个线程完成各自任务：例如应用程序启动类要确保在处理用户请求前，所有N个外部系统已经启动和运行了。
3. 死锁检测：一个非常方便的使用场景是，你可以使用n个线程访问共享资源，在每次测试阶段的线程数目是不同的，并尝试产生死锁。