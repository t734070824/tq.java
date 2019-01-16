2019-01-16

## 问题

### 在kafka 的 server.properties 中 listeners 使用默认值的问题
1. 如果配置为localhost或服务器的hostname,在使用java发送数据时就会抛出异 常：org.apache.kafka.common.errors.TimeoutException: Batch Expired 。因为在没有配置advertised.host.name 的情况下，Kafka并没有像官方文档宣称的那样改为广播我们配置的host.name，而是广播了主机配置的hostname。远端的客户端并没有配置 hosts，所以自然是连接不上这个hostname的
