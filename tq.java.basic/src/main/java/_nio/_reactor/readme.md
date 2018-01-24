2018-01-24
### Reactor模式
1. http://www.jasongj.com/java/nio_reactor/

#### 在Reactor模式中，包含如下角色
1. Reactor 将I/O事件发派给对应的Handler
2. Acceptor 处理客户端连接请求
3. Handlers 执行非阻塞读/写

#### 理解 Selector
1. 本身是单线程的,只是提供非阻塞的I/O罢了
2. 注册多个通道(这个通道很有意思 serverSocketChannel SockeyChannel)
3. select()阻塞
4. 只会触发感兴趣的事件
5. 面向缓存