2019-03-27

## 思考
1. 分布式一致性快照
    - 目的?
    - TODO
2. 分布式一致性快照算法
    - Chandy-Lamport 算法
    - TODO

3. Watermark 
    - 什么东西啊
1. 配置文件放在那里
    - 直接放在 resources文件夹中, 打包直接打进去
    - 请求的资源直接指定 resources 下的文件
    - 获取也可以使用 绝对路径
    - 一旦使用其他相对路径, 都是相对 flink/bin/ 下的
2. 如何打包成 Flink 可以执行的jar
    - https://www.cnblogs.com/qifengshi/p/6036870.html
3. 程序的日志在哪里可以查看

3. Flink 的批量问题
    - 有时间窗口
    - 数量窗口
    - 想需要一种 达到这个时间 或 达到这个数量 处理一次的窗口
        - 没有找到
        - 似乎需要自己实现
        - 采用 时间窗口聚合, 然后在插入的时候在分批
            - 解决 单次插入数量量太大, 服务器报错的问题
3. 远程debug
    - jobManager 和 
        
4. keyBy
    - 解决 key 分区的问题
4. docker 安装 单机模式的 Flink 失败
    - TODO
    - compose 什么的
5. Flink 中的job 如何异常恢复, 如何 CheckPoint
    - TODO
6. 如何实现有且只有一次
    - TODO