2019-04-19

## 技术内幕
1. 系统模型
2. 序列化与协议
3. 客户端工作原理
4. 会话
4. 服务端工作原理
4. 数据存储


### 系统模型
1. 数据模型(ZNode)
    - 树
    - 事务id: 
        - 改变 Zookeeper 服务器状态的操作
2. 节点类型
    - 持久
    - 持久顺序
    - 临时
    - 临时顺序
3. 状态信息
    - cZxid = 0x1a
        - Create
    - ctime = Fri Apr 19 11:47:23 CST 2019
    - mZxid = 0x35
        - Modified
    - mtime = Sun Apr 21 09:58:17 CST 2019
    - pZxid = 0x1a
        - **子节点列表最后一次修改的事务id**
        - 只关心子节点列表, 不关心子节点内容
    - cversion = 0
        - child
    - dataVersion = 5
    - aclVersion = 0
    - ephemeralOwner = 0x0
        - 创建该节点的会话的 Sessionid, 如果该节点是永久节点 =0
    - dataLength = 1
    - numChildren = 0
        - 孩子节点的数量
4. 版本
    - 分布式数据原子操作
    - CAS
5. Watcher--数据变更通知
    - [](watcher.md)
6. ACL--保证数据安全
    - TODO
    
### 序列化
1. TODO

### 协议
1. len + 请求头/响应头 + 请求体/响应体
2. 请求协议解析
    - len(0-3): 整个请求包的数据包长度
    - xid(4-7): 客户端请求的发起序号
    - type(8-11): 客户端请求类型
        - 根据type的不同, 内容也不同, 以 getData 为例
        - len(12-15): 节点路径的长度
        - path(xx-xx): 节点路径(根据 节点路径的长度 来)
        - watch(最后一个): 是否注册 Watcher
2. 响应洗衣解析
    - len(0-3): 整个请求包的数据包长度
    - xid(4-7): 客户端请求的发起序号
    - zxid(8-15): 当前服务器处理过的最新的 ZXID
    - err(16-19): 错误码
    - len(20-23): getData 就标识 节点数据内容的长度
        - ...
3. 具体分析
    - 请求
        - 00 00 00 18 / 00 00 00 0a / 00 00 00 04 /  00 00 00 0b / 2f 74 61 6e 67 71 69 6e 67 2f 31 00
        - 00 00 00 18 --> 24 len
        - 00 00 00 0a --> 10 xid
        - 00 00 00 04 --> 4  type
        - 00 00 00 0b --> 11 len
        - 2f 74 61 6e 67 71 69 6e 67 2f 31 --> path
        - 00 --> 0 
    - 响应
        - 00 00 00 59 / 00 00 00 0a / 00 00 00 00 00 00   
          00 3b / 00 00 00 00 /  00 00 00 01 / 34 /
          00 00 00 00 00 00 00 1a 
          00 00 00 00 00 00 00 35 
          00 00 01 6a 33 b4 b9 a0 
          00 00 01 6a 3d 9d 90 89 
          00 00 00 05 
          00 00 00 00 
          00 00 00 00 
          00 00 00 00 00 00 00 00 
          00 00 00 01 
          00 00 00 00 
          00 00 00 00 00 00 00 1a      
        - 00 00 00 59 --> 89 len
        - 00 00 00 0a --> 10 xid
        - 00 00 00 00 00 00 00 3b --> 59 zxid
        - 00 00 00 00 --> 0 err
        - 00 00 00 01 --> 1 len
        - 34 --> 4 data
        - 00 00 00 00 00 00 00 1a --> 1a 8位 czxid
        - 00 00 00 00 00 00 00 35 --> 35 8位 mzxid
        - 00 00 01 6a 33 b4 b9 a0 --> 8位 创建时间 ctime
        - 00 00 01 6a 3d 9d 90 89 --> 8位 最后一次修改时间 mtime
        - 00 00 00 05 --> version 节点内容版本号
        - 00 00 00 00 --> cversion
        - 00 00 00 00 --> aversion
        - 00 00 00 00 00 00 00 00 --> ephemeralOwner
        - 00 00 00 01 --> datalength
        - 00 00 00 00 --> 子节点个数
        - 00 00 00 00 00 00 00 1a --> pzxid
        
### Client
1. TODO

### 会话
[](session.md)

### Leader 选举
[](leader.md)

### 各服务器角色介绍
1. Leader
    - **事务请求的唯一调度和处理者**, 保证集群事务处理的**顺序性**
    - 集群内各服务器的调度者
    - 请求处理链
        - 责任链模式
        - PrepRequestProcessor
            - ProposalRequestProcessor
                - CommitProcessor
                    - ToBeAppliedRequestProcessor
                    - FinalRequestProcessor
                - SyncRequestProcessor
                    - AckRequestProcessor
        - PrepRequestProcessor
            - 第一个请求处理器
            - 判断是否是事务请求
            - 创建请求事务头, 事务体, 会话检查, ACL检查, 版本检查
        - ProposalRequestProcessor
            - **事务投票处理器 以及 事务处理流程的发起者**
            - 非事务请求直接到 CommitRequestProcessor
            - 事务请求
                - 提交给 CommitRequestProcessor
                - 根据请求创建对应的Proposal建议, 发送给所有的 Follower 发起集群内的事务投票
                - 同时, SyncRequestProcessor 进行事务日志记录
        - SyncRequestProcessor
            - 事务日志记录处理器
            - 将事务日志记录到文件中
            - 触发Zookeeper 进行 数据快照
        - AckRequestProcessor
            - **Leader 特有的处理器**
            - 向 Proposal 收集器发送 Ack 反馈, 表示自己已完成对该 Proposal 的事务日志记录
        - CommitProcessor
            - 事务提交处理器
            - 非事务请求, 直接下一个处理器
            - 事务请求
                - 等待集群内针对 Proposal 的投票直到 Proposal 可以被提交
        - ToBeAppliedRequestProcessor
            - ToBeApplied队列: 专门存储已被CommitProcessor 处理过的可以被提交的 Proposal
            - 将请求逐个 交个 FinalRequestProcessor 处理 
            - 处理完之后 再从 队列中移除
        - FinalRequestProcessor
            - 最后的处理器
            - 创建响应
            - 应用到内存数据库
    - LearnerHandler
        - 负责 Follower/Observer 服务器和leader 服务器之间的网络通信
        - 数据同步, 请求转发, Proposal 提议
2. Follower
    - 主要工作
        - 处理非事务请求, 转发事务请求给Leader 服务器
        - 参与事务 Proposal 的投票
        - Leader 选举投票
    - 责任链模式
        - FollowerRequestProcessor
            - CommitProcessor
                - FinalProcessor   
        - SendAckRequestProcessor
    - FollowerRequestProcessor
        - 第一个
        - 识别事务请求, 转发 Leader
    - SendAckRequestProcessor Vs AckRequestProcessor(Leader)
        - 相同
            - 完成事务日志后反馈
        - 不同
            - AckRequestProcessor处理器和 leader 服务器在同一个服务器上, ACK反馈只是一个本地操作
            - SendAckRequestProcessor 发送 ACK 给 Leader 反馈
2. Observer
    - 主要工作
        - 和 Observer 类似
        - 处理非事务请求, 转发事务请求给Leader 服务器
        - **不参与任何形式的投票**
        
### 集群间通信
1. TODO
         
    