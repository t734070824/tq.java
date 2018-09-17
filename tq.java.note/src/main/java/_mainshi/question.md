2018-09-14

## 题目

### ---
1. junit用法，before,beforeClass,after, afterClass的执行顺序
    - TODO
2. 分布式锁
    - redis, UUID, 解铃还须系铃人
3. nginx 的请求转发算法，如何配置根据权重转发
    - TODO
4. 用hashmap实现redis有什么问题（死锁，死循环，可用 ConcurrentHashmap）
    - 死循环 TODO
    - ConcurrentHashmap 源码 
    - TODO 扩容
5. 线程的状态
    - new Thread() 
    - Runnable 
    - Running 
    - Block
        - wait
        - lock pool
        - sleep, join
    - dead 
5. 线程的阻塞的方式
    - wait
    - lock pool
    - sleep, join
6. sleep和wait的区别
    - 锁
7. hashmap的底层实现
    - 数组
    - 链表
    - 红黑树
8. 一万个人抢100个红包，如何实现（不用队列），如何保证2个人不能抢到同一个红包，可用分布式锁
    - 分布式锁
    - 桶
    - 数组index
9. java内存模型，垃圾回收机制，不可达算法
    - happer-brfore
    - TODO
    - 不可达算法 TODO
10. 两个Integer的引用对象传给一个swap方法在方法内部交换引用，返回后，两个引用的值是否会发现变化
    - TODO
    - 不会变化 TODO
    - java 内存模型 主内存 线程本地内存
    - 内存的拷贝
11. aop的底层实现，动态代理是如何动态，假如有100个对象，如何动态的为这100个对象代理
    - 动态代理
        - TODO 假如有100个对象，如何动态的为这100个对象代理
    - Cglib
        - ASM
12. 是否用过maven install。 maven test。git（make install是安装本地jar包）
    - TODO
13. tomcat的各种配置，如何配置 docBase
    - port
    - connection
    - TODO docBase 
14. spring的bean配置的几种方式
    - xml
    - anno
15. web.xml的配置
    - TODO
16. spring的监听器。
    - TODO
17. zookeeper的实现机制，有缓存，如何存储注册服务的
    - TODO
18. IO会阻塞吗？
    - readLine是不是阻塞的??
19. 用过spring的线程池还是java的线程池？
    - java
20. 字符串的格式化方法 （20，21这两个问题问的太低级了）
21. 时间的格式化方法
22. 定时器用什么做的
    - TODO
23. 线程如何退出结束
    - TODO
    - 正常停止
    - while
    - interrupt
24. java有哪些锁？
    - 乐观锁 
    - 悲观锁 
    - synchronized 
    - 可重入锁 
    - 读写锁,
    - reentrantlock与synchronized的区别
        - 锁中断
        - 尝试获取
        - 底层实现
25. ThreadLocal的使用场景
    - 不是用来解决多线程并发的
    - 想共享又不想加锁
    - connection
26. java的内存模型，垃圾回收机制
    - TODO
27. 为什么线程执行要调用start而不是直接run（直接run，跟普通方法没什么区别，先调start，run才会作为一个线程方法运行）
28. qmq消息的实现机制(qmq是去哪儿网自己封装的消息队列)
    - ....
29. 遍历hashmap的三种方式
    - for each map.entrySet()
    - 显示调用map.entrySet()的集合迭代器
    - for each map.keySet()，再调用get获取
    - for each map.entrySet()，用临时变量保存map.entrySet()
30. jvm的一些命令
    - jmap
    - jstat
    - jstack
    - jps
31. memcache和redis的区别
    - TODO memcache 
32. mysql的行级锁加在哪个位置
    - ???
33. ConcurrentHashmap的锁是如何加的？是不是分段越多越好
    - jdk7 VS jdk8
    - TODO
34. myisam和innodb的区别（innodb是行级锁，myisam是表级锁）
    - 锁
    - 事务
    - 索引
35. mysql其他的性能优化方式
    - 数据类型
    - 索引
    - 读写分离
    - 缓存表/汇总表
    - TODO
36. linux系统日志在哪里看
    - TODO
37. 如何查看网络进程
    - TODO
38. 统计一个整数的二进制表示中bit为1的个数
    - 移位 &
    - TODO
40. 如何把java内存的数据全部dump出来
    - jmap -dump:live,format=b,file=xxx pid
41. 如何手动触发全量回收垃圾，如何立即触发垃圾回收
    - System.gc()
    - Runtime.getRuntime().gc()
42. hashmap如果只有一个写其他全读会出什么问题
    - TODO
43. mongodb和hbase的区别
    - TODO
45. 如何解决并发问题
    - ...
46. volatile的用途
    - 免锁
    - 单例
    - 主内存
