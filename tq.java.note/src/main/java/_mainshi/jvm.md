### JVM
1. in-jvm以及jmm缓存模型如何调优?
2. Java虚拟机的内存布局
3. GC算法以及几种垃圾回收器
4. 类加载机制, 加载类的过程
    - TODO
5. Java内存模型
6. happens-before规则
7. volatile 关键字使用规则
8. JVM老年代和新生代的比例
9. YGC 和 FGC 发生的具体场景
10. jstack, jmap, jutil 分别的意义? 如何在线上排查JVM 相关的问题
11. 回收什么样子的对象
12. CPU 100%
13. 如何获取一个 dump文件
14. 什么情况下触发Minor GC
15. Serial 特点
16. JVM对final关键字的编译优化
17. java内存模型，垃圾回收机制，不可达算法
    - happer-brfore
    - TODO
    - 不可达算法 TODO
18. jvm的一些命令
    - jmap
    - jstat
    - jstack
    - jps
19. 如何把java内存的数据全部dump出来
    - jmap -dump:live,format=b,file=xxx pid
20. 如何手动触发全量回收垃圾，如何立即触发垃圾回收
    - System.gc()
    - Runtime.getRuntime().gc()
21. 何时会内存泄漏，内存泄漏会抛哪些异常
    - TODO
22. 静态内部类加载到了哪个区？
    - 方法区 
23. class文件编译后加载到了哪
    - TODO
24. 类加载机制里的，双亲委派模型
    - 为什么要双亲委派
    - 如何破坏双亲委派
    - 为什么要破坏双亲委派