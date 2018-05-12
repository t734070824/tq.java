2018-05-12

## 源码分析--Tomcat启动
https://www.jianshu.com/p/f987141887bb

### 启动猜想
1. bash脚本引导 java类
2. 解析 server.xml
3. Server, Service, Engine启动
4. 解析 ${Catalina.base}/webapps 下面的目录(以文件夹/war形式), 包括解析web.xml, 将 servlet, filter, listener, session 对应的信息加载到 Context 
5. 加载路由信息(Mapper)
6. 请求连接器 connector 启动

### 