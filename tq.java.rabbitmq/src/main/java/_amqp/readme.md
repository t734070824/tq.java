2018-03-05

## AMQP规范中有几个核心的概念(Advanced Message Queuing Protocol 高级消息队列协议)

### Virtual Host
1. 每个Message Broker由一个或 Virtual Host构成；可以类比一下理机和虚拟机
2. Virtual Host相当于一个独立的名称空间，它有属于自己的Exchange、Queue以及的一些相关对象。不同Virtual Host之间的Exchange可以重名
3. Queue只能和相同Virtual Host中的Exchange进行绑定。

### Exchange
1. 每个Virtual Host包含0或多个Exchange。Exchange负责把Message转发到Queue。每个Exchange可以有0或者多个Queue。每个Queue只能监听1个Exchange

### Queue
1. Queue即消息队列，负责存储Exchange转发过来的Message。注意，是Queue，所以Message是First-In-First-Out。

### Binding
1. Binding指的是Exchange根据规则作出消息转发决策的过程。Message到达Exchange，Exchange此时并不知道Message应该被转发到哪些Queue，
然后Exchange根据规则对Message进行Binding决策，Binding完成之后，Exchange根据Binding的结果将Message转发到正确的Queues

### Routing Key
1. 每个Message一般来说必须指定一个Routing Key，Exchange根据Message的Routing Key进行Binding，然后完成Message的转发。

### 路由建模糊匹配
1. 常用的正则表示式不同，这里的话“#”表示所有、全部的意思；“*”只匹配到一个词

### Binding Key
1. 每个Queue一般来说必须指定一个Binding Key
2. Binding的过程其实就是根据一定的规则判定Message的Routing Key是否与Queue的Binding Key匹配，如果匹配，则转发Message到Queue
3. 如果Message的Routing Key与多个Queue的Binding Key匹配，则所有匹配的Queue都会收到该Message。

### Exchange Type
1. Exchange Type决定了Binding的匹配规则。AMQP支持三种Exchange Type：
    - Direct Exchange
    - Topic Exchange
    - Fanout Exchange
    - 单播、组播、广播??
    
### Connection
1. Publisher/Producer与Virutal Host 或 Subscriber/Consumer与Virtual Host之间的TCP连接。

### Channel
1. 通过多路复用技术，多个Channel共享同一个Connection。Message通过Channel在Publisher/Producer、Virutal Host、Subscriber/Consumer之间传递 