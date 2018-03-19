2018-03-19

### Web应用加载
***

#### HostConfig
1. 在默认情况下, server.xml并未包含Context相关配置 仅包含Host配置 ``<Host name="localhost"  appBase="webapps"  unpackWARs="true" autoDeploy="true">``
2. appBase 是web应用的基础目录, 所有需要部署的项目都要复制到此目录下面

#### Context 描述文件部署
1. tomcat支持用过一个独立的Context描述文件来配置并启动web应用,配置方式同 server.xml中的Context一样
2. tomcat默认的Host, Context 的描述文件为 $CATALINA_BASE/conf/Catalina/localhost