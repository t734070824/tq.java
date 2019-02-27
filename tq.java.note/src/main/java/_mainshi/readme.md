2018-02-28

# 面试题

### 项目
1. 项目遇到什么难以解决的bug
2. 项目怎么改为分布式








### 开源框架
#### Dubbo
1. Dubbo实现了远端rpc调用，请手写一个rpc调用
2. 


    
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
    - 考虑内存不够，通过hash算法，将url分配到1000个文件中，不同的文件间肯定就不会重复了，再分别找出重复的
11. 有1万个数组，每个数组有1000个整数，
    每个数组都是降序的，从中找出最大的N个数，N<1000