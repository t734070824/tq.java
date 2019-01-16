2018-12-18

## 安装

### JDK1.8

### Zookeeper
1. /usr/local/zookeeper/bin/zkServer.sh start

### Kafka
1. /usr/local/kafka/bin/kafka-server-start.sh -daemon /usr/local/kafka/config/server.properties
2. ./kafka-console-producer.sh --broker-list localhost:9092 --topic test
3. ./kafka-console-consumer.sh --zookeeper localhost:2181 --topic test --from-beginning


### broker 配置
1. 常规配置
    - broker.id
        - 每一个broker 都需要一个标识符
        - 在整个 Kafka 集群中必须是唯一的
    - port
        - 9092
    - zookeeper.connect
        - 用于保存broker 元数据的 zk 地址
    - log.dirs
        - Kafka 把所有消息都保存在硬盘上
        - 存放日志片段的目录
        - 如果指定多个目录, broker 根据 **最少使用** 原则, 把同一个分区的日志片段保存到同一个路径下
    - num.recovery.threads.per.data.dir
        - 对于如下 3 种情况， Kafka 会使用可配置的钱程池来处理日志片段 ：
            - 服务器正常启动，用于打开每个分区的日志片段
            - 服务器崩愤后重启，用于检查和截短每个分区的日志片段
            - 服务器正常关闭，用于关闭日志片段。
    - auto.create.topics.enable
        - 默认情况下， Kafka 会在如下几种情形下自动创建主题 ：
            - 当一个生产者开始往主题写入消息时
            - 当一个消费者开始从主题读取消息时
            - 当任意一个客户端向主题发送元数据请求时。
2. 主题的默认配置
    - num.partitions
        - 指定新创建的主题将包含多少个分区
        - **可以增加, 不可以减少**
        - 如何确定这个数量
            - 主题需要达到多大的吞吐量
            - 从单个分区读取数据的最大吞吐量是多少
            - 每个broker 包含的分区个数, 可用的磁盘空间和网络带宽
            - 单个 broker 对分区个数是有限制的, 分区越多, 占用的内存越多, 完成首领选取需要时间也越长
    - log.retention.ms
        - 根据时间来决定数据可以被保留多久
        - 还有 log.retention.hours, log.retention.minutes
        - 有多个, 采用最小值
    - log.retention.bytes
        - 通过保留的消息字节数来判断消息是否过期
        - **作用在每一个分区上**
    - 根据字节大小和时间保留数据
        - 同时起作用
    - log.segment.bytes
        - 作用在日志片段
        - 日志片段被关闭之前, 消息是不会过期的 
        - 当日志片段大小达到 log.segment.bytes 指定的上限（默认是 lGB ）时，当前日志片段就会被关闭，一个新的日志片段被打开。
        - **如果一个日志片段被关闭，就开始等待过期**
    - log.segment.ms
        - 指定多长时间之后日志片段会被关闭
    - message.max.bytes
        - **限制单个消息的大小**
        - 默认 1MB
        - 在服务端和客户端之间协调消息大小的配置
            - 客户端设置  fetch.message.max.bytes 必须与服务器端设值的消息大小进行协调, 如果这个值比 message.max.bytes 小,
            消费者就无法读取比较大的消息, 导致消费者堵塞的情况
    
### Kafka 集群
1. 需要多少个 broker
    - 需要多少磁盘空间来保留数据
    - 单个broker 有多少空间可用
    - 是否启用数据复制
    - 集群处理请求的能力
2. 操作系统调优
    - TODO
3. 生产环境
    - 垃圾回收期选项
        - G1
            - MaxGCPauseMillis: 该参数指定每次垃圾回收默认的停顿时间
            - InitiatingHeapOccupancyParcent: 该参数指定了在 G1 启动新一轮垃坡回收之前可以使用的堆内存百分比，默认值是 45 
        