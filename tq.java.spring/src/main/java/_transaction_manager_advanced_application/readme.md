2018-04-12

## Spring 事务管理高级应用难点剖析
***

### 没有事务管理器
1. jdbcWithoutTransManager.xml 中，没有配置任何事务管理器，但是数据已经成功持久化到数据库中
2. 在默认情况下，dataSource 数据源的 autoCommit 被设置为 true ―― 这也意谓着所有通过 JdbcTemplate 执行的语句马上提交，没有事务
3. 如果将 dataSource 的 defaultAutoCommit 设置为 false，再次运行 UserJdbcWithoutTransManagerService，将抛出错误，
原因是新增及更改数据的操作都没有提交到数据库，所以 ④ 处的语句因无法从数据库中查询到匹配的记录而引发异常

### 小结
1. 在没有事务管理的情况下，DAO 照样可以顺利进行数据操作；
1. 将应用分成 Web，Service 及 DAO 层只是一种参考的开发模式，并非是事务管理工作的前提条件；
1. Spring 通过事务传播机制可以很好地应对事务方法嵌套调用的情况，开发者无须为了事务管理而刻意改变服务方法的设计；
1. 由于单实例的对象不存在线程安全问题，所以进行事务管理增强的 Bean 可以很好地工作在多线程环境下