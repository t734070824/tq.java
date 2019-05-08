### JVM
1. in-jvm以及jmm缓存模型如何调优?
2. Java虚拟机的内存布局
    - 方法区
    - 堆
    - 虚拟机栈
    - 本地方法栈
    - 程序计数器
3. GC算法以及几种垃圾回收器
4. 类加载机制, 加载类的过程
    - TODO
5. Java内存模型
    - 共享变量 主内存
    - 线程本地内存, 变量副本
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
1. Java 内存分配？
1. Java 堆的结构是什么样子的？
1. 什么是堆中的永久代（Perm Gen space）?
1. 说说各个区域的作用？
1. Java 中会存在内存泄漏吗，简述一下？
1. Java 类加载过程？
1. 描述一下 JVM 加载 Class 文件的原理机制?
1. 什么是类加载器？
1. 类加载器有哪些？
1. 什么是tomcat类加载机制？
1. 类加载器双亲委派模型机制？
1. 什么是GC? 为什么要有 GC？
1. 简述一下Java 垃圾回收机制？
1. 如何判断一个对象是否存活？
1. 垃圾回收的优点和原理，并考虑 2 种回收机制？
1. 垃圾回收器的基本原理是什么？
1. 垃圾回收器可以马上回收内存吗？有什么办法主动通知虚拟机进行垃圾回收？
1. 深拷贝和浅拷贝？
1. System.gc() 和 Runtime.gc() 会做些什么？
1. 什么是分布式垃圾回收（DGC）？它是如何工作的？
1. 串行（serial）收集器和吞吐量（throughput）收集器的区别是什么？
1. 在 Java 中，对象什么时候可以被垃圾回收？
1. 简述Minor GC 和 Major GC？
1. Java 中垃圾收集的方法有哪些？
1. 讲讲你理解的性能评价及测试指标？
1. 常用的性能优化方式有哪些？
1. 说说分布式缓存和一致性哈希？
1. 同步与异步？阻塞与非阻塞？
1. 什么是GC调优？
1. 常见异步的手段有哪些？
1. -Xms > -Xmx 
    - Initial heap size set to a larger value than the maximum heap size