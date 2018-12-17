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
36. 用hashmap实现redis有什么问题（死锁，死循环，可用 ConcurrentHashmap）
    - 死循环 TODO
    - ConcurrentHashmap 源码 
    - TODO 扩容
37. 线程的状态
    - new Thread() 
    - Runnable 
    - Running 
    - Block
        - wait
        - lock pool
        - sleep, join
    - dead 
38. 线程的阻塞的方式
    - wait
    - lock pool
    - sleep, join
39. sleep和wait的区别
    - 锁
40. hashmap的底层实现
    - 数组
    - 链表
    - 红黑树
41. 两个Integer的引用对象传给一个swap方法在方法内部交换引用，返回后，两个引用的值是否会发现变化
    - TODO
    - 不会变化 TODO
    - java 内存模型 主内存 线程本地内存
    - 内存的拷贝
42. IO会阻塞吗？
    - readLine是不是阻塞的??
43. 字符串的格式化方法 （20，21这两个问题问的太低级了）
44. 时间的格式化方法
45. 定时器用什么做的
    - TODO
46. 线程如何退出结束
    - TODO
    - 正常停止
    - while
    - interrupt
47. java有哪些锁？
    - 乐观锁 
    - 悲观锁 
    - synchronized 
    - 可重入锁 
    - 读写锁,
    - reentrantlock与synchronized的区别
        - 锁中断
        - 尝试获取
        - 底层实现
48. ThreadLocal的使用场景
    - 不是用来解决多线程并发的
    - 想共享又不想加锁
    - connection
49. ConcurrentHashmap的锁是如何加的？是不是分段越多越好
    - jdk7 VS jdk8
    - TODO
50. hashmap如果只有一个写其他全读会出什么问题
    - TODO
51. volatile的用途
    - 免锁
    - 单例
    - 主内存
52. 读写锁
    - 读时复制
    - 写独锁
    - 读读
53. 线程安全的单例模式
    - volatile    
54. concurrenhashmap求size是如何加锁的，如果刚求完一段后这段发生了变化该如何处理
    - jdk7 全部加锁
    - TODO jdk8
55. 可重入的读写锁，可重入是如何实现的？
    - Thread身份
    - TODO
56. 可重入锁中对应的wait和notify
    - await()
    - signal
57. java线程池中基于缓存和基于定长的两种线程池，当请求太多时分别是如何处理的？定长的事用的队列，如果队列也满了呢？
    交换进磁盘？基于缓存的线程池解决方法呢？
    - TODO
58. 可重入锁中的lock和trylock的区别
59. LinkedHashmap的底层实现
    - map+链表
    - LRU
60. java的反射是如何实现的【阿里巴巴面试题目含答案】
    - TODO
61. 动态代理的几种实现方式及优缺点
    - TODO
62. 按线程池内部机制.当提交新任务时.有哪些异常要考虑？
    - TODO

### 设计模式
1. 常用设计模式
2. 单例的几种实现方式
3. 门面模式，类图(外观模式)
    - Netty




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
14. mysql的行级锁加在哪个位置
    - ???
15. myisam和innodb的区别（innodb是行级锁，myisam是表级锁）
    - 锁
    - 事务
    - 索引
16. mysql其他的性能优化方式
    - 数据类型
    - 索引
    - 读写分离
    - 缓存表/汇总表
    - TODO
17. mysql的binlog
    - TODO
18. mysql是如何实现事务的
    - TODO
19. 读写分离何时强制要读主库，读哪个从库是通过什么方式决定的，从库的同步mysql用的什么方式
    - TODO
20. mysql的存储引擎
    - myISAM
    - InnoDB
21. mysql的默认隔离级别，其他隔离级别
    - 未提交读
    - 提交读
    - 重复读
        - 默认级别
        - 幻读
        - MVCC
    - 串行化
22. sql语句各种条件的执行顺序，如select， where， order by， group by
    - TODO
23. select xx from xx where xx and xx order by xx limit xx； 如何优化这个（看explain）
    - explain
24. 求表的size，或做数据统计可用什么存储引擎
    - TODO
25. 读多写少可用什么引擎
    - MyIsam
    - Innodb
26. 假如要统计多个表应该用什么引擎
    - Innodb
27. myisam的优点，和innodb的区别
    - 读快
    - TODO
