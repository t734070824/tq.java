2018-04-30

## 小功能大用处

### 慢查询
1. 预设阀值:slowlog-log-slower-than
    - 如果slowlog-log-slower-than=0会记录所有的命令， slowlog-log-slowerthan<0对于任何命令都不会进行记录
2. 慢查询记录: slowlog-max-len
    - 使用了一个列表来存储慢查询日 志， slowlog-max-len就是列表的最大长度。 一个新的命令满足慢查询条件时
      被插入到这个列表中， 当慢查询日志列表已处于其最大长度时， 最早插入的一个命令将从列表中移出
3. **慢查询只记录命令执行时间， 并不包括命令排队和网络传输时间**

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
1. Redis 不支持回滚      
      
      