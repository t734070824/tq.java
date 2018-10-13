2018-10-13

## Spring AOP -- @Aspect

### @Aspect
1. Spring AOP 实现 @Aspect语义
2. 织入方式
    - 编程方式织入
        - AspectJProxyFactory
            - 类似 BeanFactory
    - 自动代理织入
        - AnnotationAwareAspectJAutoProxyCreator
            - AutoProxyCreator
            - AspectJAwareAdvisorAutoProxyCreator
            - AbstractAdvisorAutoProxyCreator