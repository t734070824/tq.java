2018-04-28

## api的理解与运用

### 数据结构与内部编码
1. String
    - raw
    - int
    - embstr
2. hash
    - hashTable
    - zipList
3. list
    - linkedList
    - zipList
4. set
    - hashTable
    - intset
5. zset
    - skiplist
    - ziplist

### 单线程架构
1. I/O多路复用模型


### 单线程还是那么快
1. 纯内存访问
2. **非阻塞I/O， Redis使用epoll作为I/O多路复用技术的实现， 再加上
   Redis自身的事件处理模型将epoll中的连接、 读写、 关闭都转换为事件， 不
   在网络I/O上浪费过多的时间**
3. 单线程避免了线程切换和竞态产生的消耗   
    - 简化数据结构与算法的实现: 并发数据结构的实现 困难并且难以测试
    - 避免了线程切换和竞态产生的消耗   
4. 问题:
    1. 对每个命令的执行时间有要求, 如果某个命令执行过长, 会阻塞其他命令
    
### 增量迭代 scan
1. 每次执行都只会返回少量元素
1. 使用 SMEMBERS 命令可以返回集合键当前包含的所有元素， 
    但是对于 SCAN 这类增量式迭代命令来说， 因为在对键进行增量式迭代的过程中， 键可能会被修改， 
3. **增量式迭代命令只能对被返回的元素提供有限的保证** 
    
### 字符串 API
1. SET key value [EX seconds] [PX milliseconds] [NX|XX]: 
    - EX second ：设置键的过期时间为 second 秒。 SET key value EX second 效果等同于 SETEX key second value 。
    - PX millisecond ：设置键的过期时间为 millisecond 毫秒。 SET key value PX millisecond 效果等同于 PSETEX key millisecond value 。
    - NX ：只在键不存在时，才对键进行设置操作。 SET key value NX 效果等同于 SETNX key value 。
    - XX ：只在键已经存在时，才对键进行设置操作。
    - 因为 redis的单线程命令处理机制, 如果多个客户端同时执行 setnx key value, 只有一个客户端会成功--> **分布式锁**
2. incr(自增), decr(自减), incrby(自增指定数字), decrby, incrbyfloat(自增浮点数)         
3. append: 向字符串尾部增加值
4. getset: 设置并返回原值

    

### 字符串 内部编码
1. int: 8个字节的长整数
    - set num 55
    - 64位2进制
    - long 最大值
2. embstr: 大于等于38个字节的字符串
3. raw : 大于 39 个字节的字符串

### 字符串 应用场景
1. 缓存
    - 请求-redis-mysql
2. 技术
    - 视频播放次数
3. 共享session
    - 分布式web应用
    - 单点登录
4. 限速
    - 验证码登录 多少秒之内--> 带有过期时间的key
    
### hash 内部编码
1. ziplist(压缩列表)                    
    - 当哈希类型元素的个数小于 hash-max-ziplist-entries 配置(512)
    - 同时所有值都小于 hash-max-ziplist-value 配置(64字节)
2. hashtable:
    - 无法满足 ziplist的时候
    - 当 有key 或者 value 大于64字节
    - **当恢复成满足ziplist的条件时, 不会改变为 ziplist**    
    
### list    
1. 有序列表
2. 最多 2的32次方-1
3. 可以对列表两端插入(push) 和 弹出(pop)
4. 可以充当 栈 与 队列的 角色
4. 可以重复

    
### brpop / blpop
1. 如果有多个键, brpop / blpop 会从左至右遍历键, 一旦有一个键能弹出元素, 客户段立刻返回
2. 多个客户端同时执行 brpop / blpop, 最先执行命令的客户端可以获取弹出的值

### list 内部编码
1. ziplist  
    - 当列表类型元素的个数小于 list-max-ziplist-entries 配置(512)
    - 同时所有值都小于 list-max-ziplist-value 配置(64字节)
2. linkedlist
    - 无法满足 ziplist

    
### list 应用场景    
1. 消息队列
2. 文章列表
3. 其他
    - lpush+lpop=Stack（栈）
    - lpush+rpop=Queue（队列）
    - lpsh+ltrim=Capped Collection（有限集合）
    - lpush+brpop=Message Queue（消息队列）
    
