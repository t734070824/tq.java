2018-04-11

### spring 事务 传播行为
1. PROPAGATION_REQUIRED: 如果当前存在一个事务, 就加入当前事务. 如果不存在事务, 就创建一个新的事务
![](https://github.com/t734070824/tq.java/blob/master/tq.java.spring/src/main/java/_spring_jie_mi/_5_transaction_management/2.jpg?raw=true)

2. PROPAGATION_SUPPORTS: 如果当前存在一个事务, 就加入当前事务, 如果当前不存在事务, 就直接执行
    - 如果当前方法可以直接执行, 执行不需要事务的支持, 
    - 当前方法被其他方法调用, 而其他方法启动了一个事务, 可以保证当前方法也加入事务, 并洞察当前事务对数据资源所做的更新
3. PROPAGATION_MANDATORY: 强制要求当前存在一个事务, 不存在抛异常
![](https://github.com/t734070824/tq.java/blob/master/tq.java.spring/src/main/java/_spring_jie_mi/_5_transaction_management/1.jpg?raw=true)

4. PROPAGATION_REQUIRES_NEW: 不管当前存不在事务, 都会创建新的事务. 如果当前存在事务, 就会将当前事务挂起(Suspend)
    - 适用于 某个业务对象所做的事情不想影响到外层事务 
![](https://github.com/t734070824/tq.java/blob/master/tq.java.spring/src/main/java/_spring_jie_mi/_5_transaction_management/3.jpg?raw=true)
       
5. PROPAGATION_NOT_SUPPORTED: 不支持当前事务, 而是在没有事务的情况下执行
    - 如果当前存在事务的话, 当前事务原则上将被挂起(Suspend), 但要看对应的 PlaformTransactionManager实现类是否支持事务的挂起     
6. PROPAGATION_NEVER: 永远不需要当前存在事务, 如果存在事务, 抛出异常
7. PROPAGATION_NESTED: 如果存在当前事务, 则在当前事务的一个嵌套事务中执行, 否则与 PROPAGATION_REQUIRES_NEW 一样, 创建一个先的事务, 
    在新的事务中执行
     
    
    