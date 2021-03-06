2018-03-12

### mysql服务器逻辑架构图
![](1.jpg)


### 并发控制
1. 共享锁
    - 读锁
2. 排他锁
    - 写锁

### 锁粒度
1. 锁策略:在锁的开销和数据的安全性之间寻求平衡
2. 表锁(table lock):写锁比读锁有更高的优先级, 一个写锁请求可能被插入一个读锁队列之前,反之不行
3. 行锁(row lock)
    - 只在存储引擎层实现
    - 在表上施加行级锁
    - 最大程度的支持并发处理,同时带来最大的锁开销

### ACID
1. 原子性: 不可以执只行部分操作, 要么全部成功, 要么全部失败
2. 一致性: 数据库总是从一个一致性状态到另外一个一致性状态
3. 隔离性: 一个事务所做的修改在最终提交之前, 对其他事务不可见(根据隔离级别)
    - 未提交度
    - 提交读
    - 可重复读
    - 串行化
4. 持久性: 一旦事务提交, 其所做的所有修改就会永久的保存到数据库中, 即使系统崩溃

#### 隔离级别(定义了数据库系统中一个操作的结果在何时以何种方式对其他并发操作可见)
1. 未提交读(read uncommitted):事务中的修改,即使没有提交,对其他事务也都是可见的 --> 脏读
2. 提交读(read committed):一个事务开始的时候,只能看到已经提交的事务做的修改, 大多数据库的默认隔离级别(mysql 不是) --> 不可重复读
    - READ COMMITTED隔离级别下, 读是非锁定的快照读，**且事务中的每个一致读取都会设置并读取自己的新快照**。
    - 而写会加排他锁，并到事务结束之后释放。加锁读、更新语句、删除语句，**mysql仅对where条件中的索引列的记录加锁，不会锁间隙**。
    - 对于非索引列，会先对所有行进行加锁，然后释放不满足更新条件行的锁
3. 可重复读(repeatable read):解决了**脏读**的问题, 保证在同一个事务的多次读取同样的记录的结果是一致的.
    - 幻读: 当某个事务正在读取某个范围的记录的时候,其他事务又在该范围插入了新的记录,使之前的事务在读取该范围的记录时,产生幻行
    - 解决: InnoDB对版本并发控制(MVCC, Multiversion Concurrency Control),  解决不可重复读
    - Next-key locking  解决幻读的问题
    - mysql的事务默认隔离级别    
    - REPEATABLE READ隔离级别下, 读是非锁定的快照读，**同一事务中的所有一致读取将读取该事务中第一次此类读取所建立的快照。**
    - 而写会加排他锁，并到事务结束之后释放。
    - 加锁读、更新语句、删除语句，mysql不仅会对where条件中的索引列的记录加锁，**还会锁定它们之间的间隙，如果索引时唯一索引会降级为行锁**。
    - **对于非索引列，会对所有行进行加锁。**


4. 可串行化(serializable):最高的隔离级别, 强制事务串行执行

### 脏读、幻读和不可重复读
1. 脏读 ：脏读就是指当一个事务1正在访问数据，并且对数据进行了修改，而这种修改还没有提交到数据库中，
    这时，另外一个事务2也访问这个数据，然后读取到了这个修改的数据。**当事务1回滚时, 事务2就会访问到一个错误的数据**
2. 不可重复读 ：
    - 是指在一个事务内，多次读同一数据。在这个事务还没有结束时，另外一个事务也访问该同一数据。
    - 那么，在第一个事务中的两次读数据之间，由于第二个事务的修改，那么第一个事务两次读到的的数据可能是不一样的 
3. 幻读 : 是指当事务不是独立执行时发生的一种现象，例如第一个事务对一个表中的数据进行了修改，这种修改涉及到表中的全部数据行。
    同时，第二个事务也修改这个表中的数据，这种修改是向表中插入一行新数据。
    那么，以后就会发生操作第一个事务的用户发现表中还有没有修改的数据行，就好象发生了幻觉一样    

### 不可重复读 vs 幻读
1. 不可重复读
    - 侧重 修改
    - mvcc
2. 幻读
    - 侧重 新增和删除
    - 间隙锁
    
### 

#### 死锁
1. 多个事务在同一个资源上相互占用, 并请求对方释放占用的资源, 导致恶性循环的情况
2. 死锁检测 以及 死锁超时机制
2. 解决:
    - 检测到死锁的循环依赖, 返回错误: 有向循环图 DAG
    - 等待锁的时间超时, 放弃锁请求
    - InnoDB: 将持有最少行级排它锁的事务进行回滚
    
#### 事务日志
1. 存储引擎在修改表的数据只需要修改内存拷贝, 修改行为 记录到持久在硬盘上的事务日志中
2. 日志追加, 顺序IO, 
3. 事务日志持久之后, 后台线程慢慢的刷会硬盘, **修改数据需要写两次磁盘**
    - 事务日志
    - 数据文件
4. 数据恢复用

#### Mysql中的事务
1. 默认采用 自动提交
    - 如果不显示的开启一个事务, 每次查询都被当做一个事务执行提交操作
2. 修改 autocommit对非事务的表, 比如 MyISAM或者是内存表没有任何影响

#### 隐式和显式锁定
1. InnoDB采用的是**两阶段锁定协议***(two-phase locking protocol)
2. 在事务执行过程中, 随时都可以执行锁定, 锁只有在执行 commit 或者是 rollback 的时候才会释放
1. **Innodb 根据隔离级别在需要的时候自动加锁**
3. InnoDB 也支持通过特定的语句进行显式锁定
    - select ... lock in share more
    - select ... for update

### MVCC
1. 乐观并发控制, 悲观并发控制
2. mysql中 InnoDB 的MVCC
    - 通过在每行记录后面保存两个隐藏的列来实现的
    - **一个保存行的创建时间, 一个保存行的过期时间(删除时间)**(mvcc实现的根本)     
    - 存储的不是实际的时间值, 而是 **系统版本号**
3. 具体操作(InnoDB)
    - Select(同时满足)
        - 数据系统版本 <= 事务的系统版本
        - 删除版本 == null || 删除版本 > 事务的系统版本
    - Insert
        - 新插入的每一行保存当前的系统版本作为行版本号
    - Delete
        - 删除的每一行保存当前的系统版本作为删除标识
    - Update
        - **插入一行新数据**
        - 保存当前版本为行版本号
        - 保存当前系统版本号到原来的行作为删除标识

### InnoDB 概览
1. 采用MVCC支持高并发
2. 实现4个标准的隔离级别, 默认级别是 可重复读
3. 通过间隙锁(next-key locking)策略防止幻读的出现
    - 锁定查询涉及的行
    - 锁定索引中的间隙. 防止幻影行的插入
4. 内部优化
    - 从磁盘中读取数据采用 可预测性预读
    - 自动在内存中创建hash索引已加速读操作的自适应哈希索引(adaptive hash index)
    - 加速插入操作的插入缓冲区

### MyISAM
1. //TODO

### 存储引擎的选择
1. 事务
    - 需要事务 -- InnoDB
    - 不需要事务, 主要是 select 和 insert操作, MyISAM--日志数据库
2. 备份
    - 在线热备份 -- InnoDB
3. 崩溃恢复
    - InnoDB
4. 特有的特性


### 其他场景
1. //TODO