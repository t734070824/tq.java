2018-07-06

## 练习

### 第一部分
1. 在选择排序中， 一个元素最多可能会被交换多少次？ 平均可能会被交换多少次？
    - N--只要将一个有序数组右移一位就可以了, 然后tail 放在 header
    - N / N = 1
2. 构造一个含有 N 个元素的数组， 使选择排序（算法 2.1） 运行过程中 a[j] < a[min])（由此 min会不断更新） 成功的次数最大
    - 数组由 大 到 小 排序
3. 构造一个含有 N 个元素的数组， 使插入排序（算法 2.2） 运行过程中内循环（for） 的两个判断结果总是假
    - 当 a[j] 和 a[j - 1] 是一组逆序对时满足，因此这个条件总是为假 = 数组没有逆序对 = 数组有序
    - 数据有序即可(小-大)
4. 在所有的主键都相同时， 选择排序和插入排序谁更快
    - 插入排序更快
    - 选择排序无论如何都需要 n + (n-1) + (n-2) + …  + 1 = n^2/2 次比较
    - 插入排序在这种情况下只需要 n 次比较。（所有主键相同 = 数组已排序）
5. 对于逆序数组，选择排序和插入排序谁更快
    - 假设比较的开销小于等于交换的开销，此时选择排序更快
    - 比较次数	交换次数
    - 插入排序	~N^2/2	~N^2/2
    - 选择排序	~N^2/2	N