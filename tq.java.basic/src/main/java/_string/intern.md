2018-09-19

## intern

### 原理
1. 这个方法是一个 native 的方法
2. 如果常量池中存在当前字符串, 就会直接返回当前字符串. 
3. 如果常量池中没有此字符串, 会将此字符串放入常量池中后, 再返回
4. TODO https://tech.meituan.com/in_depth_understanding_string_intern.html