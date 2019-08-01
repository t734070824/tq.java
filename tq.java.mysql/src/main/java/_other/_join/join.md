2019-08-01

## JOIN

### 原理
1. 嵌套for循环

### Simple Nested-Loop Join(简单嵌套循环连接)
1. 双层for嵌套, 通过循环外层表的行数据, **逐个与内层表的所有行数据** 进行比较
2. 特点
    - 简单粗暴 容易理解
    - O(n^2)

![](1.png)


### Index Nested-Loop Join(索引嵌套循环连接)
1. 减少内层表数据的匹配次数, 避免内层的全表扫描
2. 要求 匹配的字段必须建立索引

![](2.png)

### Block Nested-Loop Join（缓存块嵌套循环连接）
1. 减少外层表的循环次数
2. 一次缓存外层表的多条数据, 缓存到 join buffer, 然后批量和内层表的数据进行匹配
3. 当我们不使用Index Nested-Loop Join的时候，默认使用的是Block Nested-Loop Join。

