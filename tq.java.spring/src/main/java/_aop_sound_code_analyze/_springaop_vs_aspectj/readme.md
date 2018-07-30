2018-07-30

## Spring Aop


### ProxyFactoryBean创建AOP
1. 切面类必须实现MethodInterceptor, 以及 invoke方法
2. 这种方式属性半自动的，需要配置工厂bean
3. **每次只能指定一个目标类**

### 使用AOP命名空间
1. 直接覆盖很多目标类，不需要在一个个对目标类进行编写通知和工厂了
2. 通过编写 aspectj 表达式
3. 只需要关注切面类，也就是通知和切入点的结合即可

### 使用AspectJ框架(xml方式)实现aop
1. 关注的点只有切面类(不需要实现通知类型接口)，切入点范围，还有通知类型
2. 声明通知方式
    - 前置通知
        - <aop:before method="" pointcut-ref="" pointcut=""/>
        - method: 切面类中具体的方法名称
        - pointcut-ref: 切入点的引用, 共享
        - pointcut: 给当前编写切入点表达式(自己使用)
        - //TODO pointcut-ref vs pointcut(冲突 覆盖)
    - 后置通知
        - <aop:after-returning method="" pointcut-ref="" returning="ref"/>
        - 方法执行之后才执行, 可以获取返回值, 
        - returning: 用于设置通知第二个参数的名称
    - 环绕通知
        - <aop:around method="" pointcut-ref="" />
        - 方法要求
            - 返回类型Object
            - 必须抛出异常 throws Throwable
            - 必须接受一个参数, 类型 ProceedingJoinPoint
            - 方法体中手动执行目标方法 Object obj = joinPoint.process();
    - 抛出异常
        - 目标方法出现异常执行, 没有则忽略        
    - 最终
        - 无论是否有异常, 都会执行
        
### 使用AspectJ框架(注解)实现aop
1. 切面类
    - @component
    - @Aspect
    - 将目标类配置给spring
    - 申明目标类切入点范围
        - 方法必须private，没有返回值，没有参数
        - 之后使用将其当成方法调用。例如：@After("myPointcut()")　
    - 编写相应的通知　
    - 必须在xml中扫描注解和启用aop
    