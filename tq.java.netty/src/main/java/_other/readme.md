2018-05-25

## 其他

### 为什么Netty不用AIO而用NIO
1. Not faster than NIO (epoll) on unix systems (which is true)
1. There is no daragram suppport
1. Unnecessary threading model (too much abstraction without usage)