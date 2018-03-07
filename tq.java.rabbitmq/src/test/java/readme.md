2018-03-06
http://blog.csdn.net/samxx8/article/details/47417133

### 消费者2种方式订阅消息    
1. 一种是通过basic.consume命令，订阅某一个队列中的消息,channel会自动在处理完上一条消息之后，接收下一条消息。
（同一个channel消息处理是串行的）。除非关闭channel或者取消订阅，否则客户端将会一直接收队列的消息
2. 另外一种方式是通过basic.get命令主动获取队列中的消息，但是绝对不可以通过循环调用basic.get来代替basic.consume，
这是因为basic.get RabbitMQ在实际执行的时候，是首先consume某一个队列，然后检索第一条消息，然后再取消订阅。
如果是高吞吐率的消费者，最好还是建议使用basic.consume。
3. 如果有多个消费者同时订阅同一个队列的话，RabbitMQ是采用循环的方式分发消息的，每一条消息只能被一个订阅者接收

### 确认与重发
1. 消费者再接到消息以后，都需要给服务器发送一条确认命令，这个即可以在handleDelivery里显示的调用basic.ack实现，
也可以在Consume某个队列的时候，设置autoACK属性为true实现。这个ACK仅仅是通知服务器可以安全的删除该消息，而不是通知生产者，与RPC不同
2. 如果消费者在接到消息以后还没来得及返回ACK就断开了连接，消息服务器会重传该消息给下一个订阅者，如果没有订阅者就会存储该消息
3.客户端发生错误，调用basic.reject命令拒绝某一个消息时，可以设置一个requeue的属性，
如果为true，则消息服务器会重传该消息给下一个订阅者；
如果为false，则会直接删除该消息。当然，也可以通过ack，让消息服务器直接删除该消息并且不会重传

### 持久化
1. abbit MQ默认是不持久队列、Exchange、Binding以及队列中的消息的，这意味着一旦消息服务器重启，
所有已声明的队列，Exchange，Binding以及队列中的消息都会丢失
2. 通过设置Exchange和MessageQueue的durable属性为true，可以使得队列和Exchange持久化，
但是这还不能使得队列中的消息持久化，这需要生产者在发送消息的时候，将delivery mode设置为2，
只有这3个全部设置完成后，才能保证服务器重启不会对现有的队列造成影响 

### broker将在下面的情况中对消息进行confirm
1. broker发现当前消息无法被路由到指定的queues中（如果设置了mandatory属性，则broker会发送basic.return） 
1. 非持久属性的消息到达了其所应该到达的所有queue中（和镜像queue中） 
1. 持久消息到达了其所应该到达的所有queue中（和镜像中），并被持久化到了磁盘（fsync） 
1. 持久消息从其所在的所有queue中被consume了（如果必要则会被ack）

### Fair dispatch 公平分发
1. 默认状态下，RabbitMQ将第n个Message分发给第n个Consumer。当然n是取余后的。它不管Consumer是否还有unacked Message，只是按照这个默认机制进行分发
2. 通过 basic.qos 方法设置prefetch_count=1 。这样RabbitMQ就会使得每个Consumer在同一个时间点最多处理一个Message。
换句话说，在接收到该Consumer的ack前，他它不会将新的Message分发给它
3. 这种方法可能会导致queue满。当然，这种情况下你可能需要添加更多的Consumer，或者创建更多的virtualHost来细化设计
4. **和 exchange的类型无关**

### Kafka VS RabbitMQ
1. http://blog.csdn.net/yangbutao/article/details/8741977

#### 架构模型
1. RabbitMQ遵循AMQP协议,以broker为中心；有消息的确认机制。 kafka遵从一般的MQ结构,无消息确认机制。


#### 吞吐量
1. kafka具有高的吞吐量，内部采用消息的批量处理，zero-copy机制，数据的存储和获取是本地磁盘顺序批量操作，具有O(1)的复杂度，消息处理的效率很高
2. rabbitMQ支持对消息的可靠的传递，支持事务，不支持批量的操作；基于存储的可靠性的要求存储可以采用内存或者硬盘
#### 可用性
1. rabbitMQ支持miror的queue，主queue失效，miror queue接管。
2. kafka的broker支持主备模式。 
#### 集群负载均衡
1. kafka采用zookeeper对集群中的broker、consumer进行管理，可以注册topic到zookeeper上；
通过zookeeper的协调机制，producer保存对应topic的broker信息，可以随机或者轮询发送到broker上；
并且producer可以基于语义指定分片，消息发送到broker的某分片上。
2. rabbitMQ的负载均衡需要单独的loadbalancer进行支持。