28. innodb对一行数据的读会枷锁吗？
    - 不枷锁，读实际读的是副本
29. mysql的三大引擎是啥？
    - mysql常用的引擎有InnoDB，MyISAM，Memory，
    - 默认是InnoDB
        - 磁盘表，支持事务，支持行级锁，B+Tree索引
        - 优点： 
            - 具有良好的ACID特性。
            - 适用于高并发，更新操作比较多的表。
            - 需要使用事务的表。
            - 对自动灾难恢复有要求的表。
        - 缺点：
            - 读写效率相对MYISAM比较差。
            - 占用的磁盘空间比较大。
    - MyISAM
        - 磁盘表，不支持事务，支持表级锁，B+Tree索引
        - 优点
            - 占用空间小，处理速度快（相对InnoDB来说）
        - 缺点
            - 不支持事务的完整性和并发性MEMORY(Heap)：内存表，不支持事务，表级锁，Hash索引，不支持Blob,Text大类型
        - 适用于
            - 不支持事务的完整性和并发性MEMORY(Heap)：内存表，不支持事务，表级锁，Hash索引，不支持Blob,Text大类型
30. 什么是索引? 为啥nosql没索引？
    - nosql有索引,索引分为聚簇索引和非聚簇索引两种，聚簇索引是按照数据存放的物理位置为顺序的，而非聚簇索引就不一样了；
    - 聚簇索引能提高多行检索的速度，而非聚簇索引对于单行的检索很快。
    - 聚簇索引：有主键时，根据主键创建聚簇索引；
    - 没有主键时，会用一个唯一且不为空的索引列做为主键，成为此表的聚簇索引；
    - 如果以上两个都不满足那innodb自己创建一个虚拟的聚集索引非聚簇索引：非聚簇索引都是辅助索引，像复合索引、前缀索引、唯一索引
31. B+树和B树区别？
    - B树的非叶子节点存储实际记录的指针，
    - 而B+树的叶子节点存储实际记录的指针,B+树的叶子节点通过指针连起来了, 适合扫描区间和顺序查找。

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
8. aop的底层实现，动态代理是如何动态，假如有100个对象，如何动态的为这100个对象代理
    - 动态代理
        - TODO 假如有100个对象，如何动态的为这100个对象代理
    - Cglib
        - ASM
9. spring的bean配置的几种方式
    - xml
    - anno
10. spring的注入bean的方式
    - Byname
    - byType
    - 构造函数
11. @Transaction注解一般写在什么位置?如何控制其回滚?
    - TODO
12. 说说Spring的IOC容器初始化流程？
    - TODO
    
#### SpringBoot
1. 说说springboot启动机制
    - TODO

#### Mybatis
1. 缓存机制
2. # $ 的区别
3. dao层的内部实现
4. 集合怎么进行映射配置的, 级联
5. mybatis如何映射表结构
    - TODO

#### Netty
1. 是否用过NIO
    - ...
    - selector
    - epoll
    - reactor

#### Tomcat
1. tomcat集群
2. tomcat加载基本流程, 涉及到的参数
3. tomcat的各种配置，如何配置 docBase
    - port
    - connection
    - TODO docBase 
4. web.xml的配置
    - TODO
5. spring的监听器。
    - TODO
6. web的http请求如何整体响应时间变长导致处理的请求数变少，该如何处理？用队列，当处理不了那么多http请求时将请求放到队列中慢慢处理，web如何实现队列
    - connection
    - 队列
    - 分区
    - reacto

#### MQ
1. MQ有可能发生重复消费. 如何避免. 如何做到幂等？
    - TODO


### Nginx
1. nginx 的请求转发算法，如何配置根据权重转发
    - TODO

### HTTP/WEB
1. Session, Cookie, 格式 传输内容
2. Filter Servlet Listener
3. get post 基本区别
4. Servlet的生命周期
5. 报文
6. http协议格式，get和post的区别
    - 大小
    - 可以获取
7. 浅析Http和https的三次握手有什么区别。
    - TODO
8. 谈谈Session/cookie机制. 如何实现会话跟踪？
    - TODO


### TCP/IP
1. 三次握手, 四次挥手
2. 窗口滑动机制
3. TCP VS UDP
4. 长连接与短连接


### junit
1. junit用法，before,beforeClass,after, afterClass的执行顺序
    - TODO

