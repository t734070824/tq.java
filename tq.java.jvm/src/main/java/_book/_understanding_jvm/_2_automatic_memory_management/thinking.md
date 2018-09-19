2018-09-19

## 思考
1. StackOverFlowError 的出现场景
    - 递归调用
    
2. OutOfMemoryError 的出现场景
    - 归根结底就是内存不足
        - 内存本身不够
            - 申请的内存不足(和最大堆内存息息相关)
                - 内存加载的数据量太大, 一次性从数据库中获取过多数据
            - 启动内存设置的太小
        - 程序滥用, 内存不释放
            - 集合中有对象的引用, jvm无法回收
            - 死循环导致大量重读的对象
    - 错误类型
        - tomcat:java.lang.OutOfMemoryError: PermGen space
        - tomcat:java.lang.OutOfMemoryError: Java heap space
        - weblogic:Root cause of ServletException java.lang.OutOfMemoryError
        - resin:java.lang.OutOfMemoryError
        - java:java.lang.OutOfMemoryError