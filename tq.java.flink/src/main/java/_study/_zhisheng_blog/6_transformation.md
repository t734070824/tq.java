2019-03-27

## 转换(Transformation)

### Map
1. 其中输入是一个数据流，输出的也是一个数据流：

### FlatMap 
1. 采用一条记录并输出零个，一个或多个记录。

### Filter
1. 函数根据条件判断出结果。

### KeyBy
1. 在逻辑上是基于 key 对流进行分区。在内部，它使用 hash 函数对流进行分区。它返回 KeyedDataStream 数据流。

### 