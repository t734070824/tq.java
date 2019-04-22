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
    
### 序列化与协议
1. 