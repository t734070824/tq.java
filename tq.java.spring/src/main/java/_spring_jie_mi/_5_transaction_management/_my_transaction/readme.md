2018-04-11

### PlatformTransactionManager
1. 完成 PlatformTransactionManager 的实现类
2. 解除它与相应数据访问对象之间通过 java.sql.Connection 的直接耦合
3. 在进行事务控制的时候, 只需要为 Service 对象提供相应的 PlatformTransactionManager 实现类即可
4. 问题:
    - 如何保证 PlatformTransactionManager 的相应方法以正确的顺序被调用
    - 如果当前数据访问操作不想进行事务管理支持, 是不是就无法获取 Connection 进行数据访问
    - 
