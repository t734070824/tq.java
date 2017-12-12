2017-12-11
##HttpProcessor类中assign()方法的内部实现
![](https://github.com/t734070824/tq.java/blob/master/tq.java.how_tomcat_work/src/main/java/_ex04/1.png?raw=true)
![](https://github.com/t734070824/tq.java/blob/master/tq.java.how_tomcat_work/src/main/java/_ex04/2.png?raw=true)

2017-12-12
##URL动态加载class文件(**一下是测试结果 还需确认**)
1. 先从指定目录加载class文件
2. 如果找不到,就去class根目录查找

##仔细阅读HttpProcessor代码,掌握HTTP解析全过程