2018-03-07

### 事务
1. 通过txSelect()开启一个事务，然后发送消息给服务器，
然后通过txCommit()提交该事务，即可以保证，如果txCommit()提交了，
则该消息一定会持久化，如果txCommit()还未提交即服务器崩溃，则该消息不会服务器就收。
当然Rabbit MQ也提供了txRollback()命令用于回滚某一个事务

### Confirm 机制
1. 使用事务固然可以保证只有提交的事务，才会被服务器执行。但是这样同时也将客户端与消息服务器同步起来，这背离了消息队列解耦的本质
2. 如果设置channel为confirm状态，则通过该channel发送的消息都会被分配一个唯一的ID，
然后一旦该消息被正确的路由到匹配的队列中后，服务器会返回给生产者一个Confirm，该Confirm包含该消息的ID，这样生产者就会知道该消息已被正确分发
3. Confirm机制的最大优点在于**异步**，生产者在发送消息以后，即可继续执行其他任务
4. 而服务器返回Confirm后，会触发生产者的回调函数，生产者在回调函数中处理Confirm信息
5. 如果消息服务器发生异常，导致该消息丢失，会返回给生产者一个nack，表示消息已经丢失，这样生产者就可以通过重发消息，保证消息不丢失
6. Confirm机制在性能上要比事务优越很多。但是Confirm机制，**无法进行回滚**，就是一旦服务器崩溃，
生产者无法得到Confirm信息，生产者其实本身也不知道该消息吃否已经被持久化，只有继续重发来保证消息不丢失，
但是如果原先已经持久化的消息，并不会被回滚，这样队列中就会存在两条相同的消息，系统需要支持去重


### 编程模式
http://blog.csdn.net/u013256816/article/details/55515234
1. 实现生产者confirm有三种编程方式
    - 普通confirm模式：每发送一条消息后，调用waitForConfirms()方法，等待服务器端confirm。实际上是一种串行confirm了。
    - 批量confirm模式：每发送一批消息后，调用waitForConfirms()方法，等待服务器端confirm。
    - 异步confirm模式：提供一个回调方法，服务端confirm了一条或者多条消息后Client端会回调这个方法。
2. 批量confirm模式稍微复杂一点，客户端程序需要定期（每隔多少秒）或者定量（达到多少条）或者两则结合起来publish消息，
然后等待服务器端confirm, 相比普通confirm模式，批量极大提升confirm效率，但是问题在于一旦出现confirm返回false或者超时的情况时，
客户端需要将这一批次的消息全部重发，这会带来明显的重复消息数量，并且，当消息经常丢失时，批量confirm性能应该是不升反降的    
3. 异步confirm模式的编程实现最复杂，Channel对象提供的ConfirmListener()回调方法只包含deliveryTag（当前Chanel发出的消息序号），
我们需要自己为每一个Channel维护一个unconfirm的消息序号集合，每publish一条数据，集合中元素加1，每回调一次handleAck方法，
unconfirm集合删掉相应的一条（multiple=false）或多条（multiple=true）记录。从程序运行效率上看，
这个unconfirm集合最好采用有序集合SortedSet存储结构。实际上，SDK中的waitForConfirms()方法也是通过SortedSet维护消息序号的
