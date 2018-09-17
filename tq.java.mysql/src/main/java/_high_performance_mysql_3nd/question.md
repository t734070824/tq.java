208-09-08

## 问题
1. 事务的隔离级别 

2. 关于查询字段值末尾空格的匹配问题???
    - MySQL校对规则属于PADSPACE，对CHAR和VARCHAR值进行比较都忽略尾部空格，和服务器配置以及MySQL版本都没关系
    - 解决
        - select *from table where user like 'wxp ';
        - select *from table where user=BINARY 'wxp ';
        - **select * from table where user='wxp ' and  len(user)=len('wxp ');**

3. 既然Varchar 是变长的, 那是不是 越大越好??
    - 更长的列会消耗更多的内存
    - Mysql通常会分配固定大小的内存块来保存内布值, 尤其使用临时表进行排序或操作是会很糟糕
    - 利用磁盘临时表进行排序是也同样糟糕
    
4. timestamp -- 2038??

5. 在多列索引中, 选择性最高的索引放在最前面 vs 避免随机IO