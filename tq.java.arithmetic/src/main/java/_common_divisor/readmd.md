2018-02-05 

### 欧几里德算法 
```$xslt
证明：a可以表示成a = kb + r，则r = a mod b 
假设d是a,b的一个公约数，则有 
d|a, d|b，而r = a - kb，因此d|r 
因此d是(b,a mod b)的公约数

假设d 是(b,a mod b)的公约数，则 
d | b , d |r ，但是a = kb +r 
因此d也是(a,b)的公约数

因此(a,b)和(b,a mod b)的公约数是一样的，其最大公约数也必然相等，得证
```