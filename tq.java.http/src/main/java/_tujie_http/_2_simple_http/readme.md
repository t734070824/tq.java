2018-07-04

## 简单的 HTTP 协议

### 请求与相应
1. 客户端负责请求, 服务器负责相应
2. 请求
    - 方法    URI     协议版本
    - 请求首部
    - 内容实体
3. 响应
    - 协议版本      状态码     状态码的原因短语
    - 响应首部字段
    - 响应主体

### 无状态协议
1. 虽然是无状态协议, 为了实现状态保持功能 --> Cookie

### 对于请求首部中 HOST 的疑问
1. The host-Header tells the webserver which virtual host to use (if set up)
2. 在发送 HTTP请求的时候 , 已经建立了 TCP连接了..