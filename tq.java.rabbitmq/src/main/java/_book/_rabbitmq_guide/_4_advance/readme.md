2018-08-29

## 进阶

### 消息何去何从
1. mandatory 参数
    - true: 交换器无法根据自身类型以及路由建找到一个符合条件的队列, Basic.return 命令将消息返回给消费者
        - 
        ![](1.jpg)
    - false: 出现上面的情况 , 直接丢弃 
        -
        ![](2.jpg)
2. imrnediate
    - true: 如果交换器在将消息路由到队列时发现队列上并不存在
            任何消费者，那么这条消息将不会存入队列中。当与路由键匹配的所有队列都没有消费者时 ，
            该消息会通过 Basic.Return 返回至生产者。
    - 已去掉对此参数的支持

### 备份交换机
1. args.put("alternate-exchange","exchange-name")
2. channe1.exchangeDec1are( "norma1Exchange" , "direct" , true , fa1se , args)
3. 当消息不能路由到任何与 norma1Exchange 绑定的任何队列上, 就会发送给  备份交换机

### 过期时间(Time to Live)
1. 可以 对消息以及队列 设置 TTL
2. 设置队列的TTL, 则所有的消息都会有相同的过期时间
    - x-expires:毫秒
3. 对信息本身进行设置, 每条消息都可以不同
    - **当两个都设置了 TTL, 两者之间较小的值为准**
    - 参数: x-message-ttl:毫秒
    
### 死信队列
1. DLX, Dead-Letter-Exchange 死信交换机
2. 当一个消息变成死信, 会被重新发送到 DLX
    - 消息被拒绝 && requeue = false
    - 消息过期
    - 队列达到最大长度
3. 作用
    - 在异常情况下, 消息没有被正确的消费, 被置入死信队列, 后续程序可以消费死信队列来分析系统遇到的问题
    - DLX + TTL --> 延迟队列

### 延时队列
1. 不想让消费者立刻拿到消息, 等待特定时间后, 消费者才可以拿到消息
2. 应用
    - 订单 30min 之内支付, 未按时支付, 订单做异常处理, 
    - 延迟工作

### 优先级队列


### RPC 实现
1. 回调
2. 唯一id

### 持久化
1. 交换机的持久化
2. 队列的持久化
    - 消息的持久化不会内部所存储的消息不会丢失
    - BasicProperties.deliveryMode = 2
    - MessageProperties.Persistent_text_plain 封装了这个特性
3. 消息的持久化
    - 消息的持久化 以及 队列 的持久化要一起设置才有意义
4. 交换机, 队列, 消息 都设置为持久化, 数据就不可以能丢失吗?
    - 可能丢失
    - 丢失情况
        - autoAck = true
        - 消息存入 MQ 之后, 还需要有一段时间才会同步磁盘-- **fsynx**
            - 这段时间发生宕机 重启 , 数据还没有同步磁盘
            - 解决
                - **镜像队列机制**
                - 发送端的事务机制
                - 发送方确认机制

### 生产者确认
1. 发送方无法确定 消息是否已经到达服务器
2. 解决
    - 事务机制
        - channel.txSelect
            - 设置当前信道为 事务模式
        - channel.txCommit
        - channel.txRollBack
        - 与数据库的事务机制有 区别
        - 缺点
            - 多了4个步骤
            - 损失性能
            - 一条消息发送之后, 发送端阻塞
    - 发送方确认(publisher confirm)
        - confirm 模式
        - 唯一id, 有序
        - 一次确认多个(id之前)
        - 异步, 
        - 优化
            - 批量 confirm
                - 定期(定量) 
                - 出现超时或者是 Basic.nack 的时候 , 需要将消息重发
            - 异步 confirm
                - 回调
                - 编程复杂
                - 性能做好
                - **做好消息重发机制**