2018-04-28

## 初识Redis


### 为什么那么快
1. 数据放在内存中
2. **C语言实现**
3. eopll多路复用 事件驱动
3. 单线程, 避免多线程的竞争问题

### 全称
1. Remote Dictionary Server 远程字典服务器

### 功能
1. 键过期
2. 发布订阅, 实现消息系统
3. Lua脚本
4. 简单的事务功能
5. Pipeline

### 持久化
1. RDB
2. AOF

### 应用
1. 缓存
2. 排行榜系统
3. 计数器应用
4. 社交网络
5. 消息队列系统:发布订阅功能, 阻塞队列


### shutdown
1. 指定端口实例: redis-cli -p 6380 shutdown

### redis-cli
1. redis-cli -h {host} -p {port} -a {pass}