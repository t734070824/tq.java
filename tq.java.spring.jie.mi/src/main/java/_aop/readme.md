2018-01-14
### Spring AOP
1. 在无法采用动态代理机制(需要实现接口)进行AOP功能扩展的时候, 会使用 CGLIB 库的动态字节码增强支持来实现AOP的功能扩展
2. 动态代理3个方法 ``toString(), equal(), hashCode()``
3. Joinpoint, Pointcut, Advice, Weave(ProxyFactory)
4. NameMatchMethodPointcut, JdkRegexpMethodPointcut,AnnotationMatchingPointcut


