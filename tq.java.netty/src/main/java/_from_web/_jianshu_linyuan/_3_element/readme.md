2018-07-12

## 元素

### ChannelPipeline
1. 容器
2. 保存 ChannelHandler, ChannelHandlerContext
3. 控制事件 流动
4. 新建一个 Channel 会自动新建一个 ChannelPipeline
5. 入站 与 出站 顺序 相反

### ChannelHandler
1. out, in
2. Duplex
3. SimpleChannelInboundHandler
    - 继承自 ChannelInboundHandlerAdapter，处理特定类型的消息
4. LoggingHandler
    - 在方法开始前 添加日志 拦截(代理)
5. ChunkedWriteHandler
    - 来处理大文件的传输
    - Channel ch = ...;
    - ch.write(new ChunkedFile(new File("video.mkv"));

### ChannelHandlerContext
1. 是 ChannelHandler 与 ChannelPipeline 之间的关系
2. Channel 1--1 ChannelPipeline
3. ChannelHandlerContext 1--1 ChannelHandler
4. **一个 ChannelHandler 可以对应多个 ChannelHandlerContext**