2019-08-06

## Netty 内存泄漏

### 出现的原因
1. 程序中使用的 ByteBuf 没有释放

### 没有释放的原因
1. 继承 ChannelInboundHandlerAdapter 但是没有 fireChannelRead

### in
1. 一般都是继承 SimpleChannelInboundHandler 
    - channelRead --> channelRead0 
    - channelRead 中有释放 byteBuf 的代码
    - ReferenceCountUtil.release(msg); 
2. 为什么继承了 ChannelInboundHandlerAdapter 然后在调用 fireChannelRead 就可以了
    - pipeline 初始化的时候会有 TailContext(in), HeadContext(in, out)
    - TailContext 在 read 中有释放的代码

### out
1. 没有明显的释放代码, 直接 writeAndFlush
    - headContext --> ChannelOutboundBuffer --> remove() --> ReferenceCountUtil.release(msg); 
    
### 如果监控内存泄漏
1. jvm启动参数
    - -Dio.netty.leakDetection.level=PARANOID
2. 程序参数
    - ResourceLeakDetector.setLevel(ResourceLeakDetector.Level.ADVANCED);
