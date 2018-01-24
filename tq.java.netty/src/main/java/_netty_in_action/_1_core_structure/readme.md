2018-01-22
### 核心结构

#### Future 回调 ChannelHandler
1. ChannelHandler:看做是传入(入站)或者传出(出站)数据的载体
2. 回调:一个指向已经被提供给另外一个方法的方法的引用,使得后者可以在适当的时候调用前者--ChannelHandler.channelActive()
3. Future(ChannelFuture):提供对结果的访问

#### 选择器 事件 EventLoop(事件环)
1. 通过触发事件将 Selector 从应用程序中抽象出来，消除了所有本来将需要手动编写
   的派发代码。 在内部，将会为每个 Channel 分配一个 EventLoop， 用以处理所有事件
2. EventLoop 本身只由一个线程驱动，其处理了一个 Channel 的所有 I/O 事件，并且在该
   EventLoop 的整个生命周期内都不会改变