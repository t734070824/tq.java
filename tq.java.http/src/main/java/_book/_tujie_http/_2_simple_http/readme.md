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

### 持久连接
1. 主要是为了解决 多次请求需要多次TCP连接的断开操作

### 管道化
1. 须通过永久连接（persistent connection）完成
2. 并且只有 GET 和 HEAD 等要求可以进行管线化，非幂等的方法，例如POST将不会被管线化
3. 一个连续的幂等请求，如 GET，HEAD，PUT，DELETE，是否可以被管线化取决于一连串请求是否依赖于其他的
4. 此外，初次创建连接时也不应启动管线机制，因为对方（服务器）不一定支持 HTTP/1.1 版本的协议。

### Cookie
1. 通过在请求和响应报文中写入 Cookie 信息来控制客户端的状态
2. 服务端 响应报文 Set-Cookie

### 分块传输编码


### 内容协商返回最合适的内容
1. 显示语言
1. 首部字段
    - Accept
    - Accept-Charset
    - Accept-Enconding
    - Accept-Language
    - Content-Language
    