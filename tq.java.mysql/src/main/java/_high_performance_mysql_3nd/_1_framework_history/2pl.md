2018-09-08

## 两阶段锁协议(two-phase locking protocol, 2PL)

### 事务加锁方式
1. 一次性锁协议
    - 一次性申请所有锁, 之后不再申请任何锁
    - 某个锁不可用, 申请失败, 事务无法执行
    - 事务尾端, 一次性释放所有锁
    - **不会产生死锁, 但 事务的并发度不高**
2. 两阶段锁协议
    - https://my.oschina.net/alchemystar/blog/1438839
    - https://www.cnblogs.com/zszmhd/p/3365220.html
    - 两个阶段, 加锁阶段, 解锁阶段
    - mysql 将 执行commit/rollback之后为解锁阶段, 其他都为加锁阶段
    - 缺点
        - 死锁
        - 幻读
3. 树形协议
    - //TODO
4. 时间戳排序协议
    - //TODO
5. vs mvcc
    - //TODO