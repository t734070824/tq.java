2018-05-12

## Coyote

### 回顾
1. Catalina是tomcat提供的Servlet容器实现, 负责处理客户端的请求并输出相应
2. 链接器接受客户端的请求, 按照协议进行解析, 交由 Servlet容器处理

### 什么是 Coyote
1. Tomcat链接器框架
2. 封装底层通信, 为 Catalina 容器提供统一的接口, **使 Catalina容器与具体的请求协议及I/O方式解耦**

### 传输协议与IO方式
1. 传输协议:
    - HTTP/1.1
    - AJP: 
    - HTTP/2.0
2. IO方式
    - NIO:采用java NIO
    - NIO2: 采用 JDK7 最新的 NIO2
    - APR: 采用 APR实现, 需要单独安装 APR库

### Connector请求处理过程
![](https://github.com/t734070824/tq.java/blob/master/tq.java.tomcat/src/main/java/_tomcat_ext_framework/_4_coyote/1.jpg?raw=true)

1. 