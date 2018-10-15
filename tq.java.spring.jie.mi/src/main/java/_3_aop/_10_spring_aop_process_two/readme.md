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
3. Pointcut
    - 形成表达式的标志符
        - execution
            - execution(modifiers-pattern? ret-type-pattern declaring-type-pattern? name-pattern(para-pattern) throws-pattern)
            - 固定(访问控制修饰符? 返回值类型 包? 方法名(参数) 异常类型)
            - 通配符
                - *
                    - 匹配相邻的字符, 即一个单词
                - .. 
                    - 两个位置可用
                        - declaring-type-pattern
                            - cn.spring21.*.doSomething(*): 只能指定cn.spring21这一层下的所有类型
                            - cn.spring21..*.doSomething(*): cn.spring21下的所有类型, 包括子包
                        - para-pattern
                            - void doSomething(String, *)
                            - void doSomething(.., String)
                            - void doSomething(*, String, ..)
        - within
            - 只接受类型声明, **匹配指定类型下的所有 方法级别 Pointcut**
        - args
            - 捕捉指定参数类型, 指定参数数量的方法及 Joinpoint
    - 在 SpringAOP 的真实面目
        - 声明的 Pointcut表达式, 最终都会转化成一个专门面向AspectJ 的 Pointcut实现
        - Spring AOP 有自己的Pointcut结构
        - AspectJExpressionPointcut
        - 过程
            - AspectJProxyFactory / AnnotationAwareAspectJAutoProxyFactory
            - 反射
            - AspectJExpressionPointcut
            - 委托给 AspectJ 完成 Pointcut 表达式的解析--PointcutExpression对象
            - 匹配与否 委托给 PointcutExpression对象
4. Advice
    - @Before
        - Before Advice
        - 获取方法参数
            - JoinPoint
                - **参数列表的第一个, 但是可选**
            - args标志符绑定
                - **指定的参数名和Advice定义的参数名一致**
    - @AfterReturning
    - @AfterThrowing
    - @After
    - @Around
        - **ProceedingJoinPoint 必须第一个**
            - 通常需要 proceed() 方法继续调用链的执行


                            
                            