2018-01-24

## ChannelHandler ChannelPipeline

### 资源管理
1. //TODO 内存泄漏检测

### 

### ChannelHdnler 的执行与阻塞
1. 通常 ChannelPipeline 中的 每一个 ChannelHandler 都是通过它的 EventLoop (I/O 线程)来处理传递给它的事件.
所以至关重要的是 **不要阻塞这个线程,因为这会对整体的 I/O 处理产生负面的影响**

### ChannelHandlerContext
1. ChannelHandlerContext 代表了 ChannelHandler 和 ChannelPipeline之间的关联, 每当有 ChannelHandler 添加到 ChannelPipeline 中时，都会创建 ChannelHandlerContext
2. ChannelHandlerContext 和 ChannelHandler 之间的关联是永远不会改变的, 缓存它的引用是安全的的
3. 相对于其他类的同名方法， **ChannelHandlerContext 的方法将产生更短的事件流， 应该尽可能地利用这个特性来获得最大的性能**

### Channel、 ChannelPipeline、 ChannelHandler 以及 ChannelHandlerContext 之间的关系
![](https://github.com/t734070824/tq.java/blob/master/tq.java.netty/src/main/java/_netty_in_action/_6_channelhandler_channelpipeline/1.png?raw=true)

### Channel ChannelPipeline
1. 每一个新创建的Channel都会被分配一个新的 ChannelPipeline.
2. Channel既不能附加到另外一个 ChannelPipeline, 也不能分离当前的
3. **是不是意味着 线程安全???**

### Pipeline 数据流转方向确定
1. 处理入站数据时, 总是查找当前 AbstractChannelHandlerContext.next
2. 处理出站数据时, 总是查找当前 AbstractChannelHandlerContext.prev
3. 通过 instanceof 确定是 inbound 还是 outbound
4. 在查找下一个 AbstractChannelHandlerContext, 会跳过与据流转方向不符的 bound -->  `` while (!ctx.inbound)   while (!ctx.outbound)`` 

### ChannelHandler 和 ChannelHandlerContext 的高级用法
1. 可以通过将 ChannelHandler 添加到 ChannelPipeline 中来实现动态的协议切换
2. 缓存到 ChannelHandlerContext 的引用以供稍后使用，这可能会发生在任何的 ChannelHandler 方法之外，甚至来自于不同的线程



