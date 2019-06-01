### Zookeeper
1. zookeeper的实现机制，有缓存，如何存储注册服务的
    - TODO
2. zookeeper的事物，结点，服务提供方挂了如何告知消费方
    - TODO
1. 和 redis 分布式锁的区别
    - redis
        - SET my:lock 随机值 NX PX 30000 
    - zookeeper
        - 基于临时顺序节点
        - create, EPHEMERAL_SEQUENTIAL
        - watcher **比自己节点的序列号小的最大的节点** 