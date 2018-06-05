2018-01-24

## ChannelHandler ChannelPipeline

### 资源管理
1. //TODO 内存泄漏检测


### ChannelHdnler 的执行与阻塞
1. 通常 ChannelPipeline 中的 每一个 ChannelHandler 都是通过它的 EventLoop (I/O 线程)来处理传递给它的事件.
所以至关重要的是 **不要阻塞这个线程,因为这会对整体的 I/O 处理产生负面的影响**

### 触发事件
1. ChannelPipeline 保存了与 Channel 相关联的 ChannelHandler；
1. ChannelPipeline 可以根据需要，通过添加或者删除 ChannelHandler 来动态地修改；
1. ChannelPipeline 有着丰富的 API 用以被调用，以响应入站和出站事件。 

### ChannelHandlerContext
1. ChannelHandlerContext 代表了 ChannelHandler 和 ChannelPipeline之间的关联, 每当有 ChannelHandler 添加到 ChannelPipeline 中时，都会创建 ChannelHandlerContext
2. 
2. ChannelHandlerContext 和 ChannelHandler 之间的关联是永远不会改变的, 缓存它的引用是安全的的
3. 相对于其他类的同名方法， **ChannelHandlerContext 的方法将产生更短的事件流， 应该尽可能地利用这个特性来获得最大的性能**

### ChannelHandlerContext API
1. alloc: 返回和这个实例相关联的 Channel 所配置的 ByteBufAllocator
2. read: 将数据从Channel读取到第一个入站缓冲区；如果读取成功则触
         发一个channelRead事件，并（在最后一个消息被读取完成后）
         通 知 ChannelInboundHandler 的 channelReadComplete
         (ChannelHandlerContext)方法
3. write: 通过这个实例写入消息并经过 ChannelPipeline
3. writeAndFlush: 通过这个实例写入并冲刷消息并经过 ChannelPipeline



### Channel ChannelPipeline
1. 每一个新创建的Channel都会被分配一个新的 ChannelPipeline.
2. Channel既不能附加到另外一个 ChannelPipeline, 也不能分离当前的
3. **是不是意味着 线程安全???**


### Channel、 ChannelPipeline、 ChannelHandler 以及 ChannelHandlerContext 之间的关系
![](https://github.com/t734070824/tq.java/blob/master/tq.java.netty/src/main/java/_netty_in_action/_6_channelhandler_channelpipeline/1.png?raw=true)


### Pipeline 数据流转方向确定
1. 处理入站数据时, 总是查找当前 AbstractChannelHandlerContext.head.next
2. 处理出站数据时, 总是查找当前 AbstractChannelHandlerContext.tail.prev
3. 通过 instanceof 确定是 inbound 还是 outbound
4. 在查找下一个 AbstractChannelHandlerContext, 会跳过与据流转方向不符的 bound -->  `` while (!ctx.inbound)   while (!ctx.outbound)`` 

### ChannelHandler 和 ChannelHandlerContext 的高级用法
1. 可以通过将 ChannelHandler 添加到 ChannelPipeline 中来实现动态的协议切换
2. 缓存到 ChannelHandlerContext 的引用以供稍后使用，这可能会发生在任何的 ChannelHandler 方法之外，甚至来自于不同的线程