47. java线程池（好像之前我的理解有问题）
48. mysql的binlog
    - TODO
49. 代理模式
50. mysql是如何实现事务的
    - TODO
51. 读写分离何时强制要读主库，读哪个从库是通过什么方式决定的，从库的同步mysql用的什么方式
    - TODO
52. mysql的存储引擎
    - myISAM
    - InnoDB
53. mysql的默认隔离级别，其他隔离级别
    - 未提交读
    - 提交读
    - 重复读
        - 默认级别
        - 幻读
        - MVCC
    - 串行化
54. 将一个链表反转（用三个指针，但是每次只发转一个）
    - TODO
55. spring Aop的实现原理，具体说说
    - TODO
56. 何时会内存泄漏，内存泄漏会抛哪些异常
    - TODO
57. 是否用过Autowire注解
    - ...
58. spring的注入bean的方式
    - Byname
    - byType
    - 构造函数
59. sql语句各种条件的执行顺序，如select， where， order by， group by
    - TODO
60. select xx from xx where xx and xx order by xx limit xx； 如何优化这个（看explain）
    - explain
61. 四则元算写代码
    - TODO
62. 统计100G的ip文件中出现ip次数最多的100个ip
    - TODO
63. zookeeper的事物，结点，服务提供方挂了如何告知消费方
    - TODO
64. 5台服务器如何选出leader(选举算法)
    - TODO
65. 适配器和代理模式的区别
    - TODO
66. 读写锁
    - 读时复制
    - 写独锁
    - 读读
67. static加锁
    - class
68. 事务隔离级别
69. 门面模式，类图(外观模式)
    - Netty
70. mybatis如何映射表结构
    - TODO
71. 二叉树遍历
    - 前跟遍历
    - 中根遍历
    - 后根遍历
72. 主从复制
    - redis
    - mysql
    - 增加可用性
73. mysql引擎区别
    - TODO
74. 静态内部类加载到了哪个区？
    - 方法区 
75. class文件编译后加载到了哪
    - TODO
76. web的http请求如何整体响应时间变长导致处理的请求数变少，该如何处理？用队列，当处理不了那么多http请求时将请求放到队列中慢慢处理，web如何实现队列
    - connection
    - 队列
    - 分区
    - reacto
77. 线程安全的单例模式
    - volatile
78. 快速排序性能考虑
    - TODO
79. volatile关键字用法
    - ...
80. 求表的size，或做数据统计可用什么存储引擎
    - TODO
81. 读多写少可用什么引擎
    - MyIsam
    - Innodb
82. 假如要统计多个表应该用什么引擎
    - Innodb
83. concurrenhashmap求size是如何加锁的，如果刚求完一段后这段发生了变化该如何处理
    - jdk7 全部加锁
    - TODO jdk8
84. 1000个苹果放10个篮子，怎么放，能让我拿到所有可能的个数
    - TODO
85. 可重入的读写锁，可重入是如何实现的？
    - Thread身份
    - TODO
86. 是否用过NIO
    - ...
    - selector
    - epoll
    - reactor
87. java的concurrent包用过没
    - ...
88. sting s=new string("abc")分别在堆栈上新建了哪些对象
    - ...
89. java虚拟机的区域分配，各区分别存什么
    - TODO
90. 分布式事务（JTA）
    - TODO
91. threadlocal使用时注意的问题
    - ThreadLocal和Synchonized都用于解决多线程并发访问。
    - 但是ThreadLocal与synchronized有本质的区别。
        - synchronized是利用锁的机制，使变量或代码块在某一时该只能被一个线程访问。
        - 而ThreadLocal为每一个线程都提供了变量的副本，使得每个线程在某一时间访问到的并不是同一个对象，
        这样就隔离了多个线程对数据的数据共享。
        - 而Synchronized却正好相反，它用于在多个线程间通信时能够获得数据共享）
92. java有哪些容器
    - 集合，
    - tomcat也是一种容器
93. 二分查找算法
    - O(lgn)
94. myisam的优点，和innodb的区别
    - 读快
    - TODO
95. redis能存哪些类型
    - string
    - list
    - map
    - set
    - sortSet
    - bitmap
    - TODO H..log
96. http协议格式，get和post的区别
    - 大小
    - 可以获取
    - 
97. 可重入锁中对应的wait和notify
    - await()
    - signal
98. redis能把内存空间交换进磁盘中吗(这个应该是可以的，但是那个面试官非跟我说不可以)
    - TODO
99. java线程池中基于缓存和基于定长的两种线程池，当请求太多时分别是如何处理的？定长的事用的队列，如果队列也满了呢？交换进磁盘？基于缓存的线程池解决方法呢？
    - TODO
100. synchronized加在方法上用的什么锁
    - class
