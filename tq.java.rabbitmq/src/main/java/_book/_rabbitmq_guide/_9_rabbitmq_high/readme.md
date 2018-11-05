20181105

## RabbitMQ 高阶
1. 子队列
2. 消息状态
3. 尽量减少消息堆积

### 存储机制
1. 持久层
    - 队列索引 rabbit_queue_index
        - 维护落盘消息的 消息
            - 消息的存储地点
            - 是否已被交付给消费者
            - 是否已被消费者 ack
            - 可以存储消息
        - 每个队列一个
    - 消息存储 rabbit_msg_store
        - msg_store_persistent
            - 负责持久化消息的持久化 
            - 重启不消失
        - msg_store_transient
            - 负责非持久化消息的持久化
            - 重启消失

### queue_index_embed_msgs_below
1. 消息大小
2. 默认 4096 B
3. 消息体, 属性, headers 整体的大小
4. 小于 vs 大于
    - 小于--存储在 rabbit_queue_index
    - 大于--存储在 rabbit_msg_store
    
### rabbit_queue_index
1. 顺序 段文件 存储
2. 后缀 .idx
3. 默认 Segment_Entry_Count = 16348
4. 每个 rabbit_queue_index 文件吗至少会维护一个段文件
    - queue_index_embed_msgs_below 大一点点增加 会引起内存的爆炸增长

### rabbit_msg_store
1. 追加的方式写入
2. file_size_limit
3. 后缀 .rdq
4. 垃圾回收
    - 删除的消息不会真正的删除, 只是标记为垃圾数据
    - 一个文件中都是垃圾数据才会删除
    - 合并
        - 逻辑上相邻的两个文件
        
### 队列的结构
1. TODO




        