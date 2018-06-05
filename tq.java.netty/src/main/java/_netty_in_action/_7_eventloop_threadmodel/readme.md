2018-01-24


### Boss/Worker EventLoopGroup
1. Netty服务器编程中需要BossEventLoopGroup和WorkerEventLoopGroup两个EventLoopGroup来进行工作
2. 一个 ServerSocketChannel 对应一个 Selector 和 一个 EventLoop线程
3. BossEventLoopGroup的线程数参数这是为1
4. **BossEventLoop负责接收客户端的连接并将SocketChannel交给WorkerEventLoopGroup来进行IO处理**
5. Boss EventloopGroup 负责 接收连接， worker EventloopGroup 负责处理以及读写

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

### JDK nio bug
```text
https://caorong.github.io/2016/12/24/head-first-netty-1/
for(;;){
    int selectedKeys = selector.select(timeoutMillis); // select with timeout
    selectCnt ++;
    // 我由于 select 阻塞 而等待了 timeoutMillis 毫秒， 说明， 我阻塞了，说明没有bug
    if (time - TimeUnit.MILLISECONDS.toNanos(timeoutMillis) >= currentTimeNanos) {
        selectCnt = 1;
    } else if (SELECTOR_AUTO_REBUILD_THRESHOLD > 0 &&
            selectCnt >= SELECTOR_AUTO_REBUILD_THRESHOLD) {
        // 在小于 timeoutMillis 毫秒的时间内 select 的次数超过了 阀值(512) 次
        rebuildSelector();
        selector = this.selector;

        selector.selectNow();// Select again
        selectCnt = 1;
        break;
    }
}
```

