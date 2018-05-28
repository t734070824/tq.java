2017-05-28

## 传输

### 内置的传输
1. NIO--非阻塞IO
    - OP_ACCEPT 请求在接受新连接并创建 Channel 时获得通知
    - OP_CONNECT 请求在建立一个连接时获得通知
    - OP_READ 请求当数据已经就绪，可以从 Channel 中读取时获得通知
    - OP_WRITE 请求当可以向 Channel 中写更多的数据时获得通知。这处理了套接字缓冲区被完
      全填满时的情况，这种情况通常发生在数据的发送速度比远程节点可处理的速度更
      快的时候
2. Epoll
    - 只需要将 NioEventLoopGroup
      替 换 为 EpollEventLoopGroup ， 
    - 并 且 将 NioServerSocketChannel.class 替 换 为
      EpollServerSocketChannel.class 即可
3. 
