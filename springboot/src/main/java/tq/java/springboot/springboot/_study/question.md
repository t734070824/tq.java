2018-07-04

## 问题

### 启动
1. 如何启动一个web项目的, 真鸡儿神奇
2. 约定??, 如何约定的, 全部扫描??

### 乱码
1. 添加配置
    - server.tomcat.uri-encoding=UTF-8
    - spring.http.encoding.charset=UTF-8
    - spring.http.encoding.enabled=true
    - spring.http.encoding.force=true
    - spring.messages.encoding=UTF-8
2. 设置文件类型
    - 将application.properites的文件类型修改为UTF-8的编码类型。 
 通过以上方法测试获取出来的值还是乱码。
3. idea
    - 设置 File Encodings的Transparent native-to-ascii conversion为true，具体步骤如下： 
    - 依次点击 
    - File -> Settings -> Editor -> File Encodings 
    - 将Properties Files (*.properties)下的Default encoding for properties files设置为UTF-8，将Transparent native-to-ascii conversion前的勾选上。