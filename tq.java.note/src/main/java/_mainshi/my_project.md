2019-07-30

## 我的项目
1. 为什么使用 Mongodb --> es
    - 为什么不选择 mysql
        - 不要求事务
        - 日志型数据
        - 有部分 用户属性数据 需要更新
    - 历史原因, 第一次选择了Mongodb
        - 对查询有一定要求, 数据不要求事务, 需要数据更新
        - 对服务可用性和一致性有高要求
    - 最后es
        - 已经有其他系统负责数据管理
        - **对查询性能有要求, 对写性能要求不高**
        - 数据量太大, 做聚合操作会占用大量内存
        - 同步es, 先以 天 或者游戏 为index, 创建索引
        - 对于修改的数据, 不去特意修改 es, 创建一个新的索引