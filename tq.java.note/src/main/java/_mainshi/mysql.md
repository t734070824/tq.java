### 数据库(mysql)

2. 数据库是怎么搭建集群的，主从数据同步怎么做的？
    - ***
    - 20181223 
    - 
4. 索引原理 种类, 好处与问题
    - 二叉树, 哈希表
    - BTree
    - B+Tree
    - 随机-->顺序
    - 排序, 查找快
    - 数量大时 效率低
    - 模糊查找, 范围查找 --> hash index
5. 垂直和水平拆分, 谁先拆分, 拆分的原则
    - 垂直
        - 表字段根据具体业务分离, 然后join查询, 事务
    - 水平
        - 分库, 分表, 数据量大, 为了提高并发效率, 数量量查分
        - hash
        - 取模
6. SQL优化
    - 延迟关联
    - 索引最左原则
8. Statement PrepareStatement区别
    - PreparedStatement
        - 参数化查询
        - 防止SQL注入攻击
        - 预先编译
10. 主键索引和非主键索引的区别, 分别属于哪类索引
    - 聚簇索引
    - 非聚簇索引
12. 数据库自增主键可能的问题
    - 数据热点问题
    - 数据同步复制 不一致的问题
13. 数据库锁表的相关处理
    - S X
    - IS IX
    - 
14. mysql的行级锁加在哪个位置
    - version
15. myisam和innodb的区别（innodb是行级锁，myisam是表级锁）
    - 锁
    - 事务
    - 索引
16. mysql其他的性能优化方式
    - 数据类型
    - 索引
    - 读写分离
    - 缓存表/汇总表
    - TODO
17. mysql的binlog
    - sql执行日志
    - 复制, 备份
18. mysql是如何实现事务的
    - redo --  持久
    - undo --  原子
    - 锁 + mvcc -- 隔离
    - 持久+原子+隔离 --> 一致
19. 读写分离何时强制要读主库，读哪个从库是通过什么方式决定的，从库的同步mysql用的什么方式
    - TODO
20. mysql的存储引擎
    - myISAM
    - InnoDB
    - Memory
21. mysql的默认隔离级别，其他隔离级别
    - 未提交读
    - 提交读
    - 重复读
        - 默认级别
        - 幻读
        - MVCC
    - 串行化
22. sql语句各种条件的执行顺序，如select， where， order by， group by
    - 树
    - 从下往上
23. select xx from xx where xx and xx order by xx limit xx； 如何优化这个（看explain）
    - explain
    - 延迟关联 主键先筛选一遍
24. 求表的size，或做数据统计可用什么存储引擎
    - MyISAM
    - Innodb
25. 读多写少可用什么引擎
    - MyIsam
    - Innodb
26. 假如要统计多个表应该用什么引擎
    - Innodb
27. myisam的优点，和innodb的区别
    - 读快
    - 无事务支持
    - 表锁
    - 全文索引 hash index
28. innodb对一行数据的读会加锁吗？
    - 不加锁，读实际读的是副本
    - for update
    - share mode
29. mysql的三大引擎是啥？
    - mysql常用的引擎有InnoDB，MyISAM，Memory，
    - 默认是InnoDB
        - 磁盘表，支持事务，支持行级锁，B+Tree索引
        - 优点： 
            - 具有良好的ACID特性。
            - 适用于高并发，更新操作比较多的表。
            - 需要使用事务的表。
            - 对自动灾难恢复有要求的表。
        - 缺点：
            - 读写效率相对MYISAM比较差。
            - 占用的磁盘空间比较大。
    - MyISAM
        - 磁盘表，不支持事务，支持表级锁，B+Tree索引
        - 优点
            - 占用空间小，处理速度快（相对InnoDB来说）
        - 缺点
            - 不支持事务的完整性和并发性MEMORY(Heap)：内存表，不支持事务，表级锁，Hash索引，不支持Blob,Text大类型
        - 适用于
            - 不支持事务的完整性和并发性MEMORY(Heap)：内存表，不支持事务，表级锁，Hash索引，不支持Blob,Text大类型
30. 什么是索引? 为啥nosql没索引？
    - nosql有索引,索引分为聚簇索引和非聚簇索引两种，聚簇索引是按照数据存放的物理位置为顺序的，而非聚簇索引就不一样了；
    - 聚簇索引能提高多行检索的速度，而非聚簇索引对于单行的检索很快。
    - 聚簇索引：有主键时，根据主键创建聚簇索引；
    - 没有主键时，会用一个唯一且不为空的索引列做为主键，成为此表的聚簇索引；
    - 如果以上两个都不满足那innodb自己创建一个虚拟的聚集索引非聚簇索引：非聚簇索引都是辅助索引，像复合索引、前缀索引、唯一索引
