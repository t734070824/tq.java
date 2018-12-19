2018-12-19

## String

### String的拼接
1. 常量池
    - String str1 = "ab";
    - String str2 = "ab";
    - 然后String又是不可变的，这就没有必要弄出两个"ab"对象了
        - str1 == str2
2. + 的内部实现
    - String s3 = s2 + "b"
    - 其实就是创建了一个StringBuilder对象，然后一直append, 最后 toString();
    - StringBuilder.toString
        - return new String(value, 0, count);
3. 字符串常量 相加 -- 常量折叠
    - 前端编译器（简单理解就是javac）会把值先算出来
    - s = "ab"
    - s2 = "a" + "b";
    - s == s2