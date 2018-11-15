2018-11-15

## 高级主题

### 插件模块
1. JDK动态代理
    - **在每次 Configuration.new... 方法获取各个各个组件时候, 返回的是代理对象**
    - 判断是否需要拦截
        - Interceptor.intercept
        - Invocation.proceed
        - method.invoke()
    - method.invoke()
1. 责任链模式
    - tomcat
    - 过程
        - 完成的逻辑分为多个只包含部分逻辑的 功能单一的Handler
        - 有序的
        - 组成一个链条
        - 每个handler包含对下一个handler对象的引用
1. 拦截对象
    - Executor
    - ParameterHandler
    - ResultSetHandler
    - StatementHandler
2. Interceptor
    - 自定义的拦截器需要实现这个接口
    - 还需要标识哪些方法会被拦截
        - @Intercepts
        - @Signature
        
### 应用场景分析
1. 分页插件
    - DefaultResultSetHandler获取先获取所有数据,然后在内存中分页, 在数据量很大的时候会有性能问题

