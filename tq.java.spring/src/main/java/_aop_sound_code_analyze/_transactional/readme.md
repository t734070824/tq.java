2018-07-02

## @Transactional 源码解析

### Q
1. 注解在非 public方法不起作用
2. 一个没有加@Transactional注解的方法，去调用一个加了@Transactional的方法, 事务不起作用

