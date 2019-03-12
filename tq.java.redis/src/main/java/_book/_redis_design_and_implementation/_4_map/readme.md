2018-07-10

## 字典

### 实现
1. dictht
    - dictEntry **table
        - void *key
        - v
        - dictEntry *next
            - 多个哈希值相等的键连接在一起, 解决键冲突
            - java HashMap
    - long size
    - long sizemask
        - 哈希表大小掩码, 计算索引值
        - 总是等于 size -1
    - long used
        - 已有的节点数量
        
### 哈希算法
1. hashFunction(key)
    - MurmurHash
    - 哈希冲突时, 新节点放在表头, 因为 --> O(1)
    - 明白了hashMap中也是这么操作的原因
    
### 收缩与扩充
1. rehash
2. 渐进 rehash