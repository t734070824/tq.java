2018-03-18

### 总体设计
![](https://github.com/t734070824/tq.java/blob/master/tq.java.tomcat/src/main/java/_tomcat_ext_framework/_2_framework/_2_1_design/12.jpg?raw=true)


***
+ 接收 Socket 请求, 处理逻辑, 返回响应
+ Q:将请求监听和请求处理放在一起扩展性很差

![](https://github.com/t734070824/tq.java/blob/master/tq.java.tomcat/src/main/java/_tomcat_ext_framework/_2_framework/_2_1_design/1.jpg?raw=true)

***

+ 将网络协议和请求处理分离
+ Q:无法知道某个Connector的请求由哪个Container处理

![](https://github.com/t734070824/tq.java/blob/master/tq.java.tomcat/src/main/java/_tomcat_ext_framework/_2_framework/_2_1_design/2.jpg?raw=true)

***

+ 一个Server包含多个 Service, 一个 Service 负责维护多个 Connector 和 一个 Enginer
+ 解决了网络协议与容器的解耦
+ Q:无法在 Engine容器中支持管理Web应用, 应当在接受到Connector的处理请求的时候,Engine容器能够找到一个合适的Web应用

![](https://github.com/t734070824/tq.java/blob/master/tq.java.tomcat/src/main/java/_tomcat_ext_framework/_2_framework/_2_1_design/3.jpg?raw=true)

***

+ 应用服务器为每个域名抽象为一个虚拟主机
+ 用Host标识虚拟主机的概念, 一个Host 可以包含多个Context
+ Q:

![](https://github.com/t734070824/tq.java/blob/master/tq.java.tomcat/src/main/java/_tomcat_ext_framework/_2_framework/_2_1_design/4.jpg?raw=true)
***

+ 在一个Web应用中, 可包含多个Servlet实例来处理来自不同链接的请求
+ 需要一个组件概念来标识 Servlet定义

![](https://github.com/t734070824/tq.java/blob/master/tq.java.tomcat/src/main/java/_tomcat_ext_framework/_2_framework/_2_1_design/5.jpg?raw=true)

***

+ 容器
+ 使用 Container标识容器, Container可以添加并维护子容器, 
+ Engine, Host, Context, Wrapper 都是继承自 Container

![](https://github.com/t734070824/tq.java/blob/master/tq.java.tomcat/src/main/java/_tomcat_ext_framework/_2_framework/_2_1_design/6.jpg?raw=true)

***


+ 所有组件均存在启动, 停止 等生命周期方法, 拥有生命周期管理特性
+ 抽象 Lifecycle通用接口 ``init(), start(), stop(), destroy()``
+ Engine, Host, Context, Wrapper 都是继承自 Container

![](https://github.com/t734070824/tq.java/blob/master/tq.java.tomcat/src/main/java/_tomcat_ext_framework/_2_framework/_2_1_design/7.jpg?raw=true)

***


+ 提高每个组件的灵活性, 易于扩展 --> 责任链设计模式
+ Pipeline(管道) 和 Valve(阀) 
+ Pipeline 维护一个基础的 Valve, 始终位于 Pipeline的末端(最后执行), 

![](https://github.com/t734070824/tq.java/blob/master/tq.java.tomcat/src/main/java/_tomcat_ext_framework/_2_framework/_2_1_design/8.jpg?raw=true)

***

+ Connector 要完成以下功能
    - 监听服务器端口, 读取来自客户端的请求
    - 将请求数据按照指定协议解析
    - 根据请求地址匹配正确的容器处理
    - 将响应返回客户端
+ 通过适配器模式实现了 Connector 与 Mapper, Container的解耦, 

![](https://github.com/t734070824/tq.java/blob/master/tq.java.tomcat/src/main/java/_tomcat_ext_framework/_2_framework/_2_1_design/9.jpg?raw=true)

***

+ 需要提高服务器的并发能力
+ 提供Executor接口来表示一个可以在组件之间共享的线程池, 继承自 Lifecycle, 

![](https://github.com/t734070824/tq.java/blob/master/tq.java.tomcat/src/main/java/_tomcat_ext_framework/_2_framework/_2_1_design/10.jpg?raw=true)

***

+ 启动: Bootstrap, Catalina

![](https://github.com/t734070824/tq.java/blob/master/tq.java.tomcat/src/main/java/_tomcat_ext_framework/_2_framework/_2_1_design/11.jpg?raw=true)



