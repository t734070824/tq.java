2019-07-21

## Time_Wait, Close_Wait

### Time_wait 是友好的
1. 发生在什么时候
    - 主动关闭的一方进入 time_wait, 被动的一方进入 close_wait
2. 为什么需要这个
    - 没有任何机制保证最后一次 ACK 能够正常传输, 
    - 网络上仍然有可能有残余的数据包, 必须能够正常处理

### 解决的问题
1. 假设最后一个 ACK 丢失
    - 被动关闭的一方重发 FIN, 主动关闭的一方必须维持一个有效状态信息(Time_wait), 以便重发 ACK
    - **如果主动关闭的一方不维持这个状态而直接进入 CLOSED 状态, 那么主动关闭的一方在处于 closed状态的时候收到FIN会响应一个RST**
    - 被动关闭的一方在收到 RST 以为出错了
    - 如果 TCP 想正常完成必要的操作而终止双方的数据传输, 就必须完全正确的传输四次握手的四个节，不能有任何的丢失
    - **健壮性**
2. 如果双方都调用 close(), 同时进入 CLOSED 状态, 没有 time_wait状态
    - 如果一个新的连接建立, 使用的IP地址和端口和原来的相同, 就是原来连接的一个复用
    - 假设原来的连接中的数据报残余存于网络中
    - **这样新的连接收到的数据报中有可能是先前连接的数据报。为了防止这一点，TCP不允许新连接复用TIME_WAIT状态下的socket**
2. 为什么是两倍的 MSL
    - **MSL是一个数据报在网络中单向发出到认定丢失的时间**，
    - 一个数据报有可能在发送途中或是其响应过程中成为残余数据报，确认一个数据报及其响应的丢弃的需要两倍的MSL
    
### 大量的 TIME_WAIT
1. 为什么出现这个问题
    - 主动关闭
    - **高并发 短链接**
        - 短连接表示 业务处理+传输数据的时间 远远小于 TIMEWAIT超时的时间”的连接
2. 解决
    - TODO
    - net.ipv4.tcp_tw_reuse = 1(重用)
    - net.ipv4.tcp_tw_recycle = 1(回收)