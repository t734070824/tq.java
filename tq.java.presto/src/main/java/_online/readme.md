2019-05-14

## url
1. https://www.jianshu.com/p/86f2fecd22d1

## 参数

### coordinator
1. task.max-memory=1GB
    - 一个单独的任务使用的最大内存(一个查询计划的某个执行部分会在一个特定的节点上执行)
    - 限制 group by 的数目
    - join中 右关联表的大小
    - order by 语句中的行数
    - 一个窗口函数中处理的行数
    - 该参数应该根据并发查询的数量和查询的复杂度进行调整。如果该参数设置的太低，很多查询将不能执行；
        但是如果设置的太高将会导致JVM把内存耗光
        
### Catalog
1. 

### worker
1. query.max-memory=8GB
2. query.max-memory-per-node=1G

