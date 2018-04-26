2018-04-26

## 处理过程
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
                                        - **this.createFilterChain(request, servlet).doFilter();**
                                            - **this.servlet.service(request, response);**
                                            
![](https://github.com/t734070824/tq.java/blob/master/tq.java.how_tomcat_work/src/main/java/_source_code/2.png?raw=true)                                            
                        