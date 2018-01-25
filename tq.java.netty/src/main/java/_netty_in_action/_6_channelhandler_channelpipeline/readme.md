2018-01-24

### ChannelHdnler 的执行与阻塞
1. 通常 ChannelPipeline 中的 每一个 ChannelHandler 都是通过它的 EventLoop (I/O 线程)来处理传递给它的事件.
所以至关重要的是 **不要阻塞这个线程,因为这会对整体的 I/O 处理产生负面的影响**

### ChannelHandlerContext
1. ChannelHandlerContext 代表了 ChannelHandler 和 ChannelPipeline之间的关联, 每当有 ChannelHandler 添加到 ChannelPipeline 中时，都会创建 ChannelHandlerContext
2. ChannelHandlerContext 和 ChannelHandler 之间的关联是永远不会改变的, 缓存它的引用是安全的的
3. 相对于其他类的同名方法， **ChannelHandler Context 的方法将产生更短的事件流， 应该尽可能地利用这个特性来获得最大的性能**

### Channel、 ChannelPipeline、 ChannelHandler 以及 ChannelHandlerContext 之间的关系
![](https://github.com/t734070824/tq.java/blob/master/tq.java.netty/src/main/java/_netty_in_action/_6_channelhandler_channelpipeline/1.png?raw=true)



