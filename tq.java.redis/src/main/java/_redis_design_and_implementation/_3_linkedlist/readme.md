2018-07-10

## 链表

### redis本身的使用
1. 链表键
2. 发布与订阅, 慢查询, 监视器

### 实现
1. listNode
    - listNode *prev
    - listNode *next
    - void *value
2. list
    - listNode *head
    - listNode *tail
    - long *value
    - ...
2. 特点
    - 双端队列
    - head的 prev 和 tail 的 next 都 指向 null, 
    - 长度计数器
    - 多态....