2017-01-22

### 如果不捕捉异常,会怎样??
1. 每个 Channel 都拥有一个与之相关联的 **ChannelPipeline**，其持有一个 ChannelHandler 的
   实例链。在默认的情况下， ChannelHandler 会把对它的方法的调用转发给链中的下一个 ChannelHandler。因此，如果 exceptionCaught()方法没有被该链中的某处实现，那么所接收的异常将会被
   传递到 ChannelPipeline 的尾端并被记录。为此，你的应用程序应该提供至少有一个实现了
   exceptionCaught()方法的 ChannelHandler
   
2.           