2019-04-08

## 思考
1. 分布式session管理各种方案的优缺点以及适用场景
    - Session Sticky: 同一个回话绑定在一个服务器处理
    - Session Replication: 集群间复制
    - Session Cache: 集中缓存, 或者单独的Sessionf服务器
    - Cookie Based