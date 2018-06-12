2018-06-12

## Config

### typeAliases
1. 设置在 config.xml
1. typeAliases是为Java类型命名一个短的名字，它只和XML配置有关，用来减少类完全限定名的多于部分

### environments
1. 你可以配置多种环境，但你只能为每个SqlSessionFactory实例选择一个
2. 如果你想连接两个数据库，那么就需要创建两个SqlSessionFactory实例
3. environments default="development"-->来决定最终使用哪一个
4. 如果传入environment，指定的envrionment被绑定到SqlSessionFactory；如果不传入environment，default指定的environment被绑定到SqlSessionFactory。

### transactionManager
1. JDBC: 这个配置直接简单使用了JDBC的提交和回滚设置，它依赖于数据源得到的连接来管理事物范围
2. MANAGED: 这个配置几乎不做什么。它从来不提交或回滚一个连接，而它会让容器来管理事物的整个生命周期（比如Spring或J2EE应用服务器的上下文），
默认情况下它会关闭连接，然而一些容器并不希望这样，因此如果你需要从连接中停止它，将closeConnection属性设置为false


### dataSource
1. UNPOOLED
2. POOLED
3. JNDI

### mappers
1. 要告诉MyBatis到哪里去寻找这些语句

### settings -- 改变MyBatis在运行时的行为方式
1. cachedEnabled	
    - 用于配置使全局的映射器启用或禁止缓存	
    - true|false	
    - true
1. lazyLoadingEnabled	
    - 全局启用或禁用延迟加载。当禁用时，所有关联对象都会即时加载	
    - true|false	
    - true
1. aggressiveLazyLoading	
    - 当启用时，有延迟加载属性的对象在被调用时将会完全加载任任意属性，否则每种属性将会按需要加载	
    - true|false	
    - true
1. multipleResultSetsEnabled	
    - 允许或不允许多种结果集从一个单独的语句中返回（需要合适的驱动）	
    - true|false	
    - true
1. useColumnLabel	
    - 使用列标签代替列名。不同的驱动在这方面表现不同，参考驱动文档或充分测试两种方法来决定所使用的驱动	
    - true|false	
    - true
1. useGeneratedKeys	
    - 允许JDBC支持生成的键，需要合适的驱动。如果设置为true则这个驱动强制生成的键被使用，尽管一些驱动拒绝兼容但仍然有效。	
    - true|false	
    - true
1. autoMappingBehavior	
    - 指定MyBatis如何自动映射列到字段/属性PARTIAL只会自动映射简单、没有嵌套的结果。FULL会自动映射任意复杂的结果。	
    - NONE|PARTIAL|FULL	
    - PARTIAL
1. defaultExecutorType	
    - 配置默认的执行器。SIMPLE执行器没有什么特别之处，REUSE执行器重用预处理语句，BATCH执行器重用语句和批量更新。	
    - SIMPLE|REUSE|BATCH	
    - SIMPLE
1. defaultStatementTimeout	
    - 设置超时时间，它决定驱动等待一个数据库响应的时间。	
    - 任何正整数	
    - Not Set(null)