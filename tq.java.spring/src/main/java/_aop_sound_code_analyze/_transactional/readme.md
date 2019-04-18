2018-07-02

## @Transactional 源码解析

### Q
1. 注解在非 public方法不起作用
2. 一个没有加@Transactional注解的方法，去调用一个加了@Transactional的方法, 事务不起作用

### 消失的事务
1. 一个没有加@Transactional注解的方法，去调用一个加了@Transactional的方法, 事务不起作用

![](1.jpg)

![](2.jpg)

![](3.jpg)

![](4.jpg)

