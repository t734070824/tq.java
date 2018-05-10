2018-05-10

## 理解内存

### 内存使用统计
1. info memory
    - used_memory_rss: 从操作系统显示Redis进程占用的物理内存总量 
    - used_memory: 内部存储的所有数据内存占用量
    - mem_fragmentation_ratio: used_memory_rss / used_memory
    - 当mem_fragmentation_ratio>1时， 说明used_memory_rss-used_memory多出
      的部分内存并没有用于数据存储， 而是被内存碎片所消耗， 如果两者相差很
      大， **说明碎片率严重**
    - 当mem_fragmentation_ratio<1时， 这**种情况一般出现在操作系统把Redis
      内存交换（Swap）** 到硬盘导致， 出现这种情况时要格外关注， 由于硬盘速
      度远远慢于内存， Redis性能会变得很差， 甚至僵死
2. 测试Redis  mem_fragmentation_ratio > 400???

### 内存消耗划分
1. 对象内存
    - 简单理解为 sizeof(key) + sizeof(value)
2. 缓冲内存
3. 内存碎片
    - 频繁的更新操作,
    - **大量的过期键删除**: 键对象过期删除之后, 释放的空间无法得到充分利用, 导致碎片率上升
    - 解决:
        - 数据对齐
        - 安全重启:主从切换, 安全重启

## 内存管理
1. 控制内存上限
    - maxmemory参数限制最大内存
        - 用于缓存场景, 超出内存上限, 使用 LRU 等删除策略释放空间
        - 防止所用内存超过服务器物理内存,
        - redis默认无限使用服务器内存, 防止极端情况下导致系统内存耗尽
2. 动态调整内存上限
    - config set maxmemory 6GB 
    - 
2. 回收策略实现
    - 删除到达过期时间的键对象
        - 精确删除消耗大量CPU, 成本太高
        - 惰性删除
            - 节省CPU
            - 问题: 单独使用这种方式, 当过期键一致没有访问, 将无法得到及时删除, 导致内存不释放--内存泄漏
        - 定时任务删除机制
            - 定时任务
            - 自适应算法, 根据键的过期比例, 使用快慢两种速率模式回收键
                - TODO
    - 内存达到maxmemory上限是触发内存溢出的控制策略
        - noeviction: 默认策略, **不会删除任何数据, 拒绝写入操作并返回错误**
        - volatile-lru: 根据LRU算法删除设置了超时属性（expire） 的键， 直
                       到腾出足够空间为止。 如果没有可删除的键对象， 回退到noeviction策略。
        - allkeys-lru： 根据LRU算法删除键， 不管数据有没有设置超时属性，直到腾出足够空间为止
        - allkeys-random： 随机删除所有键， 直到腾出足够空间为止。
        - volatile-random： 随机删除过期键， 直到腾出足够空间为止。
        - volatile-ttl： 根据键值对象的ttl属性， 删除最近将要过期数据。 如果
        没有， 回退到noeviction策略