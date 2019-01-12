2019-01-12

## RabbitMQ 运维

### RabbitMQ 集群
1. **不能保证消息万无一失**
    - 当集群中一个 RabbitMQ 节点崩溃时，该节点上的所有队列中的消息也会丢失
2. 基于存储空间和性能的考虑 ， 在 RabbitMQ 集群中创建队列，集群只会在单
   个节点而不是在所有节点上创建队列的进程并包含完整的队列信息(元数据 、状态、内容)
    - 只有队列的宿主节点知道队列的所有信息, 所有其他非所有者节点只知道队列的元数据和指向该队列存在的那个节点的指针

### 集群节点类型
1. RabbitMQ 中的每一个节点 ，不管是单一节点系统或者是集群中的一部分 ，
   要么是内存节点(--disc)，要么是磁盘节点(--ram)。
2. 修改
    - rabbitmqctlchange cluster node type {disc,ram) 
    - 步骤
        - rabbitmqctl stop_app
        - rabbitmqctl change_cluster_node_type disc
        - rabbitmqctl start_app
        - rabbitmqctl cluster_status
3. 在集群中创建队列、交换器或者绑定关系的时候，这些操作直到所有集群节点都成功提交元数据变更后才会返回
    - disc: 写入磁盘
    - ram: 写入内存

### 剔除节点
1. 建议使用 reset(清空节点的状态 ， 并将其恢复到空白状态。)
   - rabbitmqctl stop_app
   - rabbitmqctl reset
   - rabbitmqctl start_app

### 查看服务日志
1. rabbitmq-server -detached
    - 顺带启动 Erlang 虚拟机和 RabbitMQ 应用服务
2. rabbitmqctl start_app/start_app
    - 用来启动/关闭 RabbitMQ 应用服务
3. rabbitmqctl stop/start
    - 用来启动/关闭 RabbitMQ 应用服务 以及 Erlang虚拟机
    
### 单点故障恢复
1. 配置数据节点冗余(镜像队列)可以有效地防止由于单点故障而降低整个集群的可用性、可靠性