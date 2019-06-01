#### Tomcat
1. tomcat 集群
2. tomcat加载基本流程, 涉及到的参数
3. tomcat的各种配置，如何配置 docBase
    - port
    - connection
    - TODO docBase 
4. web.xml的配置
    - TODO
5. spring的监听器。
    - TODO
6. web的http请求如何整体响应时间变长导致处理的请求数变少，该如何处理？用队列，当处理不了那么多http请求时将请求放到队列中慢慢处理，web如何实现队列
    - connection
    - 队列
    - 分区
    - reacto
7. web请求的过程
    - nio
    - msgreceive
    - engine Host Context Wrapper Filter_Chain 
    - DispatcherServlet
    - HandlerMappig
    - Controller