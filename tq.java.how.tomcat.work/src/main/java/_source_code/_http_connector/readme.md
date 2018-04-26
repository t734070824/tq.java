2018-04-26

## HttpConnector
1. 如何创建 socket
2. 如何维护 HttpProcessor pool
3. 如何提供 Http 请求服务

### 对 HttpProcessor 的 await()-assign()的理解
1. 当 HttpConnector 启动的时候, 初始化了多个 HttpProcessor 线程, 
2. 此时的 HttpProcessor 线程还是不可用状态(this.available = false), 还没有获取 socket, 需要在this.await()等待.
3. 当有 新的 http 请求到来的时候, HttpConnector 负责分配请求, 当此时 this.available = false, 直接跳过while
4. **HttpConnector 线程**带调用 HttpProcessor.assign(), 设置 this.available = true, 因为需要唤醒HttpProcessor线程, 所以 notifyAll()
5. 此时, HttpProcessor线程 被唤醒,并获取锁, 因为 this.available = true, 跳出 while, 获取socket, 处理请求

### 总结
1. 单个 httpConnector 线程处理连接
2. 启动 多个 HttpProcessor 线程, 循环使用, 不可用等待, 可用唤醒
3. 获取socket, 解析 http: parseRequest, parseheader, parse...
4. **getContainer().invoke()**
5. finshResponse()
6. if(!stop && OK && keepLive), **继续循环处理当前连接(如果全是 长连接, 多了应该会堵死...)**