2019-04-15

## ZAB(Zookeeper Atomic Broadcast)
1. 解决 Zookeeper 集群崩溃恢复, 主从同步问题

### 三种节点状态
1. Looking: 选举状态
2. Following: Flolower 节点(从节点)所处的状态
3. Leading: Leader 节点所处的状态

### ZXID
1. 最大ZXID也就是节点本地的最**新事务编号**，包含epoch和计数两部分。**epoch是纪元的意思，相当于Raft算法选主时候的term**。

### 崩溃恢复的三个阶段
1. Leader Election
    - 发送自己的 服务器id + 最新事务id
    - 投票给目前已知最大的ZXID所属节点
    - 服务器都会统计投票数量，判断是否有某个节点得到半数以上的投票
    - 变为 准leader, leading, 其他为 Following
    - 不存在呢??
        - TODO
2. Discovery
    - 发现阶段, 用于在从节点中发现最新的ZXID和事务日志
        - 这是为了防止某些意外情况，比如因网络原因在上一阶段产生多个Leader的情况
    - 接收所有Follower发来各自的最新epoch值。**Leader从中选出最大的epoch，基于此值加1，
        - 生成新的epoch分发给各个Follower。**
    - 各个Follower收到全新的epoch后，返回ACK给Leader，带上各自最大的ZXID和历史事务日志。
        **Leader选出最大的ZXID，并更新自身历史日志。**
3. Synchronization
    - 同步阶段，把Leader刚才收集得到的最新历史事务日志，同步给集群中所有的Follower。
    - 只有当半数Follower同步成功，这个准Leader才能成为正式的Leader。
    
### 数据写入
1. client --> Follower
2. Follower --> Leader
3. Leader --> 2PC
    - Propose --> Follower
    - Follower write --> ACK --> Leader
    - Leader receive ACK > 1/2, 返回 Client
    - Commit --> Follower

### 总结
1. Zab协议既不是强一致性，也不是弱一致性，而是处于两者之间的单调一致性。
2. 它依靠事务ID和版本号，保证了数据的更新和读取是有序的。