2018-04-25

## IO 对比
https://tech.meituan.com/nio.html

### BIO
1. 单线程处理连接, 主线程死循环等待新连接到来
2. 为新的连接创建新的线程
3. 优点:
    - 利用多核
    - 当I/O阻塞系统，但CPU空闲的时候，可以利用多线程使用CPU资源
4. 问题:
    - 严重依赖线程
    - 线程本身占用内存, 线程数过多, 对于整个 JVM 聂内存有影响
    - 线程切换成本较高: 可能导致线程切换的时间大于线程执行的时间, 导致系统 load 高,cpu使用率低
    
### 常见I/O模型的对比
![](https://github.com/t734070824/tq.java/blob/master/tq.java.basic/src/main/java/_nio/_io_compare/1.jpg?raw=true)      

### socket.read()为例子
1. 传统的BIO里面socket.read()，如果TCP RecvBuffer里没有数据，函数会一直阻塞，直到收到数据，返回读到的数据
2. 对于NIO，如果TCP RecvBuffer有数据，就把数据从网卡读到内存，并且返回给用户；反之则直接返回0，永远不会阻塞     
3. 最新的AIO(Async I/O)里面会更进一步：不但等待就绪是非阻塞的，就连数据从网卡到内存的过程也是异步的
4. **BIO里用户最关心“我要读”，NIO里用户最关心"我可以读了"，在AIO模型里用户更需要关注的是“读完了**

### 优化线程模型
1. 事件分发器, 单线程选择就绪的事件
2. I/O处理器, 包括 connect, read, write等, 开启CPu线程
3. 业务线程:
![](https://github.com/t734070824/tq.java/blob/master/tq.java.basic/src/main/java/_nio/_io_compare/2.jpg?raw=true)



### 每连接顺序请求的Redis
1. 对于Redis来说，由于服务端是全局串行的，能够保证同一连接的所有请求与返回顺序一致。
这样可以使用单线程＋队列，把请求数据缓冲。然后pipeline发送，返回future，然后channel可读时，直接在队列中把future取回来，done()就可以了

### 常见的RPC框架，如Thrift，Dubbo
1. 这种框架内部一般维护了请求的协议和请求号，可以维护一个以请求号为key，结果的result为future的map，结合NIO+长连接，获取非常不错的性能。

### 总结
1. 事件驱动模型
1. 避免多线程
1. 单线程处理多任务
1. 非阻塞I/O，I/O读写不再阻塞，而是返回0
1. 基于block的传输，通常比基于流的传输更高效
1. 更高级的IO函数，zero-copy
1. IO多路复用大大提高了Java网络应用的可伸缩性和实用性