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
        - 一旦 主节点出现故障, 需要手动将一个从节点升级为主节点, 应用方需要修改主节点地址, 
            还需要命令其他从节点从 新的主节点复制数据 : **高可用**
        - 主节点的写能力受到单机的限制
        - 主节点的存储能力受到单机的限制

### Redis Sentinel 高可用
1. 配置文件
    - port 26379
    - daemonize yes
    - logfile "26379.log"
    - dir /opt/soft/redis/data
    - sentinel monitor mymaster 127.0.0.1 6379 2 --> 2--代表判断主节点失败至少需要2个 Sentinel节点同意
    - sentinel down-after-milliseconds mymaster 30000
    - sentinel parallel-syncs mymaster 1
    - sentinel failover-timeout mymaster 180000
2. 监控多个节点
    - 只需要指定多个masterName来区分不同的主节点即可
3. 动态设置参数
    - sentinel set <param> <value>
    
    
### API


### 客户端连接 Sentinel节点集合+ masterName
1. 遍历Sentinel节点集合获取一个可用的Sentinel节点
    - Sentinel之间共享数据
    - 可以从任意一个Sentinel节点获取主节点信息
2. 通过 sentinel get-master-addr-byname master-name 获取主节点信息
3. 验证当前的主节点是否是 真正 的主节点, 防止故障转移期间的 主节点变化
4. 保持与 Sentinel节点之间的联系, 时刻获取关于主节点的相关信息

### Java客户端源码解析
1. 主节点变化
    - 每个Sentinel线程 启动一个线程
    - 通过订阅 +switch-master 频道,
    - Redis Sentinel在结束对主节点故障转移后会发布切换主节点的消息，
    - Sentinel节点基本将故障转移的各个阶段发生的行为都通过这种发布订阅的形式对外提供



### Sentinel 实现原理
1. 三个定时任务
    - **每隔10秒， 每个Sentinel节点会向主节点和从节点发送info命令获取最新的拓扑结构**
        - 获取主节点信息
        - 感知新加入的从节点
        - 节点不可达或者故障转移后, 更新节点的拓扑结构
    - **每隔2秒， 每个Sentinel节点会向Redis数据节点的__sentinel__： hello**
        频道上发送该Sentinel节点对于主节点的判断以及当前Sentinel节点的信息
        - 发现新的 Sentinel节点
        - 交换主节点的状态, 作为后面客观下线以及领导者选举的依据
    - **每隔1秒， 每个Sentinel节点会向主节点、 从节点、 其余Sentinel节点送一条ping命令做一次心跳检测， 
        来确认这些节点当前是否可达**
        - 
2. 主观下线
    - 每个Sentinel节点对 主节点, 从节点, Sentine节点, 每隔1秒, ping, 
    - 超过down-after-milliseconds 没有有效回复, 失败判定, 主观下线
    - 是当前 Sentinel的一家之言, 有误判可能
3. 客观下线
    - 当主观下线的是主节点的时候
    - 向其他Sentinel节点询问对主节点的判断
    - 超过 quorum 认定下线,  则下线主节点, **Sentinel领导节点故障转移**
4. Sentinel领导者选举
    - **Raft算法确定leader**
5. 故障转移
    - 过滤: “不健康”（主观下线、 断线） 、 5秒内没有回复过Sentinel节
          点ping响应、 与主节点失联超过down-after-milliseconds*10秒。
    - 选择slave-priority（从节点优先级） 最高的从节点列表
    - 选择复制偏移量最大的从节点（复制的最完整）
    - 选择runid最小的从节点
    -  Sentinel领导者节点会对第一步选出来的从节点执行slaveof no one命
      令让其成为主节点
    - Sentinel领导者节点会向剩余的从节点发送命令， 让它们成为新主节
      点的从节点， 复制规则和parallel-syncs参数有关。
    - Sentinel节点集合会将原来的主节点更新为从节点， 并保持着对其关
      注， 当其恢复后命令它去复制新的主节点。

### 故障转移日志分析
1. TODO