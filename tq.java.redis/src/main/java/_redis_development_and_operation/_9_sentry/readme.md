2018-05-22

## 哨兵

### 基本概念
1. 名词解释(名词:逻辑结构, 物理结构)
    - 主节点 (master) : Redis 主服务/数据库, 一个独立的 Redis 进程
    - 从节点 (slave) : Redis 从服务/数据库, 一个独立的 Redis 进程
    - Redis 数据节点 : 主节点 和 从节点,  主节点 和 从节点的 进程
    - Sentinel 节点 : 监控Redis 数据节点, 一个独立的 Sentinel 进程
    - Sentinel 节点集合 : 若干个 Sentinel 节点的抽象, 若干个 Sentinel 节点进程
    - Redis Sentinel : Redis 高可用实现方案, Sentinel 节点集合 和 Redis 数据节点进程
    - 应用方 : 泛指一个 或 多个客户端, 一个或者多个客户端进程或者线程

2. 复制模式下故障处理可能产生的问题
    - 主从复制的问题
        - 一旦 主节点出现故障, 需要手动将一个从节点升级为主节点, 应用方需要修改主节点地址, 还需要命令其他从节点从 新的主节点复制数据 : **高可用**
        - 主节点的写能力受到单机的限制
        - 主节点的存储能力受到单机的限制

### Redis Sentinel 高可用
1. 配置文件
    - port 26379
    - daemonize yes
    - logfile "26379.log"
    - dir /opt/soft/redis/data
    - sentinel monitor mymaster 127.0.0.1 6379 2 --> 2代表判断主节点失败至少需要2个 Sentinel节点同意
    - sentinel down-after-milliseconds mymaster 30000
    - sentinel parallel-syncs mymaster 1
    - sentinel failover-timeout mymaster 180000
2. 监控多个节点
    - 只需要指定多个masterName来区分不同的主节点
      即可
3. 动态设置参数
    - sentinel set <param> <value>
    
    
### API
1. 

