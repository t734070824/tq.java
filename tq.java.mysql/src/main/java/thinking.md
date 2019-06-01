2019-01-23

## 思考
1. next-key-locking(间隙锁)
    - TODO
2. 插入缓冲(insert buffer), 二次写(double write), 自适应哈希索引(adaptive hash index), 预读(read ahead)
    - TODO
2. 脏页
    - TODO
1. ACID
    - 如何保证
    - TODO
2. 什么是页, 大小是多少, 怎么分布的
2. 先修改缓冲池中的页, 再以一定的频率刷新到磁盘上
    - 如何刷线 syncFile?
    - 那就有数据丢失的可能, 如何解决
        - log??
        - TODO
2. midpoint insertion strategy
    - 5/8处
    - 为什么 TODO
    
3. Flush List
    - 作用??? TODO
    - 页时怎么被放入Fulsh List
        - 变为 脏页的时候??
        - 那为什么不会和 LRU 中的脏页 刷新回磁盘的时候冲突???
1. LRU List
    - 不刷新回磁盘??
1. 脏页即存在与 Flush  列表中, 也可能存在于 LRU 列表中(在FLU List上的页面一定在LRU List上，但是反之则不成立)
    - 理解这句话TODO
2. binlog redolog 的一致性以及顺序一致性
    - TODO
1. 脏页 delete/update vs 插入缓冲
    - TODO
2. 如果页本身发生了损坏, 重做没有意义
    - TODO
2. 数据即索引, 索引即数据
    - B+Tree
1. 数据库索引采用最左原则
    - B+Tree 聚合索引
    - **单纯的第二列 不一定有序**
    - 如果以 (a,b,c) 为索引, where a=xx order by c=xxx 无法使用索引
        - a-->b-->c 的顺序来排序
1. latch 为什么没有死锁检测
    - TODO
1. 死锁如何检测
    - TODO
    - 锁的方向 有向循环图
1. 一致性非锁定读 mvcc
    - 是否和 数据一致性 冲突
    - 还是说 只是因为 读 这个操作
1. 对一个不存在的行加锁 会怎么样
    - 锁表??
    - TODO
1. Next-key locking
    - 锁的是哪一段
    - 第一个比他小的 到 第一个比他大的?
1. 原子性并不能够完全保证一致性

1. 避免随机的聚簇索引
    - 表
    - 顺序IO
    - 索引的意义
2. 会有失效的情况

2. 理解嵌套循环关联操作
    - 递归
    - 一层一层
    
2. 为什么 排序是 成本很高的操作
    - TODO
1. 如何解决 不可重复读 以及 幻读, 
    - mcvv
    - next-key locking
1. binlog, undo, redo 各个作用
    - TODO
1. 什么是事务的系统版本
    - 类似 ZXID?
    - TODO
1. varchar vs char
    - 可变, 适用于变更较少的, 内存碎片
    - 定长, 很短的 或者是 所有值都接近同一个长度, 经常变化的
1. 大表 Alter 
    - TODO
    - 让别的机器做
    - 影子表
        - TODO
    - Alter Table "anmae" **Alter Column** ...  --> 直接修改 .frm 文件而不涉及表数据
1. 什么是执行计划
    - mysql, spark 都有相关内容
    - TODO
1. 读时无锁的实现
    - MVCC
2. MVCC 如何实现的
    - 复制
    - create version, delete version
    - 乐观锁
1. 自增步长设置
    - auto_increment_offset --> 步长
    - auto_increment_increment --> 初始值
1. 消除 幻读
    - 间隙锁 + Repeatable Read
    - 或者 
1. myisam 和 innodb 数据结构上的区别
    - myisam
        - 非聚簇索引
        - 索引文件和数据文件分离
        - myi, myd
    - innodb
        - 文件绑定在一起
        - 非聚簇索引 + 聚簇索引
    