### Maven
1. 是否用过maven install。 maven test。git（make install是安装本地jar包）
    - TODO

### Linux
1. 常用 linux 命令
2. linux系统日志在哪里看
    - TODO
3. 如何查看网络进程
    - TODO
    
#### Zookeeper
1. zookeeper的实现机制，有缓存，如何存储注册服务的
    - TODO
2. zookeeper的事物，结点，服务提供方挂了如何告知消费方
    - TODO


### Redis/Memcached
1. 为什么单线程,还很快??
2. redis几种数据结构 底层如何实现
3. Redis的主键争用问题如何解决
4. Redis事务的CAS操作吗
5. Redis持久化的几种方式
6. Redis的缓存失效策略
7. memcache和redis的区别
    - TODO memcache 
8. redis能存哪些类型
    - string
    - list
    - map
    - set
    - sortSet
    - bitmap
    - TODO H..log
9. redis能把内存空间交换进磁盘中吗(这个应该是可以的，但是那个面试官非跟我说不可以)
    - TODO
10. redis做缓存是分布式存的？不同的服务器上存的数据是否重复？guava cache呢？是否重复？不同的机器存的数据不同
    - 分布式
    - TODO
11. redis的hash算法用的是啥？
    - redis应该是使用一致性hash算法---MurmurHash3 算法，
        - 具有低碰撞率优点，google改进的版本cityhash也是redis中用到的哈希算法。
        - 现有的主流的大数据系统都是用的 MurmurHash本身或者改进3，
12. nosql为啥比sql快？
    - Nosql是非关系型数据库，因为不需要满足关系数据库数据一致性等复杂特性所以速度快；
    - sql是关系型数据库，功能强大，但是效率上有瓶颈
13. Redis高性能的原因大概可以讲一些?
    - 内存
    - 单线程 防止锁竞争
    - spoll
    - 队列
    - 数据结构
    
### Mongodb/Hbase
1. mongodb和hbase的区别
    - TODO
    
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
5. 统计一个整数的二进制表示中bit为1的个数
    - 移位 &
    - TODO
6. 将一个链表反转（用三个指针，但是每次只发转一个）
    - TODO
7. 四则元算写代码
    - TODO
8. 二叉树遍历
    - 前跟遍历
    - 中根遍历
    - 后根遍历
9. 快速排序性能考虑
    - TODO
10. 1000个苹果放10个篮子，怎么放，能让我拿到所有可能的个数
    - TODO
11. 二分查找算法
    - O(lgn)

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
13. 分布式锁
    - redis, UUID, 解铃还须系铃人
14. 一万个人抢100个红包，如何实现（不用队列），如何保证2个人不能抢到同一个红包，可用分布式锁
    - 分布式锁
    - 桶
    - 数组index
15. 5台服务器如何选出leader(选举算法)
    - TODO
16. 主从复制
    - redis
    - mysql
    - 增加可用性
17. 分布式事务（JTA）
    - TODO
18. 高并发下，如何做到安全的修改同一行数据？
19. A服务调用B服务多接口，响应时间最短方案；
    - TODO
20. A系统给B系统转100块钱，如何实现？
21. 多线程下读概率远远大于写概率.如何解决并发问题？
    - 读写锁
    - 主从
    - 分区
22. 你是怎么控制缓存的更新？(被动方式/主动方式/增量/全量)？
    - TODO
23. 什么是一致性hash？
    - TODO
24. 如何做限流策略. 令牌桶和漏斗算法的使用场景？

### 大数据
1. mapreduce过程
2. 海量url去重类问题
3. 对分词技术的了解
4. 大量用户数据如何在内存中排序和去重
5. 海量登录日志如何排序和处理
6. 10万个ip段如何快速查找
7. Solr和Lucene，中文分词技术
8. 统计100G的ip文件中出现ip次数最多的100个ip
    - TODO
9. 4亿个int数，如何找出重复的数（用hash方法，建一个2的32次方个bit的hash数组，每取一个int数，可hash下2的32次方找到它在hash数组中的位置，然后将bit置1表示已存在）
    - bitmap
10. 4亿个url，找出其中重复的
    - 考虑内存不够，通过hash算法，将url分配到1000个文件中，不同的文件间肯定就不会重复了，再分别找出重复的）有1万个数组，每个数组有1000个整数，
    每个数组都是降序的，从中找出最大的N个数，N<1000