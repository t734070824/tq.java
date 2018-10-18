2018-08-01

## JDBC 详解

### 概念
1. Java DataBase Connectivity (Java数据库连接)

### 作用
1. 实现 **做什么 与 怎么做** 的分离
2. JDBC负责 做什么, 具体的驱动负责 怎么做

### Connection
1. 数据库连接


### PreparedStatement
1. Statement 的子接口
2. 避免sql注入
3. 可以对 SQL 进行预编译, 提高数据库的执行效率

### ResultSet
1. 从 1 开始(columnIndex)