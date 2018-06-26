2018-04-30

## 小功能大用处

### 慢查询
1. 预设阀值:slowlog-log-slower-than:微秒, 默认10000
    - 如果slowlog-log-slower-than=0会记录所有的命令， slowlog-log-slowerthan<0对于任何命令都不会进行记录
2. 慢查询记录: slowlog-max-len
    - 使用了一个列表来存储慢查询日 志， slowlog-max-len就是列表的最大长度。 一个新的命令满足慢查询条件时
      被插入到这个列表中， 当慢查询日志列表已处于其最大长度时， 最早插入的一个命令将从列表中移出
3. **慢查询只记录命令执行时间， 并不包括命令排队和网络传输时间**
5. showlog get n
    - 标识id
    - 发生时间戳
    - 命令耗时
    - 执行命令
    - 参数

### redis shell
1.

### Pipeline机制
1. **它能将一组Redis命令进行组装， 通过一次RTT传输给Redis， 再将这组Redis命令的执行结果按顺序返回给客户端**
2. Redis命令真正执行的时间通常在微秒级别， 所以才会有Redis性能瓶颈是网络这样的说法
3. 原生批量命令与Pipeline对比
    - 原生批量命令是原子的， Pipeline是非原子的。
    - 原生批量命令是一个命令对应多个key， Pipeline支持多个命令。
    - 原生批量命令是Redis服务端支持实现的， 而Pipeline需要服务端和客户
      端的共同实现。
      
### 事务 与 Lua
1. 事务(Redis 不支持回滚)
    - multi
    - sadd user:a:follow  user:b
    - zadd user:b:fans 1 user:a(数据库中已有一个相同的key, 类型是 String)
    - exec
    - 结果: 
        - 1
        - WRONGTYPE Operation against a key holding the wrong kind of value
    - user:a:follow数据成功插入
    
2. watch: 确保事务中的key 没有被其他客户端修改, 才执行事务, 否则不执行
    
3. lua
    - script load 
        - '脚本'
        - '$(xx.lua)'
    - eval 脚本内容 key个数 key列表 参数列表
    - evalsha 脚本SHA1值 key个数 key列表 参数列表
    - redis.call/ redis.pcall
    - 好处
        - Lua脚本在Redis中是原子执行的
        - 定制命令, 常驻Redis内存
        - 多条命令打包, 减少网络开销
4. lua脚本管理
    - script load
    - script exists sha1...
    - script flush
        - 清除Redis内存中已经加载的所有lua脚本
    - script kill
        - 杀掉正在执行的 lua脚本
        - 无法停止正在执行写入操作的脚本
        - 
      
      
### Bitmaps
1. 本身不是数据结构, 是一个字符串, 但可以对字符串进行 位操作(字符串 --> ASCII --> 二进制)      
2. 单独提供一套指令, 
3. 相当于位 操作
5. 相当于一个数据, 下标就是偏移量, 值就是数据(0或1)


### Bitmaps 命令
1. setbit key offset value

### Bitmap 分析
1. 做活跃用户分析:
    - 一亿用户, 5千万活跃
        - 就是一亿位 的二进制, 内存占用: 1位 * 1亿 = 12.5MB
        - 集合类型 64位 * 5千万 = 400MB
    - 如果是少量活跃 10w
        - 用 Bitmap就会浪费 内存占用: 1位 * 1亿 = 12.5MB
        - 集合: 64位 * 10w = 800KB
      
### 发布与订阅
1. 发送者（消息发布者）不需要编程，就能够向特定的接收者（消息订阅者）发送消息了
2. 订阅者可能会订阅一个或多个频道，并且只能接收已订阅频道中的消息
3. **如果一个客户端订阅了一个或多个频道，那么除了订阅和退订命令之外，这个客户端就不能运行其他命令了**

### 回顾
1. 慢查询中的两个重要参数slowlog-log-slower-than和slowlog-maxlen。
2. 慢查询不包含命令网络传输和排队时间。
4. **Pipeline可以有效减少RTT次数， 但每次Pipeline的命令数量不能无节制。**
5. Redis可以使用Lua脚本创造出原子、 高效、 自定义命令组合。
6. Redis执行Lua脚本有两种方法： eval和evalsha。
7. **Bitmaps可以用来做独立用户统计， 有效节省内存**。
8. **Bitmaps中setbit一个大的偏移量， 由于申请大量内存会导致阻塞。**
9. Redis的发布订阅机制相比许多专业的消息队列系统功能较弱， 不
   具备堆积和回溯消息的能力， 但胜在足够简单      