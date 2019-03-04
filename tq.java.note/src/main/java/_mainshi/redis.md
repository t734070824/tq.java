### Redis/Memcached
1. 为什么单线程,还很快??
    - 纯内存
    - 单线程, 无锁
    - 非阻塞I/O
        - epoll
    - **C语言实现**
    
2. redis几种数据结构 底层如何实现
    - string
    - list
    - map
    - set
    - sortSet
    - bitmap
    - TODO H..log
    - TODO 实现
    
3. Redis的主键争用问题如何解决
    - 不推荐事务
        - 在生产环境中, 都是 redis 集群, 做了数据分片操作
        - 一个事务可能涉及多个key的操作, 多个key 不一定都存储在同一个 redis-server
    - 对key的操作不要求顺序
        - 分布式锁
        - 抢到锁 就去 set
    - 对key的操作要求顺序
        - 将数据写入数据库是 保存时间戳/ 版本信息
        - 队列 , 串行访问
        
4. Redis事务的CAS操作吗
    - 单独使用 multi+exec不支持
    - 需要 watch
    
5. Redis持久化的几种方式
    - RDB
    - ADF
    
6. Redis的缓存失效策略
    - 定时删除+惰性删除
    - 如果定期删除没删除key。然后你也没即时去请求key，也就是说惰性删除也没生效。这样，redis的内存会越来越高。
    - 那么就应该采用内存淘汰机制
        - noeviction
        - allkeys-lru
        - 
    
7. memcache和redis的区别
    - TODO memcache 
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
1. redis数据结构有哪些？
1. Redis缓存穿透，缓存雪崩？
1. 如何使用Redis来实现分布式锁？
1. Redis的并发竞争问题如何解决？
1. Redis持久化的几种方式，优缺点是什么，怎么实现的？
1. Redis的缓存失效策略？
1. Redis集群，高可用，原理？
1. Redis缓存分片？
1. Redis的数据淘汰策略？
1. redis队列应用场景？
1. 分布式使用场景（储存session）？