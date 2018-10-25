2018-10-21

## 思考
1. 引用程序需要同时使用 Hibernate 和 JDBC(Ibatis) 进行数据访问, 可以使用 HibernateTransactionManager
    进行事务的统一管理, **只要 Hibernate 的 SessionFactory 和 JDBC(Ibatis) 使用的是同一个DataSource**
    - Connection
2. 