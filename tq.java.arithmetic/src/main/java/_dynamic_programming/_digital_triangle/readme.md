2018-03-10

### 数字三角形
1. 数字三角形中寻找一条从顶部到底边的路径，使得路径上所经过的数字之和最大。
路径上的每一步都只能往左下或 右下走。只需要求出这个最大和即可，
不必给出具体路径。 三角形的行数大于1小于等于100，数字为 0 - 99
2. http://blog.csdn.net/baidu_28312631/article/details/47418773
3. http://blog.csdn.net/u013445530/article/details/45645307

```text
    5      //表示三角形的行数    接下来输入三角形
    7
    3   8
    8   1   0
    2   7   4   4
    4   5   2   6   5 
```

### 动态规划
1. 抽象
    - H 高度, 
    - D( r, j) 来表示第r行第 j 个数字(r,j从1开始算),  
    - MaxSum(r, j)表示从D(r,j)到底边的各条路径中，最佳路径的数字之和。
1. 最优子结构
    - MaxSum(r＋1,j) + D(r,j) 
    - MaxSum(r+1,j+1) + D(r,j)  
2. 边界
    - if ( r == N) MaxSum(r,j) = D(r,j)   
5. 状态转移公式
    - MaxSum(r,j) = D(r,j)  (r == N)
    - MaxSum(r,j) = Max(MaxSum(r＋1,j), MaxSum(r+1,j+1)) + D(r,j) 
 