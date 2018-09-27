208-07-02

## Raft
1. https://zhuanlan.zhihu.com/p/27207160
2. 动画: http://thesecretlivesofdata.com/raft/

### 意义
1. 一致性协议
1. 在保证即使小部分副本宕机的情况下, 系统仍然能够对外提供服务

### 架构
![](1.jpg)
1. 状态机
    - 一致性就是保证这个状态机的一致性
    - 状态机从log里面取出所有命令, 执行一遍, 得到的结果就是我们对外提供的保持了一致性的数据
2. log
    - 保存了都有修改的记录
3. 一致性模块
    - 用来保证写入的log的命令的一致性, 核心内容
    
### 协议内容
1. 副本状态
    - Leader
        - 所有请求的处理者
        - 接受client的更新请求, 同步其他副本
    - Follower
        - 请求的被动更新者
        - 从leader接受请求, 写入本地日志文件
    - Candidate
        - 如果 Follower 副本在一段时间内没有收到Leader副本的心跳, 则判断Leader可能已经故障
        - 启动选主过程, 此副本会变成 Candidate, 直到选主结束
1. Term概念
    - 时间被分为很多连续的随机长度的term, 
    - term有唯一id
1. Leader Election
    - Follwer 将自己维护的 current_term_id + 1
    - 将自己的状态转换为 Candidation
    - 发送 RequestVoteRPC 消息(带上 current_term_id) 给其他 Server
    - 结果
        - 成为 Leader
            - 收到 majority 的投票, 状态切换为 Leader
            - 定期的给其他Server发送心跳, 告诉对方是 current_term_id 所标识的 term的Leader
            - 每个Term对多只有一个Leader 
            - term作为 logical clock, 在每个RPC消息中都会带上, 用于检测过期消息
                - 如果 server 收到的 rpc_term_id > 本地 current_term_id, 则 current_term_id = rpc_term_id
                - 如果 server.state = Leader/Candidate, 则 server.state = Follower
                - 如果 server.current_term_id > rpc_term_id, 拒绝消息
        - 别人成为 Leader
            - server.state = Follower
            - server.current_term_id = rpc_term_id;
        - 没有选出 Leader
            - 投票被瓜分m, 没有 Candidate 收到 majority的投票, 没有Leader选出
            - 每个 Candidate 等待时间过期, 本地 current_term_id +1, 发起新一轮的投票
2. 投票策略
    - **每个节点在每个 Term 只有一次投票机会**
    - 每个Candidate的election timeout从150ms-300ms之间随机取


### Log Replication
1. TODO 2018-09-27