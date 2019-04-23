2019-03-27

## Source(数据来源)

### addSource
1. 基于集合：有界数据集，更偏向于本地测试用
2. 基于文件：适合监听文件修改并读取其内容
3. 基于 Socket：监听主机的 host port，从 Socket 中获取数据
4. 自定义 addSource：大多数的场景数据都是无界的，会源源不断的过来。
    - 比如去消费 Kafka 某个 topic 上的数据，这时候就需要用到这个 addSource，
    - 可能因为用的比较多的原因吧，Flink 直接提供了 FlinkKafkaConsumer011 等类可供你直接使用。
    - 你可以去看看 FlinkKafkaConsumerBase 这个基础类，它是 Flink Kafka 消费的最根本的类。

### 自定义 Source--SourceFunction 
1. SourceFunction 