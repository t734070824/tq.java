2017-01-22

## 第一个 Netty程序

### ChannelHandler
1. 针对不同类型的事件来调用ChannelHandler
2. 应用程序通过事件或者是 扩展 ChannelHandler 来**挂钩到事件的生命周期**, 并提供自定义的应用逻辑 
3. 在架构上， ChannelHandler 有助于保持业务逻辑与网络处理代码的分离

### ChannelInitializer
1. 当一个新的连接
   被接受时，一个新的子 Channel 将会被创建，而 ChannelInitializer 将会把一个你的
   EchoServerHandler 的实例添加到该 Channel 的 ChannelPipeline 中。
2. //TODO 是否可以直接 childHandler(EchoServerHandler), 这样会有什么区别??


### 如果不捕捉异常,会怎样??
1. 每个 Channel 都拥有一个与之相关联的 **ChannelPipeline**，其持有一个 ChannelHandler 的
   实例链。在默认的情况下， ChannelHandler 会把对它的方法的调用转发给链中的下一个 ChannelHandler。
   因此，如果 exceptionCaught()方法没有被该链中的某处实现，那么所接收的异常将会被
   传递到 ChannelPipeline 的尾端并被记录。为此，你的应用程序应该提供至少有一个实现了
   exceptionCaught()方法的 ChannelHandler
   
### Client.SimpleChannelInboundHandler vs Server.ChannelInboundHandlerAdapter
1. 业务逻辑如何处理消息以及 Netty 如何管理资源 ???
    - 在客户端，当 channelRead0()方法完成时，你已经有了传入消息，并且已经处理完它了。
    - 当该方法返回时， SimpleChannelInboundHandler **负责释放指向保存该消息的 ByteBuf 的内存引用。**
    - 在 EchoServerHandler 中，你仍然需要将传入消息回送给发送者，而 write()操作是异步的，直
    - 到 channelRead()方法返回后可能仍然没有完成（如代码清单 2-1 所示）。
    - 为此， EchoServerHandler扩展了 ChannelInboundHandlerAdapter，其在这个时间点上不会释放消息。
      消息在 EchoServerHandler 的 channelReadComplete()方法中，当 writeAndFlush()方
      法被调用时被释放
    - //TODO ??


    