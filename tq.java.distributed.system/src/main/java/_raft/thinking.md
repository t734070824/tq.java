2018-09-27

## 思考
1. 理解: 状态机从log里面取出所有命令, 执行一遍, 得到的结果就是我们对外提供的保持了一致性的数据 
    - 命令不一定是连续的
    - log即数据
2. 启动选主过程, 此副本会变成 Candidation, 直到选主结束
    - 会有选主失败的情况
    - 100ms-300ms随机时间

3. 什么时候一条日志会被 commited
    - safely replication??
    - 所有节点执行??
    
4 哪些Follower有资格成为Leader
      - **Raft保证被选为新leader的节点拥有所有已提交的log entry**
      - 思考为什么