2019-04-10

## why HTTP

### 为什么需要HTTP
1. 首先看 没有这个应用层协议, 只有 TCP的情况
    - 客户端发送了一堆 二进制, 服务器要如何解析呢
    - 双方约定解析的方式
        - 编解码
        - 需要的资源
        - 返回的资源
    - 感觉 就是把这一堆双方约定的东西 统一起来, 让双方协议的东西可以让其他的客户端/服务器 理解
    - 不需要重复工作


### 为什么建立在 TCP 之上
1. 不一定需要建立在 TCP 之上
2. 只要是 可靠的 协议之上就可以
3. 应为最终都是二进制流