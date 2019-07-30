### HTTP/WEB
1. Session, Cookie, 格式 传输内容
    - 都是为了标记用户状态
    - session
        - 服务端实现, 服务器中的一块内存
        - Set-Cookies: JSESSIONID
    - Cookie
        - 存储在浏览器中
        - 请求是发送个服务器
        - 服务器根据 Sessionid 查找用户状态    
2. Filter Servlet Listener
3. get post 基本区别
4. Servlet的生命周期
5. 报文
6. http协议格式，
    - 请求
        - 请求方法 url 版本
        - 请求首部
        - 空行
        - 请求体
    - 响应
        - 版本 状态码 原因短语
        - 响应首部
        - 空行
        - 响应实体
7. 浅析Http和https的三次握手有什么区别。
    - http
        - TCP
    - HTTPS
        - TCP
        - client: 协议版本 client random 加密算法
        - server: server randon 确认加密算法
        - client: 确认公钥, 生成 Premaster secret 公钥加密
        - server: 私钥解密, 获取 Premaster secret
        - 双方 根据加密算法, 2个随机数 + Premaster secret, 生成对称加密密钥, 也就是 session key
        - session key 对称机密通讯
        
8. 谈谈Session/cookie机制. 如何实现会话跟踪？
    - TODO
1. 常用的HTTP方法有哪些？
    - get post put delete
2. get vs post
    - 查询/修改, 数据传输位置, 数据量, 安全
    - 幂等/副作用
    - 缓存/不好缓存
4. http1.1 新特性
    - 默认持久连接, 复用
    - 管线化, 批量请求, 一次返回
5. 对称密钥 vs 公开密钥
    - 一样 
    - 公钥 私钥
1. 安全
    - TODO
    