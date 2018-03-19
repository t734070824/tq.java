2018-03-18

### 总体设计
+ 接收 Socket 请求, 处理逻辑, 返回响应
+ Q:将请求监听和请求处理放在一起扩展性很差

![](https://github.com/t734070824/tq.java/blob/master/tq.java.tomcat/src/main/java/_tomcat_ext_framework/_2_framework/_2_1_design/1.jpg?raw=true)


+ 将网络协议和请求处理分离
+ Q:无法知道某个Connector的请求由哪个Container处理

![](https://github.com/t734070824/tq.java/blob/master/tq.java.tomcat/src/main/java/_tomcat_ext_framework/_2_framework/_2_1_design/2.jpg?raw=true)

+ 一个Server包含多个 Service, 一个 Service 负责维护多个 Connector 和 一个 Enginer
+ 解决了网络协议与容器的解耦
+ Q:无法再 Engine容器中支持管理Web应用, 应当在接受到Connector的处理请求的时候,Engine容器能够找到一个合适的Web应用

![](https://github.com/t734070824/tq.java/blob/master/tq.java.tomcat/src/main/java/_tomcat_ext_framework/_2_framework/_2_1_design/3.jpg?raw=true)




