2018-05-25

## 其他

### 为什么Netty不用AIO而用NIO
1. Not faster than NIO (epoll) on unix systems (which is true)
1. There is no daragram suppport
1. Unnecessary threading model (too much abstraction without usage)

### 粘包/拆包
1. 产生原因
    - TCP 流, MTU < 总消息长度
    - 总长度 < MTU, 延迟确认, 分包
2. 解决
    - 消息定长: 大小固定, 不够 补空格
        - FixedLengthFrameDecoder
    - 尾部添加特殊分隔符 默认为 换行 "\n"
        - 行拆包器
            - LineBasedFrameDecoder
        - 分隔符拆包器
            - DelimiterBasedFrameDecoder
    - 将消息分为 消息头和 消息体
        - LengthFieldBasedFrameDecoder