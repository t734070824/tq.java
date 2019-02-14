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