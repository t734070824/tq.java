2018-11-12

## 核心处理层

### 初始化过程
1. XMLConfigBuilder.parse()
    - properties
    - setting
        - 全局配置信息
    - typeAliases
        - 别名
    - plugins
        - 插件
        - Interceptor
        - chain
    - objectFactory
    - objectWrapperFactory
    - reflectorFactory
    - environment
        - 多个数据库环境
    - databaseIdProvider
        - 实现类似 Hiberbate 方言的功能
        - databaseid, 区分不同的sqls
    - typeHandler
    - mappers
        - 配置文件
        - 注解
        
### SqlNode/SqlSource
1. OGNL(ognl) 为基础
1. SqlSource
    - DynamicSqlSource
    - 组合模式
    - DynamicContext
        - 记录动态Sql 语句解析结果的容器
2. SqlNode
    - apply()
        - 根据用户的参数解析该sqlNode所记录的动态sql节点
    - TextSqlNode
        - 表示包含 ${} 占位符的动态sql节点
    - IfSqlNode
        - <when>
        - ExpressionEvaluator.evaluateBoolean（）方法检测其 test 表达式是否为 true
    - TrimSqlNode / WhereSqlNode / SetSqlNode
    - ForeachSqlNode
        - in
        - <foreach>
    - ChooseSqlNode
        - <choose>
3. SqlSourceBuilder
    - 解析 #{} 占位符定义的属性
    - #{} 替换为 ?
    
### sqlSource
1. DynamicSqlSource
    - 解析动态sql语句
2. RawSqlSource
    - StaticSqlSource
    - 组合模式
    
### ResultSetHandler
1. 映射select语句查询的结果集
    - javasisst
    - cglib
2. KeyGenerator
    - 获取插入记录返回**自动生成**的主键
    - 自增
    - 自增主键 是 设置在 insert()的参数里面的
3. SelectKeyGenerator


### StatementHandler
1. 核心接口, Executor接口实现的基础
    - 创建 statement 对象
    - 绑定实参
    - 增删改查
    - 批量
    - 结果映射
2. RoutingStatementHandler
    - 策略模式的特点
3. BaseStatementHandler
    - 参数绑定
4. ParameterHandler
    - 参数设置
5. SimpleStatementHandler
    - java.sql.Statement
    - sql语句不存在占位符
    - 配置的 KeyGenerator 获取数据库生成的主键 
6. PreparedStatementHandler
    - java.sql.PreparedStatement
    - 默认方式
4. CallableStatementHandler
    - java.sql.CallableStatement
    - 存储过程

### Executor
1. 数据库操作的基本方法
2. 模板方法模式, 装饰器模式
    - 装饰器: CachingExecutor
    - 模板: BaseExecutor
3. BaseExecutor
    - 缓存管理, 事务管理
    - SimpleExecutor
        - 基本实现
        - 不提供批量操作
    - ReuseExecutor
        - Statement 缓存
        - Map
    - BatchExecutor
        - 批量处理, 合适时机, 打包发送
        - 不支持 select
    - CachingExecutor
        - 装饰器模式
        - 过程
            - 是否开启二级缓存
            - 根据 select 配置, 是否需要清空二级缓存
            - 查询二级缓存
                - 没有结果查询一级缓存
                    - 没有结果, 查询数据库
                    - 设置以及缓存
                - 设置二级缓存
        
### BatchExecutor
1. openSession(ExecutorType.BATCH, autoCommit:false)
2. insert/update/delete
3. addStatementList
4. BatchExecutor.doFlushStatements
4. stmt.executeBatch()
5. populateKeys--> KeyGenerator
6. commit


### 接口层
1. SqlSession
    - DefaultSqlSession
    - SqlSessionManager
        - 默认实现
        - 策略模式
            - Executor
2. SqlSessionFactory
    - DefaultSqlSessionFactory
    - 
    