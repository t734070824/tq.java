2018-06-26

## 布隆过滤器(Bloom Filter)

### 描述
1. 大体上可以认为时 Redis中 Bitmap的升级版
2. **可以通过一个Hash函数将一个元素映射成一个位阵列（Bit Array）中的一个点**
3. 多个 hash函数, 一个元素取得多个hash, 映射多个点
4, 查询一个元素是否在列表中, 经过多个hash, 判断对应的点是否为1,  **有一个为 0 就可以判断不在列表中**


### 优点
1. 布隆过滤器存储空间和插入/查询时间都是常数
2. 不需要存储元素本身，在某些对保密要求非常严格的场合有优势

### 缺点
1. 误算率
    - 一个元素 在经过 n个hash函数之后, 在位阵列的点上都为1, 也有可能 这个数据不存在列中
    - 因为可能其他的元素已经覆盖了这几个点
1. 不能从布隆过滤器中删除元素