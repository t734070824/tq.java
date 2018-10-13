2018-10-11

## 思考
1. 仔细想一想 AOP 对位日志的解决方案真的很方便吗??
    - TODO
2. Ordered 的作用 
   - 多个需要在同一个Joinpointc处执行的Advice逻辑存在优先顺序依赖
   - 如果没有实现这个接口, 那么就会按照声明的顺序, 谁先声明谁在前面
       - 如果全局的异常捕获Advisor在其他异常捕获Advisor之后, 就会导致 其他异常捕获Advisor 抛出的异常无法捕获
       - 思考一下 
3. MockTask proxyObject = (MockTask) weaver.getProxy() 是否可以??
    - 动态代理出来的真正对象是什么
    
4. 思考 TargetSource 具体的作用
    - 灵活

5. TransactionProxyFactoryBean
    - TODO