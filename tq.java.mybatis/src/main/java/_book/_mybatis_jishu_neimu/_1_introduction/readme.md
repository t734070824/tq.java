2018-11-06

## 入门

### 解决什么问题
1. 关系模型到 对象模型的转换
2. 封装这一转换
3. 映射文件

### 常见的持久化框架
1. Hibernate
    - 关系映射
    - 封装操作, 不需要直接编写SQL
    - HQL
    - 没有侵入
    - 缓存
    - 局限
        - 很难有效利用索引
        - 在 大数据量, 高并发, 低延迟的场景下不是很适合
        - 批处理支持不好
2. JPA
    - 一个规范
3. Spring JDBC
    - JDBC的简单封装
    - 多种 Template 
    - CallBack -- ResultSet
    - Spring
4. Mybatis
    - 原生SQL
    - 动态SQL

### 