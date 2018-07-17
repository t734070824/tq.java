2018-07-17

## Tomcat 配置与优化

### Connector
1. protocol
    - BIO
    - NIO
    - **APR**
        - //TODO
2. maxThreads = "500"
    - 最大能同时接受的请求数
    - 可创建的最大的线程数
    - 最大并发数
3. minSpareThreads
    - 最少备用线程数
4. maxSpareThreads
    - 最多备用线程数, 一旦创建的数值超过, 就会关闭**不在需要的Socket连接**
    - 直接关闭, 不会等待空闲时间是否>=配置值
    - 不影响新的连接创建..   
5. acceptCount
    - 等待处理的请求队列, 默认100, 超过配置长度, 拒绝客户端请求, 返回403
6. maxIdleTime
    - 如果一个线程在30秒以内没有活跃，则终止运行并从线程池中移除。**除非线程池数量小于或等于minSpareThreads数量**。默认值是1分钟
7. enableLookups
    - 如果为true，调用request.getRemoteHost会执行DNS反查，反向解析IP对应的域名或主机，效率较低，建议设为false。 
8. URIEncoding
    - URIEncoding="UTF-8"
8. connectionTimeout
    - 网络连接超时时间毫秒数    
9. maxConnections
    - 最大连接数
    - 会大于 maxThreads, 一个线程可以服务多个连接
    
    
### APR
1. https://blog.csdn.net/xyang81/article/details/51502766

### JVM优化
1. -server
1. -Xms -Xmx
    - 设置成一样最好
    - 避免 JVM 反复重新申请内存，导致性能大起大落，
2. -XX:+DisableExplicitGC
    - 在程序代码中不允许有显示的调用”System.gc()”
3. -XX:+UseParNewGC
    - 对年轻代采用多线程并行回收，这样收得快。
4. -XX:+UseConcMarkSweepGC
5. -XX:+UseCMSCompactAtFullCollection
    