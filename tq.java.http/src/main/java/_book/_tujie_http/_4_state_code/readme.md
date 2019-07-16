2018-07-05

## 状态码

### 类别
1. 2XX  请求正常处理完毕
    - 200 OK
    - 204 No Content(请求处理成功, 但是没有实体可以返回)
    - 206 Partial Content
2. 3XX  重定向
    - 301 Moved Permanently(永久性重定向, 需要更改书签)
    - 302 Found(临时重定向)
    - 304 Not Modified(资源已找到, 但不符合查询要求, 不返回任何实体)
3. 4XX  客户端错误
    - 400 Bad Request(请求报文中存在语法错误)
    - 401 Unauthorized(请求需要HTTP认证: Basic认证, Digest认证)
    - 403 Forbidden(不允许访问)
    - 404 Not Found 没有找到请求的资源
5. 5XX  服务器错误
    - 500 Internal Server Error(服务器在执行请求时发生错误)
    - 503 Service Unavailable(服务器正在处于超负载或者维护状态, 暂时无法处理请求)
    - 
    