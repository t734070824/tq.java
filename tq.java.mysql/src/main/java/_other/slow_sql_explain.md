2019-06-10

## 慢sql

### 开启参数
1. slow_query_log
    - 设置为 ON, 可以捕获超过一定数据的sql语句
2. long_query_time
    - sql语句执行时间超过此数值,记录到日志中, 单位秒
3. slow_query_log_file
    - 日志文件
4. log_queries_not_using_indexes
    - 设置为 ON, 捕获所有未使用索引的sql语句

### 运行时设置
1. set global show_query_log=ON
2. set global long_query_time=1
3. set global long_queries_not_using_index=ON
4. set global slow_query_log_file = /data/mysql/mysqlslow.log

### 获取慢语句
1. MySQLdumpslow
    - MySQLdumpslow -s c -t 10 /tmp/slow-log
        - -s
            - 表示按照何种方式排序
            - c t l r 
                - 记录次数, 时间, 查询时间, 返回的记录数
            - ac, at, al, ar
                - 表示相应的倒叙
        - -t
            - TOP
    - MySQLdumpslow -s r -t 10 /tmp/slow-log
        - 当前语句表示: 返回记录最多的10个查询
2. mysql.slow_log(表)
    - 直接查询表

### 分析(Explain)
1. select_type
    - 表示 SELECT 的 类型
    - simple
        - 简单表, 不适用连接 或者 子查询
    - primary
        - 主查询，即外层的查询
    - UNION
        - UNION 中的第二个或者后面的查询语句
    - SUBQUERY 
        - 子查询中的第一个 SELECT 
1. table
    - 显示这一行的数据关于那张表
2. **type**
    - 显示连接使用的那种类型: 最好到最差: 
        - const
            - 单表中最多匹配一行
        - eq_reg
            - 多表连接中 使用 primary key 或者 unique index
        - ref
            - 与 eq_reg 类似, 区别在于使用 普通索引
        - range
            - 单表中的范围查询
        - index
            - 每一行都需要通过索引来查询
        - All
            - 全表扫描
3. possible_keys
    - 可能应用的索引
4. key
    - 实际使用的索引
    - **要想强制MySQL使用或忽视possible_keys列中的索引，在查询中使用FORCE INDEX、USE INDEX或者IGNORE INDEX。**
5. ref
   - 显示索引的哪一列被使用了，如果可能的话，是一个常数
6. rows
    - mysql认为必须检查的用来返回请求数据的行数

### 总结
1. EXPLAIN不会告诉你关于触发器、存储过程的信息或用户自定义函数对查询的影响情况
1. EXPLAIN不考虑各种Cache
1. EXPLAIN不能显示MySQL在执行查询时所作的优化工作
1. 部分统计信息是估算的，并非精确值
1. EXPALIN只能解释SELECT操作，其他操作要重写为SELECT后查看执行计划。(20190720)
    - mysql5.7以及之后 可以对 delete update 进行解释了
   