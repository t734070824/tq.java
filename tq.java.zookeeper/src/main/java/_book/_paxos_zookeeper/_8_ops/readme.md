2019-05-08

## 运维

### 配置详解
1. 基本配置
    - clientPort
    - dataDir
        - 快照文件目录
        - 也会使 事务日志文件目录
    - tickTime
        - 最小时间单元长度
        - 很多运行时时间间隔使用 tickTime 的倍数表示
2. 高级配置
    - dataLogDir
        - 事务日志文件目录
        - 事务日志对磁盘性能的要求很高, 为了保证一致性, 在返回客户端的事务请求响应之前, 必须将本次请求对应的事务日志
            写入磁盘
        - 事务日志写入性能直接决定 处理事务请求的吞吐
    - initLimit
        - Leader等待 Follower 启动, 并完成数据同步的时间
        - 如果集群数量较大, 从 Leader 同步的时间变长, 可以调大这个参数
    - syncLimit
        - Leader 和 Follower 之间进行心跳检测的最大时延时间
        - 网络质量不好可以 调大这个参数
    - snapCount
        - 在 snapCount 之后会进行一次数据快照
    - preAllocSize
        - 事务日志预分配大小
        - 与 snapCount 配合使用
    - minSessionTimeOut, maxSessionTimeOut
        - tickTime 的 2倍 和 20倍
    - maxClientCnxns
        - 在 socket 层面 限制单个客户端和单个服务器之间的并发连接数
        - 以IP地址的粒度来限制
        - 3.4.0--60
    - jute.maxBuffer
        - 单个数据节点上可以存储的最大数据量
    - server.id=host:port:port
        - id: Serverid, 与 myid 文件的数据 相对应
        - 第一个port: 指定 Follower 和 Leader 进行运行时通讯和数据同步所使用的端口
        - 第二个port: 专门用于 Leader 选举过程中的投票通信
    - fsync.warningthresholdms
        - 事务日志 fsync 操作消耗时间的报警阈值
        - 超过打印报警日志
    - forceSync
        - 默认 yes
        - 是否在提交日志的时候, 将事务日志强制刷入磁盘
    - globaloutstandingLimit
        - 最大请求堆积数量
    - skipAcl