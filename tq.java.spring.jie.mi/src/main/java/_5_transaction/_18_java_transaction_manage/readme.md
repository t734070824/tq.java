2018-10-21

## Java 事务管理


### 局部事务支持
1. 基于 Connection(应用程序与事务资源之间的通信通道)的API来管理事务

### 分布式事务支持
1. JTA(Java Transaction API)
    - JTA编程事务处理
        - javax.transaction.UserTransaction
2. JCA(Java Connection Architecture)
