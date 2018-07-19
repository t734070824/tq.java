2017-12-29
### Tomcat Session管理

#### Session创建
```
ISesson
StandardSession
StandardSessionFacade
```

#### Session管理与集群
```
IManager
ManagerBase
StandardManager
PersistManagerBase
DistributedManager
```

#### Session持久化
```
IStore
StoreBase
FileStore
JDBCStore
```

### Session 理解
1. 对Tomcat而言，Session是一块在服务器开辟的内存空间，其存储结构为ConcurrentHashMap
2. 就是服务器可以利用session存储客户端在同一个会话期间的一些操作记录
3. Session id来判断是否是同一个回话, Tomcat--JSESSIONID
4. 过程
    - 客户端第一次访问, 服务器生成一个Session对象, 生成一个 Session id, 响应头: Set-Cookie:"JSESSIONID=XXXXXXXXX", 客户端设置Cookie
    - 客户端设置Cookie
    - 客户端每次请求, 请求头带上 Cookie:XXXXXX
    - 服务器通过读取请求头中的Cookie信息，获取名称为JSESSIONID的值，得到此次请求的Session id
5. Session 劫持
    - 获取Session id 即可
    - 防范
        - httponly=true
            - 防止客户端脚本访问这个设置的cookie
            - 这个cookie被XSS读取从而引起session劫持
            - cookie设置不会像URL重置方式那么容易获取sessionID
        - 添加请求 token
            - 然后每次验证这个token，从而保证用户的请求都是唯一性
        - 设置过期时间
            