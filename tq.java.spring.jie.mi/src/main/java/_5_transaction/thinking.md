2018-10-21

## 思考
1. 引用程序需要同时使用 Hibernate 和 JDBC(Ibatis) 进行数据访问, 可以使用 HibernateTransactionManager
    进行事务的统一管理, **只要 Hibernate 的 SessionFactory 和 JDBC(Ibatis) 使用的是同一个DataSource**
    - Connection

2. 为什么在声明式事务管理中: 数据访问技术与事务管理实现 是 一一对应的
    - TODO
    
3. 理解 transactionproxyfactorybean2.xml 的作用, 理解 bean中 abstract 的作用

4. 深入理解 @Transactional
    - 只是一个标志
    - 需要反射支持
    
5. @Transaction 为什么建立写在 实现类上, 而不是接口
    - Dynamic Proxy -- Cglib