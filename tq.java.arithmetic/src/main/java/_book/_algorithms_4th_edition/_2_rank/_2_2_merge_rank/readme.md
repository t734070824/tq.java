2018-08-15

## 归并排序

### 思想
1. 分成两部分排序, 然后归并
2. 分治思想

### 过程
1. 先部分排序
2. 然后部分归并
3. 慢慢的完成归并

### 总结
1. 所需时间和 NlogN成正比
2. 处理百万甚至更大的数组
3. 缺点
    - 辅助空间的大小 与 N 成正比
    
### 优化
1. 对小规模的子数组使用 插入排序

### 自顶向下 VS 自底向上
1. 化整为零 VS 循循渐进

### 原地归并的抽象方法