2018-10-25

## Spring 事务管理

### 编程试事务管理
1. 直接使用 PlatformTransactionManager 进行编程式事务管理
    - 优点:
        - 可以完全控制整个事务的处理过程
    - 缺点:
        - 过于底层, 处理异常就很麻烦了
2. 使用 TransactionTemplate 进行编程式事务管理     
    - 优点:
        - 比直接使用  PlatformTransactionManager 更加便捷
    - 缺点:
        - 无法向 更上层抛出未检查异常
        
### 声明式事务管理
1. 实现拦截器
    - 需要知道方法是否需要事务支持
    - 哪些异常需要回滚事务
2. 多个方面协同工作
    - 具体的数据资源类型
    - 数据访问技术
    - 事务管理实现
    - 业务方法拦截功能
    - **数据访问技术与事务管理实现 是 一一对应的**
2. 4中配置方式
    - ProxyFactory(ProxyFactoryBean) + TransactionInterceptor
        - 基本实现功能
    - TransactionProxyFactoryBean
        - 减少配置, 提高效率
    - BeanNameAutoProxyCreator
        - 解决使用声明式事务的业务增加, 配置项也跟着增加的问题
        - 自动代理
        - 依然需要在新增的时候手动配置
    - 声明事务配置方式
        - 只要放宽 pointcut 的限制, 就可以代理多个
1. **五种方式**: https://blog.csdn.net/hjm4702192/article/details/17277669                  
2. DataSource, TransactionManager, 代理机制
    - 每个Bean都有一个代理
    - 所有Bean共享一个代理基类
    - 使用拦截器
    - 使用tx标签配置的拦截器
    - 全注解
3. 无论哪种配置方式，一般变化的只是代理机制这部分。

### 注解元数据驱动的声明式事务
1. @Transactional
1. tx:annotation-driven transaction-manager="transactionManager"



### 扩展
1. Strategy 在开发过程中的应用
    - 事务抽象框架
    - IOC 根据 Bean 定义的内容, 实例化相应 bean 的时候, 根据情况使用反射 还是 CGLIB 来实例化相应的内容
    - Spring 的 Validation 框架
    - 常用的 commons logging 中, Log接口就是一个策略接口, JDK14Logger, Log4JLogger, SimpleLog

              