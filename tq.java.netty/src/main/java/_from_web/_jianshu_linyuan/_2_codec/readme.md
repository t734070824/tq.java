2018-07-12

## Codec

### 什么是 Codec
1. 将原始字节数据 与 程序需求数据 进行互转
2. **一旦一个消息被编码或解码它自动被调用 ReferenceCountUtil.release(message) ，
如果你稍后还需要用到这个引用而不是马上释放，你可以调用 ReferenceCountUtil.retain(message) 增加引用计数，
防止消息被释放**
3. 就是一个特殊的 ChannelHandler

### 