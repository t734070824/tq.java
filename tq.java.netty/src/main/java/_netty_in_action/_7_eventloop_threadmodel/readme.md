2018-01-24

### 事件/任务 的执行顺序
1. 事件和任务是以 FIFO 的顺序执行的. 这样可以保证字节内容总是按照正确的顺序被处理, 消除潜在的数据破坏的可能性

### EventLoop 的类层次结构
![](https://github.com/t734070824/tq.java/blob/master/tq.java.netty/src/main/java/_netty_in_action/_7_eventloop_threadmodel/1.png?raw=true)

### 线程管理
1. Netty线程模型的卓越性能取决于对于当前执行的Thread的身份的确定 --> 通过调用 EventLoop 的 inEventLoop(Thread)方法实现


### 线程模型
1. 类似 多线程Reactor模式
2. 每个 bind(), accept(), read(), write() 就是一个任务
3. 轮询监听的IO事件
4. 循环执行阻塞selector.select(timeoutMIllis)操作
5. 参考:https://www.jianshu.com/p/38b56531565d