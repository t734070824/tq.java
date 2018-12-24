2018-07-11

## 程序分析

### TimeServerHandler
1. channelActive
    - ChannelHandlerContext.alloc() 得到一个**当前**的 ByteBufAllocator
    - writeAndFlush vs write
        - write: 写入缓冲区, 还未写入到通道
        - writeAndFlush: 写入缓冲区, 并写入到通道
    - Netty 的操作都是异步的，例如下面代码中的消息在被发送之前可能会被先关闭连接
        - Channel ch = ...;
        - ch.writeAndFlush(message);
        - ch.close();
    - ChannelFuture 增加一个 ChannelFutureListener 来监听操作完成事件，并关闭 Channel
    - f.addListener(ChannelFutureListener.CLOSE);
    
### Server
1. 服务端需要两个 NioEventLoopGroup
    - bossGroup：处理客户端连接事件的线程池
    - workerGroup：处理连接后所有事件的线程池
    - 使用同一个也是可以的
2. 设置 EventLoopGroup 参数
    - option：用于设置 bossGroup 的相关参数
    - childOption：用于设置workerGroup相关参数
    
### 客户端 
![](1.jpg)

1. 有没有 future.channel().closeFuture() 区别
    - 连接成功后 走 finally
    - 直接关闭连接
    - 猜测: 服务器发送数据时, 看连接已经关闭, 就不发数据了
    
### pipeline
1. 为什么TimeDecoder放在Server中不起作用呢
    - 归根到底 ChannelHandler 是对事件的处理, Server没有read事件啊啊啊..
  
  
### QA
1. 服务端发送的数据是一个 32位 的时间戳，如果服务端发送了 16位 的数据呢
    - ChannelHandler 内部处理
    - 增加一个Decoder
  
    