31. B+树和B树区别？
    - B树的非叶子节点存储实际记录的指针，
    - 而B+树的叶子节点存储实际记录的指针,B+树的叶子节点通过指针连起来了, 适合扫描区间和顺序查找。
32. 索引失效
    - 最左原则
    - mrr, icp
33. 离散度高的字段和性别建立联合索引会怎么样
    - 离散度高的字段在前
34. 慢sql, 索引优化, 大事务,
    - 20190610
        - show_query_log
        - explain
    - now
        - long_query_time
        - slow_query_log
        - slow_query_log_file
        - log_queries_not_using_indexes
        - MySQLdumpslow -s c -t 10 /tem/file/slow.log
        - Explain
            - type
                - const, eq_reg, ref, rang, index, all 
            - possible_keys
            - key
            - rows
35. 内核参数调优
36. 共享锁 排它锁 
    - S, X
    - SS共享
37. 意向锁
    - 表锁
    - 不与 共享锁 排它锁 冲突
    - 会和 表的 X S 冲突
38. MVCC 具体实现
    - undo version
    - next key lock
39. 间隙锁
    - Record Lock + Gap Lock
    - 幻读
40. 一个事务锁住了一条数据, 另一个事务可以查吗
    - 看 锁的类型, 
    - shard mode(S) 
    - for update(X)
1. MySQL 有哪些存储引擎啊？都有什么区别？
1. Float、Decimal 存储金额的区别？
1. Datetime、Timestamp 存储时间的区别？
1. Char、Varchar、Varbinary 存储字符的区别？
1. 对比一下B+树索引和 Hash索引？
    - hash
        - 定值
        - 无法范围
        - 无法排序
1. MySQL索引类型有？
    - 聚簇 自适应hash
    - 普通索引
        - 
1. 如何管理 MySQL索引？
    - B + TRee
1. 索引利弊是什么及索引分类？
    - 快
    - 空间
    - 分类
        - 数据结构
            - B+tree
            - hash
        - 物理存储
            - 聚集 非聚集
        - 逻辑角度
            - 主键, 普通, 多列, 唯一, 空间
1. 聚簇索引和非聚簇索引的区别？
    - 主键
    - 非主键
1. B+tree 如何进行优化？索引遵循哪些原则？
    - 选择性强的在前, 数值类型在前
    - 最左
1. 索引与锁有什么关系？
    - 锁住索引对应的数据行
1. 还有什么其他的索引类型，各自索引有哪些优缺点？
1. 谈谈对Innodb事务的理解？
1. 说说数据库事务特点及潜在问题？
1. 什么是MySQL隔离级别？
1. 有多少种事务失效的场景，如何解决？
1. 一致性非锁定读和一致性锁定读是什么？
    - mvcc Repeatable read
    - for update, lock in share mode
1. Innodb如何解决幻读？
    - next-key lock
1. 讲讲Innodb行锁？
    - 事务, version, mvcc , s,x is, ix,
1. 死锁及监控是什么？
    - TODO
1. 自增长与锁 ，锁的算法，锁问题，锁升级是什么？
    - TODO
1. 乐观锁的线程如何做失败补偿？
    - 回滚, 重试
1. 高并发场景（领红包）如何防止死锁，保证数据一致性？
    - 分段
1. 谈谈MySQL的锁并发？
    - mvcc
1. 查询优化的基本思路是什么？
    - 汇总表
    - 索引
    - 延迟关联
        - select * from table_x inner join (select Key from table_x order by xxx limit m , n) tt using(key)
1. 说说MySQL读写分离、分库分表？
    - 主从
    - 垂直 水平拆分
1. 表结构对性能有什么影响?
1. 浅谈索引优化？
1. 说说Sql优化的几点原则？
1. MySQL表设计及规范？
1. 说说MySQL几种存储引擎应用场景？
1. MySQL常用优化方式有哪些？
1. MySQL常用监控？
1. MySQL瓶颈分析？
1. 数据库如实现 rollback
1. 第一二三范式
1. 一个表一千个列值 为 true和false, sql查询, 有 300个列值为true的行
1. mysql 主从同步异常以及处理
    - TODO
1. mysql查询到达叶子节点是如何查询的
    - 二分
1. 不可重复读 vs 幻读
    - update vs add/delete
    - mvcc vs next-key
1. 组合索引? B+树如何存储的？
    - 组合索引
        - 先根据前面的索引列排序, 相同在排序下一列
        - 这个也是 最左前缀的原因
    - B+树如何存储的
        - 非聚簇索引
            - 叶子阶段存储的是 主键索引
        - 聚簇索引(主键索引)
            - 叶子节点 存储的是实际数据的物理地址
        