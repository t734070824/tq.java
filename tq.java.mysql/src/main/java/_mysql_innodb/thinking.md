2019-01-23

## 思考
1. next-key-locking(间隙锁)
    - TODO
2. 插入缓冲(insert buffer), 二次写(double write), 自适应哈希索引(adaptive hash index), 预读(read ahead)
    - TODO
2. 脏页
    - TODO
1. ACID
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