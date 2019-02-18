2019-02-17

## 表

### 索引组织表
1. 每个表都有主键
2. 如果没有显示的创建主键
    - 判断表中是否有非空的唯一主键, 按照定义索引的顺序
    - 不符合上述条件, Innodb 自动创建一个 6 字节大小的指针
    
### Innodb 逻辑存储结构
1. 所有数据都被逻辑的存储一个空间中(tablespace)
    - tablespace --> segment --> extent(区) --> page
2. tablespace
    - 默认情况下 Innodb 有一个共享表空间 ibdata1
3. segment
    - 表空间是由各个段组成
    - 常见 数据段, 索引段, 回滚段
    - Innodb 存储引擎表是由 索引组织的(index organized) --> 数据即索引, 索引即数据
4. extent
    - 由连续的页组成的空间
    - **1MB**
    - 保证区中页的连续性, 一次从磁盘申请4-5个区
    - 页的大小为 16KB, 一个区有 64个连续的页
5. page
    - 常见
        - 数据页(b-tree page)
        - undo 页(undo Log Page)
        - 系统页
        - 事务数据页
6. 行
       
### 
    
    