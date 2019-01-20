2019-01-16

## 消费者

### 消费者和消费群组
1. Kafka 消费者从属与消费者群组, 
2. 一个群组里的消费者订阅的是同一个主题
3. **每个消费者接收主题一部分分区的消息**
    - 如果群组中的消费者数量超过了主题的分区数量, 就有一部分消费者会被闲置
4. 多个应用程序从同一个主题读取数据
    - 只要每个应用程序有自己的消费群组, 就可以让他们获取到主题的所有消息
    
### 消费者群组和分区再均衡
1. 再均衡
    - 分区的所有权从一个消费者注意到另外一个消费者
    - 比如
        - 新的消费者加入群组
        - 一个消费者关闭或者崩溃后, 离开群组
        - 主题的分区数发生变化
    - 高可用和可伸缩性
    - 期间, 消费者无法读取消息
2. 群组协调器
    - 消费者通过向 被指派为群组1协调器的 broker (不同的群组可以有不同的协调器) 发送心跳来维持他们和群组的从属关系, 以及他们对分区的所有权关系

### 分配分区的过程
1. 消费者加入群组是, 会向群组协调器发送一个 JoinGroup 请求, 
2. 第一个加入群组的消费者成为 群主
3. 群主从协调器获取群组的成员列表, 负责为每一个消费者分配分区
    - 实现 org.apache.kafka.clients.consumer.internals.PartitionAssignor
4. **这个过程在 每次再均衡给的时候重复发生**

### 创建消费者
1. group.id
    - 消费者所属群组的名字
    
### 订阅主题
1. 可以使用 正则表达式 来订阅多个主题
    - 当可以订阅新的主题的时候, 会触发再均衡

### 轮询
1. 消费轮询是消费者API的核心, 通过简单的轮询向服务器请求数据
2. 一旦消费者订阅了主题, 轮询会处理所有的细节
    - 群组协调, 分区再均衡, 发送心跳, 获取数据
3. 代码
    - 是一个无限循环
    - poll(timeout) 
4. poll
    - 第一次调用新消费者的 poll() 方法时, 负责查找 GroupCoordinator(协调者), 加入群组, 接受分配的分区 
    - 在同一个群组里, 无法再一个线程中运行多个消费者, 也无法让多个线程安全的共享一个消费者
    
### 消费者配置
1. TODO

### 提交和偏移量
1. 每次调用 poll, 总是返回生产者写入 kafka 但还没有被消费者读取过的记录
    - 可以追踪哪些记录是被群组的那个消费者读取的
2. 提交
    - 更新分区当前位置的操作
    - 消费者往一个叫做 _consumer_offset 的特殊主题发送消息, 包含每个分区的偏移量
    - 如果触发 再均衡后, 每个消费者可能分配到新的分区, 不再是之前处理的那个
    - 为了能够继续工作, 消费者需要读取每个分区最后一次提交的偏移量
    - **如果提交的偏移量小于客户端处理的最后一条消息的偏移量, 处理两个偏移量之间的消息就会被重复消费**
3. 自动提交
    - 配置: enable.auto.commit=true
    - 间隔: auto.commit.interval.ms
        - 默认 5s
    - 在轮询中进行
    - 问题
        - 默认 5s 的提交间隔, 如果最近一次提交后的3s 发生再均衡, 
        - 再均衡之后消费者从最后一次提交的偏移量位置开始读取消息
        - 这个 3s 内 到达的消息会被重复处理
        - **可以通过减少间隔 来减少可能出现重复消息的时间窗口**
4. 提交当前偏移量(同步提交)
    - consumer.commitSync()
        - 一直重试, 知道成功 
    - 问题
        - 在 broker 对提交的请求做出回应之前, 应用程序一直阻塞
5. 异步提交
    - consumer.commitAsync()
    - 提交的顺序会影响最终的 offset
    - 解决顺序性
        - 单调递增的序列号来维护异步提交的顺序
        - 在每次提交偏移量之后 或者 在回调里提交偏移量获取 递增的序列号
        - 重试前, 检查获取的序列号和当前的序列号是否一致, 如果一致, 说明这段时间没有新的提交, 可以重试
        - 如果序列号比较大, 说明新的提交已经发送, 应该停止重试
6. 同步和异步组合提交
    - 在while循坏中使用 异步提交
    - 在 while 外, finally 内, 使用 同步提交

### 提交特定的偏移量
1. 提交偏移量的频率和处理消息批次的频率是一致的
2. 为了避免再均衡引起的 重复处理整批消息, 想要在处理批次中间提交偏移量


### 再均衡监听器
1. ConsumerRebalanceListener
    - onPartitionsRevoked(Collection<TopicPartition> partitions)
        - **再均衡之前和消费者停止读取消息之后**   
    - onPartitionsAssigned(Collection<TopicPartition> partitions)
        - 重新分配分区之后和消费者开始读取消息之前
2. 注意
    - **提交的是最近处理过的偏移量, 而不是批次中还在处理的最后一个偏移量** 
    - **调用 commitSync() 确保再均衡之前提交偏移量**

    
```java

public class SaveOffsetsOnRebalance implements org.apache.kafka.clients.consumer.ConsumerRebalanceListener{

    private org.apache.kafka.clients.consumer.KafkaConsumer consumer;
    
    

    public void onPartitionsRevoked(Collection<TopicPartition> partitions){
        commitDBTransaction();
    }
    
    public void onPartitionsAssigned(Collection<TopicPartition> partitions){
       for (TopicPartition partition : partitions) {
           consumer.seek(partition, getOffsetFromDB(partition));
       }
    }
}

public  class SeekDemo{

    public static void main(String[] args){
      org.apache.kafka.clients.consumer.KafkaConsumer consumer;
      consumer.subscribe(topics, new SaveOffsetsOnRebalance(consumer));
      consumer.poll(0);
      
      for(org.apache.kafka.common.TopicPartition partition : consumer.assignment()){
            consumer.seek(partition, getOffsetFromDB(partition));          
      }
      
      while (true){
          org.apache.kafka.clients.consumer.ConsumerRecords<String, String> records = consumer.poll(100);
          for(org.apache.kafka.clients.consumer.ConsumerRecord<String, String> record : records){
              processRecord(record);
              storeRecordInDB(record);
              storeOffsetInDB(record.topic(), record.partition(), record.offset());
          }
          commitDBTransaction();
      }
    }
    
}

```

    
### 从特定偏移量出开始处理记录
1. **poll() 方法从各个分区的最新偏移量开始处理信息**
2. 从分区的起始位置或者是 分区的末尾开始读取消息
    - consumer.seekToBeginning(TopicPartition... partitions)
    - seekToEnd(TopicPartition... partitions)
3. 分配到新的分区之后, seek() 定位分区的偏移量
    - seek() 方法只更新 正在 使用的位置
    
### 退出
1. consumer.wakeup()
    - **消费者唯一一个可以从其他线程安全调用的方法**
    - 退出 poll, 并抛出 WakeupException 异常
    
### 独立消费者 -- 为什么以及怎么使用没有群组的消费者
1. 