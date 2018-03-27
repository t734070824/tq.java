2018-03-19

### Web应用加载
***

#### HostConfig
1. 在默认情况下, server.xml并未包含Context相关配置 仅包含Host配置 ``<Host name="localhost"  appBase="webapps"  unpackWARs="true" autoDeploy="true">``
2. appBase 是web应用的基础目录, 所有需要部署的项目都要复制到此目录下面

#### Context 描述文件部署
1. tomcat支持用过一个独立的Context描述文件来配置并启动web应用,配置方式同 server.xml中的Context一样
2. tomcat默认的Host, Context 的描述文件为 $CATALINA_BASE/conf/Catalina/localhost

### 应用配置方式
1. 直接复制到 webapps
2. 在 Catalina/localhost/ 创建配置文件
3. 在 server.xml 中的 Host 添加 Context

### 重新部署(redeployResources) 和 重新加载(reloadResources) 区别
1. reloadResources: 针对同一个 Context 对象的重启, redeployResources: 重新创建一个 Context

### web容器类图

![](https://github.com/t734070824/tq.java/blob/master/tq.java.tomcat/src/main/java/_tomcat_ext_framework/_3_catalina/_3_4_web_app_load/1.jpg?raw=true)

1. 