2018-04-26

### 处理过程
1. HttpConnector.socket.accept
    - HttpProcessor.process()
        - getContainer().invoke()
            - StandardEngine.invoke()
                - ((Host)engine.map(request, true)).invoke();
                    - StandardHostValve.invoke()
                        - ((Context)host.map(request, true)).invoke();
                            - StandardContextValve.invole()
                                - ((Wrapper)context.map(request, true)).invoke();
                                     - StandardWrapperValve.invoke()
                                        - servlet = StandardWrapperValve.allocate()
                                            - **this.createFilterChain(request, servlet).doFilter();**
                                                - **this.servlet.service(request, response);**
                                            
![](https://github.com/t734070824/tq.java/blob/master/tq.java.how.tomcat.work/src/main/java/_source_code/1.jpg?raw=true)                                            

### Tomcat4 vs Tomcat8 --> Pipeline
1. tomcat4中的 pipeline使用数组实现, tomcat8中的 pipeline使用链表实现,        

### servlet容器
![](https://github.com/t734070824/tq.java/blob/master/tq.java.how.tomcat.work/src/main/java/_source_code/2.jpg?raw=true)   

### Wrapper, Context, Host, Engine 总结
1. 都是容器
2. 都有自己的生命周期
3. Engine-->Host-->Context-->Wrapper 越来越低级
4. 都是通过各自的基础阀去掉用下一层
5. 通过 map(request) 获取 下一个容器

     