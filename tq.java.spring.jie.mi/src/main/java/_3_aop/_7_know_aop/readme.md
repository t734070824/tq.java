2018-10-11

## 认识AOP
1. Aspect-Oriented Programming 面向切面编程

### 解决场景
1. 日志
2. 权限限制
3. 事务管理

### 织入(Weave)
1. **将AOP组件集成到OOP组件的过程**

### 静态AOP
1. AspectJ
    - 使用 **特定的编译器** 将实现后的Aspect编译并织入到系统的静态类中
2. 优点
    - 编译后直接是一个 Java类
    - JVM 可以无任何性能缺失的运行
3. 缺点
    - 灵活性不够
    - 修改Aspect的时候, 需要重新生成并编译
    
### 动态AOP
1. Spring AOP
2. 特点
    - AOL大都采用 Java 实现, 容易开发与集成
    - 织入过程在系统运行之后开始
    - 织入信息大都外部XML文件保存
3. 缺点
    - 性能问题
    
### Java的AOP
1. 动态代理
    - Dynamic Proxy
    - Interface
    - InvocationHandler
    - **反射**
    - Spring AOP 的默认方式
2. 动态字节码增强
    - Java 字节码符合一定规范
    - **为对应模块 生成响应的子类, 将横切面加到子类中**
    - 不在受限于 实现接口
    - 不足
        - final 方法无法扩展
    - Spring AOP 的备用方式
    
### 自定义类加载器
1. 在class文件加载到虚拟机执行期间, 讲横切逻辑织入到class文件中
2. 通过读取外部文件规定的织入规则和必要信息, 
3. JBoss AOP, AspectWerkz

### AOP 名词
1. Proxy(代理对象)：目标对象被AOP 织入 增强/通知后,产生的对象.
1. Joinpoint(连接点)：指那些被拦截到的点.在Spring中,这些点指方法(因为Spring只支持方法类型的连接点).
1. Pointcut(切入点)：指需要(配置)被增强的Joinpoint, 比如 正则表达式
1. Advice(通知/增强)：指拦截到Joinpoint后要做的操作.通知分为前置通知/后置通知/异常通知/最终通知/环绕通知等.
1. Aspect(切面)：切入点和通知的结合。
1. Weaving(织入)：指把增强/通知应用到目标对象来创建代理对象的过程(Spring采用动态代理织入,AspectJ采用编译期织入和类装载期织入).