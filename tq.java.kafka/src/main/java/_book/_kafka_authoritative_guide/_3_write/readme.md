2019-01-15

## Kafka 生产者

### 创建 生产者
1. 3个必选属性
    - bootstrap.servers
    - key.serializer
        - broker 希望收到的消息的键和值都是字节数组
        - 一个实现 org.apache.kafka.common.serialization.Serializer 接口的类
    - value.serializer
2. 发送方式
    - 发送并忘记
        - 发送给服务器, 不关心是否正常到达
        - 生产者会自动尝试重发
    - 同步发送
        - send()
        - 返回 Future 对象, get() 进行等待
    - 异步发送
        - send(), 指定回调函数
        
### 生产者的配置
1. TODO

### 序列化
1. TODO

### 分区
1. 键的用途
    - 作为消息的附加信息
    - **决定消息被写到主题的那个分区**
2. 为 null 的键
    - 如果使用了默认的分区器
        - 记录会被随机的发送到主题的各个可用的分区上
        - 轮询(Round Robin) 算法均匀的分布到各个分区
    - 分区改变, 键与分区之间的映射也会改变
3. 可以自定义分区策略
    - 实现 org.apache.kafka.clients.producer.Partitioner