### 集合
1. 不允许有 重复元素
2. 无序, 无法通过下标获取
3. **最多 2的32次方-1**  
4. 支持集合内的增删改查, 多个集合的 交,并差 集

### set 内部编码
1. intset : 当集合中的元素**都是整数**且元素个数小于配置（默认512个） 时
2. hashtable（哈希表） ： 当集合类型无法满足intset的条件时， Redis会使用hashtable作为集合的内部实现。

### set 使用场景
1. 标签(tag)
    - 给用户添加标签-->推荐系统
    - 给标签添加用户-->共同关注
2. 注意
    - **给用户添加标签 以及 给标签添加用户 应该在同一个 事务中进行**
    - 删除同样
3. 其他
    - sadd=Tagging（标签）
    - spop/srandmember=Random item（生成随机数， 比如抽奖）
    - sadd+sinter=Social Graph（社交需求）    
    
### SortedSet
1. 分数从小到大排序
2. 第一个排名=0;
3. 

### SortedSet 内部编码
1. ziplist（压缩列表）
    - 当有序集合的元素个数小于zset-max-ziplistentries配置（默认128个）
    - 同时每个元素的值都小于zset-max-ziplist-value配置（默认64字节）
2. skiplist（跳跃表）
    - 当ziplist条件不满足时， 有序集合会使用 skiplist 作为内部实现    
    
### SortedSet 应用场景
1. 用户赞数
2. 排行榜

### 键管理
1. SET: **某个原本带有生存时间（TTL）的键来说， 当 SET 命令成功在这个键上执行时， 这个键原有的 TTL 将被清除。**
2. 迁移键:
    - move
    - dump+restore
        - 在源Redis上， dump命令会将键值序列化， 格式采用的是RDB格式
        - 在目标Redis上， restore命令将上面序列化的值进行复原， 其中ttl参数代表过期时间， 如果ttl=0代表没有过期时间
        - **整个迁移过程并非原子性的， 而是通过客户端分步完成的**
        - **迁移过程是开启了两个客户端连接， 所以dump的结果不是在源Redis和目标Redis之间进行传输**
    - migrate
        - 实际上migrate命令就是将dump、 restore、 del三个命令进行组合， 从而简化了操作流程。
        - **migrate命令具有原子性**， 而且从Redis3.0.6版本以后已经支持迁移多个键的功能， 有效地提高了迁移效率        
        - 在 水平扩容中起到重要作用
3. 渐进式遍历
    - 有效解决 keys * 遍历造成的阻塞
    - 如果在 scan的过程中如果有键的变化(增加, 修改, 删除)
        - 新增的键 没有遍历到
        - 遍历到重复的键
        - 
        
### 切换数据库
1. redis渐渐的废弃掉多个数据路的功能
    - redis单线程, 如果使用多个数据库, 这些数据依然使用同一个CPU, 彼此之间还是会受影响                
    - 多数据的使用方式, 在调试和运维的时候变得困难
    - 一个慢查询的存在会影响其他数据库
    
### 回顾
1. Redis提供5种数据结构， 每种数据结构都有多种内部编码实现。
2. 纯内存存储、 IO多路复用技术、 单线程架构是造就Redis高性能的三
个因素。
3. 由于Redis的单线程架构， 所以需要每个命令能被快速执行完， 否则
会存在阻塞Redis的可能， 理解Redis单线程命令处理机制是开发和运维Redis
的核心之一。
4. 批量操作（例如mget、 mset、 hmset等） 能够有效提高命令执行的效
率， 但要注意每次批量操作的个数和字节数。
5. 了解每个命令的时间复杂度在开发中至关重要， 例如在使用keys、
hgetall、 smembers、 zrange等时间复杂度较高的命令时， 需要考虑数据规模
对于Redis的影响。
6. persist命令可以删除任意类型键的过期时间， 但是set命令也会删除
字符串类型键的过期时间， 这在开发时容易被忽视。
7. move、 dump+restore、 migrate是Redis发展过程中三种迁移键的方
式， 其中move命令基本废弃， migrate命令用原子性的方式实现了
dump+restore， 并且支持批量操作， 是Redis Cluster实现水平扩容的重要工
具。
8. scan命令可以解决keys命令可能带来的阻塞问题， 同时Redis还提供了hscan、 sscan、 zscan渐进式地遍历hash、 set、 zset    