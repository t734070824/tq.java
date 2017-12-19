2017-12-13

###Tomcat 架构层次结构
![](https://github.com/t734070824/tq.java/blob/master/tq.java.how_tomcat_work/src/main/java/_ex05/1.png?raw=true)

###Pipeline???

###tomcat处理HTTP大致流程
1. HttpConnector监听端口,并接受请求
2. HttpProcesser接受请求流,解析HTTP
3. Container 处理请求
4. Pipeline(责任链 过滤链??)
5. otherValve.invoke, nextInvoke
5. BasicValve.invoke
6. reponse