101. 可重入锁中的lock和trylock的区别
102. innodb对一行数据的读会枷锁吗？
    - 不枷锁，读实际读的是副本
103. redis做缓存是分布式存的？不同的服务器上存的数据是否重复？guava cache呢？是否重复？不同的机器存的数据不同
    - 分布式
    - TODO
104. 用awk统计一个ip文件中top10
    - TODO
105. 对表做统计时可直接看schema info信息，即查看表的系统信息
    - TODO
106. mysql目前用的版本
    - ...
107. 公司经验丰富的人给了什么帮助？(一般boss面会问这些)
    - ...
108. 自己相对于一样的应届生有什么优势
    - ...
109. 自己的好的总结习惯给自己今后的工作带了什么帮助，举例为证
    - ...azkban
110. 原子类，线程安全的对象，异常的处理方式
    - TODO
111. 4亿个int数，如何找出重复的数（用hash方法，建一个2的32次方个bit的hash数组，每取一个int数，可hash下2的32次方找到它在hash数组中的位置，然后将bit置1表示已存在）
    - bitmap
112. 4亿个url，找出其中重复的
    - 考虑内存不够，通过hash算法，将url分配到1000个文件中，不同的文件间肯定就不会重复了，再分别找出重复的）有1万个数组，每个数组有1000个整数，
    每个数组都是降序的，从中找出最大的N个数，N<1000
113. LinkedHashmap的底层实现
    - map+链表
    - LRU
114. 类序列化时类的版本号的用途，如果没有指定一个版本号，系统是怎么处理的？如果加了字段会怎么样？
    - TODO
115. Override和Overload的区别，分别用在什么场景
    - TODO
116. java的反射是如何实现的【阿里巴巴面试题目含答案】
    - TODO
117. mysql的三大引擎是啥？
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
2. redis的hash算法用的是啥？
    - redis应该是使用一致性hash算法---MurmurHash3 算法，
        - 具有低碰撞率优点，google改进的版本cityhash也是redis中用到的哈希算法。
        - 现有的主流的大数据系统都是用的 MurmurHash本身或者改进3，
3. nosql为啥比sql快？
    - Nosql是非关系型数据库，因为不需要满足关系数据库数据一致性等复杂特性所以速度快；
    - sql是关系型数据库，功能强大，但是效率上有瓶颈
4. 什么是索引? 为啥nosql没索引？
    - nosql有索引,索引分为聚簇索引和非聚簇索引两种，聚簇索引是按照数据存放的物理位置为顺序的，而非聚簇索引就不一样了；
    - 聚簇索引能提高多行检索的速度，而非聚簇索引对于单行的检索很快。
    - 聚簇索引：有主键时，根据主键创建聚簇索引；
    - 没有主键时，会用一个唯一且不为空的索引列做为主键，成为此表的聚簇索引；
    - 如果以上两个都不满足那innodb自己创建一个虚拟的聚集索引非聚簇索引：非聚簇索引都是辅助索引，像复合索引、前缀索引、唯一索引
5. B+树和B树区别？
    - B树的非叶子节点存储实际记录的指针，
    - 而B+树的叶子节点存储实际记录的指针B+树的叶子节点通过指针连起来了, 适合扫描区间和顺序查找。
6. HashMap底层执行原理，
4. hashtable和ConcurrentHashMap如何实现线程安全？
    - sync
    - 桶
    - TODO JDK8
5. 类加载机制里的，双亲委派模型
6. 阐述事务的隔离级别和传播属性
    - spring TODO
7. 高并发下，如何做到安全的修改同一行数据？
    - ...
8. A服务调用B服务多接口，响应时间最短方案；
    - TODO
9. A系统给B系统转100块钱，如何实现？
10. 动态代理的几种实现方式及优缺点
    - TODO
11. 多线程下读概率远远大于写概率.如何解决并发问题？
    - 读写锁
    - 主从
    - 分区
12. 按线程池内部机制.当提交新任务时.有哪些异常要考虑？
    - TODO
13. @Transaction注解一般写在什么位置?如何控制其回滚?
    - TODO
14. 说说Spring的IOC容器初始化流程？
    - TODO
15. 说说springboot启动机制
    - TODO
16. Redis高性能的原因大概可以讲一些?
    - 内存
    - 单线程 防止锁竞争
    - spoll
    - 队列
    - 数据结构
17. 你是怎么控制缓存的更新？(被动方式/主动方式/增量/全量)？
    - TODO
18. 浅析Http和https的三次握手有什么区别。
    - TODO
19. 谈谈Session/cookie机制. 如何实现会话跟踪？
    - TODO
20. 什么是一致性hash？
    - TODO
21. MQ有可能发生重复消费. 如何避免. 如何做到幂等？
    - TODO
22. 如何做限流策略. 令牌桶和漏斗算法的使用场景？



    

