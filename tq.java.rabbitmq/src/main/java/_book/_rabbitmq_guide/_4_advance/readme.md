2018-08-29

## 进阶

### 消息何去何从
1. mandatory 参数
    - true: 交换器无法根据自身类型以及路由建找到一个符合条件的队列, Basic.return 命令将消息返回给消费者
    - false: 出现上面的情况 , 直接丢弃 
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