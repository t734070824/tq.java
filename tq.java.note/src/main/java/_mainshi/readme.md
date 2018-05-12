2018-02-28

# 面试题

### 项目
1. 项目遇到什么难以解决的bug
2. 项目怎么改为分布式

### 基础
1. Concurrenthashmap 为什么要用红黑树？为何不用其他的树，平衡二叉树，b+？
2. 如何给hashmap的key对象设计他的 hashcode
3. bytes --> long
4. lru Cache
5. Concurrenthashmap 锁分段, 读是否加锁, 迭代器是强一致性还是 弱一致性
6. CAS
7. HashMap 多线程下的扩容死循环问题
8. 线程池 参数的意义
9. 使用无界阻塞队列会出现的问题
10. synchronized 和 lock的区别
11. ThreadLocal
12. ThreadPoolExecutor 内部原理
13. IO 和  NIO的区别
14. 顺序加锁
15. 快速失败(fast-fail) 和 安全失败(fail-safe)的区别
16. finalize()
17. 反射(反射机制, 反射性能, 如何优化) private
18. 乐观锁
19. hash冲突
20. 锁类型(偏向锁, 轻量级锁, 自旋锁, 锁升级)
21. JDK1.8 新特性
22. java线程之间通信
23. 1.8 ConcurrentHashMap
24. 同步器
25. String为什么可以用 + 操作
26. 两个方法完全相同可以重载吗
27. try里面的return, finally 在 return, 哪个会返回, 字节码如何体现的
28. 什么情况下不适合用CAS
29. 如何让一个线程放弃锁, 放弃锁之后什么时候才可以再次获取锁
30. 如何实现自定义注解
31. final finally finalize
32. (short s1 =1;s1 = s1 +1) (short s1 =1;s1 += 1)
33. runtimeException
34. 分析线程池的实现原理和线程的调度过程
35. Java 8的内存分代改进


### 设计模式
1. 常用设计模式
2. 单例的几种实现方式




### JVM
1. in-jvm以及jmm缓存模型如何调优?
2. Java虚拟机的内存布局
3. GC算法以及几种垃圾回收器
4. 类加载机制
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

### 数据库(mysql)
1. 数据库的隔离级别
2. 数据库是怎么搭建集群的，主从数据同步怎么做的？
3. mysql二级缓存
4. 索引原理 种类, 好处与问题
5. 垂直和水平拆分
6. SQL优化
7. Explain
8. Statement PrepareStatement区别
9. SQL 注入
10. 主键索引和非主键索引的区别, 分别属于哪类索引
11. 为什么使用索引 为什么会变快
12. 数据库自增主键可能的问题
13. 数据库锁表的相关处理


### 数据结构
1. 栈的特性先进后出。手写实现入栈出栈，获取栈的长度，栈是否为空
2. 一个树，从根节点往下走，每条路径的节点值为某一数值，不管最后节点是不是叶子节点。写出具体实现方法
3. B树, 二叉树 操作
4. stack queue
5. 倒排索引的原理

### 算法
1. String字符串 反转 --> stack
2. 文件单词最高频率
3. 快速排序, 广度优先排序(队列实现)
4. 多路归并的时间复杂度
5. 

### 开源框架
#### Dubbo
1. Dubbo实现了远端rpc调用，请手写一个rpc调用
2. 

#### Spring
1. spring bean初始化过程
2. spring 事物回滚机制(传播性) 
3. **用到的设计模式以及 运用**
4. IOC AOP的实现
5. Spring, Spring MVC原理,流程
6. 设计模式在Spring中的应用
7. Servlet中filter和spring中的Interceptor的区别 

#### Mybatis
1. 缓存机制
2. # $ 的区别
3. dao层的内部实现
4. 集合怎么进行映射配置的, 级联


#### Tomcat
1. tomcat集群
2. tomcat加载基本流程, 涉及到的参数
3. 

#### Zookeeper


### HTTP/WEB
1. Session, Cookie, 格式 传输内容
2. Filter Servlet Listener
3. get post 基本区别
4. Servlet的生命周期
5. 报文


### TCP/IP
1. 三次握手, 四次挥手
2. 窗口滑动机制
3. TCP VS UDP
4. 长连接与短连接




### Linux
1. 常用 linux 命令

### Redis/Memcached
1. 为什么单线程,还很快??
2. redis几种数据结构 底层如何实现
3. Redis的主键争用问题如何解决
4. Redis事务的CAS操作吗
5. Redis持久化的几种方式
6. Redis的缓存失效策略

### 分布式/高并发
1. Redis为什么可以实现分布式锁，memcached 可以实现分布式锁么？实现分布式锁的方式有很多种，为什么选择redis分布式锁？
2. dubbo的底层负载均衡，容错机制都是怎么实现的
3. 分布式Session设置
4. 分布式接口的幂等性(版本号)
5. 设计一个对外服务的接口的实现类, 在1,2,3这三个主机(对应不同的IP) 上实现 负载均衡和顺序轮训机制(考虑并发)
6. 缓存的雪崩以及穿透的理解
7. 开发一个大型网站会考虑哪些问题
8. 分布式锁
9. 设计一个秒杀的场景
10. 分布式系统怎么做服务治理 ???
11. 缓存机器增删如何对系统影响最小
12. 一致性哈希的实现

### 大数据
1. mapreduce过程
2. 海量url去重类问题
3. 对分词技术的了解
4. 大量用户数据如何在内存中排序和去重
5. 海量登录日志如何排序和处理
6. 10万个ip段如何快速查找
7. Solr和Lucene，中文分词技术