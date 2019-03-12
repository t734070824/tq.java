208-06-30

## Sentinel.conf

### 配置介绍
1. sentinel monitor <master-name> <ip> <port> <quorum>
    - 这里的ip,port是主节点的
    - quorum 代表要判定主节点最终不可达所需要的票数
    - quorum = sentinel节点数 / 2 + 1
    - 至少要有 max（quorum， num（sentinels） /2+1） 个Sentinel节点参与选举, 才能选出领导者 Sentinel
2. sentinel down-after-milliseconds <master-name> <times>
    - 每个Sentinel节点都要通过定期发送ping命令来判断Redis数据节点和其
      余Sentinel节点是否可达， 
    - 如果超过了down-after-milliseconds配置的时间且没
      有有效的回复， 则判定节点不可达， <times>（单位为毫秒） 就是超时时
      间。 这个配置是对节点失败判定的重要依据。
3. sentinel parallel-syncs <master-name> <nums>
    - parallel-syncs就是用来限制在一次故障转移之后， 每次向新的主节
      点发起复制操作的从节点个数
4. sentinel auth-pass <master-name> <password>
    - 如果Sentinel监控的主节点配置了密码， sentinel auth-pass配置通过添加
      主节点的密码， 防止Sentinel节点对主节点无法监控。
5. 