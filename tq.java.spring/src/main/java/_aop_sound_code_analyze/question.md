2018-07-03

## 问题

### AOP的入口在哪里
1. AbstractAutowireCapableBeanFactory.initializeBean()
1. 在每个Bean初始化之后，如果需要，调用AspectJAwareAdvisorAutoProxyCreator中的postProcessBeforeInitialization为Bean生成代理。

### AOP如何知道调用哪里的切面代码
1. 

### 针对不同的注解会有怎样的方式

### @Transactional 是如何处理的
1. 对于每个切面(方法或者是类)都会有自己的 **interception chain**
2. 

### @Transactional 注解的方法中如果没有sql相关的会如何回滚...

### @Transactional 注解无用的原因