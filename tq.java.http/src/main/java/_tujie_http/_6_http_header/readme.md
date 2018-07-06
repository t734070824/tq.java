208-07-05

## HTTP 首部

### HTTP 首部出现两个或两个以上的相同首部字段名
1. 有浏览器自身决定

### 首部字段类型
1. 通用首部
    - 请求和响应报文都会使用的首部
2. 请求首部字段
3. 响应首部字段
4. 实体首部字段
    - 针对请求报文和响应报文的实体部分使用的首部。 补充了资源内容更
      新时间等与实体有关的信息。

### HTTP/1.1 首部
1. 通用首部
    - Cache-Control
        - 请求
            - no-cache          强制向源服务器再次验证
            - no-store          不缓存请求和响应的任何内容
            - max-age=[秒]      响应的最大Age值         
            - min-fresh=[秒]    期望在指定时间内的响应仍有效
        - 响应
            - max-age = [秒]    响应的最大Age值
            - s-maxage = [秒]   公共缓存服务器响应的最大Age值
    - Connection
        - 控制不在转发给代理的首部字段
            - Upgrade
        - 管理持久连接
            - Close
            - Keep-Alive
    - Date--创建HTTP报文的日期和时间
    - Trailer
    - Transfer-Encoding--传输报文主题时采用的编码方式
        - chunked
        - HTTP/1.1 的传输编码方式仅对分块传输编码有效
2. 请求首部  
    - Accept
        - 用户代理能够处理的媒体类型及媒体类型的相对优先级。 
        - q=0.8--给显示的媒体类型增加优先级
    - Accept-Charset
        - 通知服务器用户代理支持的**字符集**及
          字符集的相对优先顺序。
    - Accept-Encoding
        - 告知服务器用户代理支持的**内容编码**及
          内容编码的优先级顺序
    - Accept-Language
        - 告知服务器用户代理能够处理的自然
          语言集（指中文或英文等）, 以及自然语言集的相对优先级
    - Authorization
        - 告知服务器， 用户代理的认证信息（证书值） 
    - Host
        - 虚拟主机运行在同一个 IP 上， 因此使用首部字段 Host 加以区分
        - Host 首部字段在 HTTP/1.1 规范内是唯一一个必须被包含在请求内的首部字段
    - If-Modified-Since
        - 用于确认代理或客户端拥有的本地资源的有效性
    - If-Range
        - 它告知服务器若指定的 IfRange 字段值（ETag 值或者时间） 和请求资源的 ETag 值或时间相一
          致时， 则作为范围请求处理。 反之， 则返回全体资源
    - Range
        - 对于只需获取部分资源的范围请求， 包含首部字段 Range 即可告知服
          务器资源的指定范围
    - Referer
        - 告知服务器请求的原始资源的 URI
    - User-Agent
        - 用于传达浏览器的种类
3. 响应首部字段
    - Accept-Ranges
    - Age -- 告知客户端， 源服务器在多久前创建了响应
    - Location
        - 将响应接收方引导至某个与请求 URI 位置
          不同的资源。
        - 配合 3xx ： Redirection 的响应， 提供重定向的URI
    - Proxy-Authentidate
    - Server
        - 告知客户端当前服务器上安装的HTTP服务器应用程序的版本
4. 实体首部
    
        