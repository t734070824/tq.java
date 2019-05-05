2019-05-05

### 推模式 消费线程模型
1. 采用 Server 推模式 当前线程直接结束了
2. 把 消息消费 委托给了 RabbitMQ 客户端 的 线程来处理
2. RabbitMQ 的客户端线程负责 消费数据, 调用 Consumer.handleDelivery
3. Channel 非线程安全, 应该重用 Connection
3. **采用 推模式后, 消息的处理就和启动它的线程无关了**