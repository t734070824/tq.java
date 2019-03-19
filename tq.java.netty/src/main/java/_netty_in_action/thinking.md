2018-12-04

## 思考
1. netty: udp vs tcp
2. udp:2048
    - TODO
3. Netty 怎么知道事件发生了...
    - TODO
4. 多个 Channel 共享一个 线程
4. 理解 Netty 中 write 异步所带来的影响
    - 连接什么时候关闭
5. 如何为一个 ByteBuf 增加一个当前可读数量

6. CompositeByteBuf
    - 扩容

6. ChannelPipeline 和 ctx 的关系
    - TODO
    
6. SimpleChannelInboundHandler 中的泛型中的对象是 怎么来的
    - 解码器
7. SimpleChannelInboundHandler 的特性
    - 主动释放 引用
    
8. 不要阻塞这个ChannelHandler线程,因为这会对整体的 I/O 处理产生负面的影响
    - 当前绑定的线程 阻塞