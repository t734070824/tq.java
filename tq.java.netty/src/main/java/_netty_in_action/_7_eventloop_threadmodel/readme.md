2018-01-24



### 事件/任务 的执行顺序
1. 事件和任务是以 FIFO 的顺序执行的. 这样可以保证字节内容总是按照正确的顺序被处理, 消除潜在的数据破坏的可能性

### EventLoop 的类层次结构
![](https://github.com/t734070824/tq.java/blob/master/tq.java.netty/src/main/java/_netty_in_action/_7_eventloop_threadmodel/1.png?raw=true)

### 线程管理
1. Netty线程模型的卓越性能取决于对于当前执行的Thread的身份的确定 --> 通过调用 EventLoop 的 inEventLoop(Thread)方法实现
2. **确定它是否是分配给当前channel以及它的EventLoop的那一个线程**
3. 如果当前调用线程是支撑 EventLoop 的线程, 那么代码将直接执行
4. 否则, EventLoop 将调度任务以便稍后执行, 放入内部队列中, 
5. **每个 EventLoop 都有自己的任务队列, 独立于其他任何的 EventLoop**

### EventLoop/线程的分配
1. 


### 线程模型
1. 类似 多线程Reactor模式
2. 每个 bind(), accept(), read(), write() 就是一个任务
3. 轮询监听的IO事件
4. 循环执行阻塞selector.select(timeoutMIllis)操作
5. 参考:https://www.jianshu.com/p/38b56531565d