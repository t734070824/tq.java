2017-12-01
## 1.URL
1.URL 提供了一种统一的资源命名方式。 大多数 URL 都有同样的：“**方案 :// 服务器位置 / 路径**” 结构
2.通用格式`<scheme>://<user>:<password>@<host>:<port>/<path>;<params>?<query>#<frag>`

## 提高HTTP的连接性能
• 并行连接
通过多条 TCP 连接发起并发的 HTTP 请求。
• 持久连接
重用 TCP 连接， 以消除连接及关闭时延。
• 管道化连接
通过共享的 TCP 连接发起并发的 HTTP 请求。
• 复用的连接
交替传送请求和响应报文（实验阶段）。
## Connection首部和盲中继
![](https://github.com/t734070824/tq.java/blob/master/tq.java.http/src/main/java/_the_definitive_uide/1.png?raw=true)

这幅图中发生的情况如下所示。
- 在图 4-15a 中， Web 客户端向代理发送了一条报文， 其中包含了 Connection:Keep-Alive 首部， 如果可能的话请求建立一条 keep-alive 连接。 客户端等待响应， 以确定对方是否认可它对 keep-alive 信道的请求。

- 哑代理收到了这条 HTTP 请求， 但它并不理解 Connection 首部（只是将其作为一个扩展首部对待）。 代理不知道 keep-alive 是什么意思， 因此只是沿着转发链路将报文一字不漏地发送给服务器（图 4-15b）。 但 Connection 首部是个逐跳首部， 只适用于单条传输链路， 不应该沿着传输链路向下传输。 接下来， 就要发生一些很糟糕的事情了。

- 在图 4-15b 中， 经过中继的 HTTP 请求抵达了 Web 服务器。 当 Web 服务器收到经过代理转发的 Connection: Keep-Alive 首部时， 会误以为代理（对服务器来说， 这个代理看起来就和所有其他客户端一样） 希望进行 keep-alive 对话！ 对Web 服务器来说这没什么问题——它同意进行 keep-alive 对话， 并在图 4-15c 中回送了一个 Connection: Keep-Alive 响应首部。 所以， 此时 Web 服务器认为它在与代理进行 keep-alive 对话， 会遵循 keep-alive 的规则。 但代理却对 keepalive 一无所知。 不妙。

- 在图 4-15d 中， 哑代理将 Web 服务器的响应报文回送给客户端， 并将来自 Web服务器的 Connection: Keep-Alive 首部一起传送过去。 客户端看到这个首部， 就会认为代理同意进行 keep-alive 对话。 所以， 此时客户端和服务器都认为它们在进行 keep-alive 对话， 但与它们进行对话的代理却对 keep-alive 一无所知。

- 由于代理对 keep-alive 一无所知， 所以会将收到的所有数据都回送给客户端， 然后等待源端服务器关闭连接。 但源端服务器会认为代理已经显式地请求它将连接保持在打开状态了， 所以不会去关闭连接。 这样， 代理就会挂在那里等待连接的关闭。

- 客户端在图 4-15d 中收到了回送的响应报文时， 会立即转向下一条请求， 在 keepalive 连接上向代理发送另一条请求（参见图 4-15e）。 而代理并不认为同一条连接上会有其他请求到来， 请求被忽略， 浏览器就在这里转圈， 不会有任何进展了。

- 这种错误的通信方式会使浏览器一直处于挂起状态， 直到客户端或服务器将连接超时， 并将其关闭为止。
### 代理和逐跳首部
- 为避免此类代理通信问题的发生， 现代的代理都绝不能转发 Connection 首部和所有名字出现在 Connection 值中的首部。 因此， 如果一个代理收到了一个Connection: Keep-Alive 首部， 是不应该转发 Connection 首部， 或所有名为Keep-Alive 的首部的。另外， 还有几个不能作为 Connection 首部值列出， 也不能被代理转发或作为缓存响应使用的首部。 其中包括 Proxy-Authenticate、 Proxy-Connection、Transfer-Encoding 和 Upgrade