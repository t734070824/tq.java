2018-06-01

## 数据溢出

### Math.abs(-2147483648)
1. 相当于 Math.abs(Integer.MIN_VALUE)
2. Math.abs(a) --> (a < 0) ? -a : a;