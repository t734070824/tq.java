2017-12-13

### Tomcat 架构层次结构
![](https://github.com/t734070824/tq.java/blob/master/tq.java.how.tomcat.work/src/main/java/_ex05/1.png?raw=true)

### Pipeline

### tomcat处理HTTP大致流程
1. HttpConnector监听端口,并接受请求
2. HttpProcesser接受请求流,解析HTTP
2. **process.getContainer.invock**
3. Containe.pipeLine.invokeNext
4. ValveContext.getValve.invoke
4. **valve.invokeNext**
5. BasicValve.invoke
6. response  

### Context Wrapper 容器
1. 如何解析HTTP
2. 这条HTTP想干什么
3. 如何处理这个HTTP
4. 如何装载自己的servlet
5. 选择哪个Servlet处理本次请求
6. 封装Response