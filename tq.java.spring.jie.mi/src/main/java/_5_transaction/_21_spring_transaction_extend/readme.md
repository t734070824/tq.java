2018-10-28

## Spring 事务扩展


### 扩展
1. Strategy 在开发过程中的应用
    - 事务抽象框架
    - IOC 根据 Bean 定义的内容, 实例化相应 bean 的时候, 根据情况使用反射 还是 CGLIB 来实例化相应的内容
    - Spring 的 Validation 框架
    - 常用的 commons logging 中, Log接口就是一个策略接口, JDK14Logger, Log4JLogger, SimpleLog

### ThreadLocal
1. 避免 connection-passing 
2. 存在的背景
    - 编写代码实际上在管理系统中各个对象的相关状态
    - 保证多个线程在访问对象的状态不被破坏
    - 与 Synchronization 服务与同一个目的, 实现应用程序的线程安全
    - 避免对象的共享来保证线程安全
    - 如果非要共享, 就不要用 ThreadLocal
3. 实现
    - Thread: ThreadLocal.ThreadLocalMap threadlocals
    - getThreadLocals(ThreadLocal local)
    - 比喻
        - 公交系统
            - Thread: 路线
            - threadLocals: 公交车
            - 乘客: 资源
4. 应用场景
    - 管理应用程序实现中的线程安全
        - connection
    - 实现当前程序执行流程内的数据传递
        - 避免耦合性很强的方法参数传递形式
        - 框架类来规范并屏蔽对ThreadLocal的直接操作, 避免应用程序的直接接触
    - 某些情况的性能优化
        - 空间换时间
    - pre-thread Singleton
        - 某些资源的初始化代价有些大, 执行过程多次访问
        - 避免在访问的时候每次都需要初始化资源
        - 通过 ThreadLocal 绑定到当前线程
        
### 策略模式(Strategy)
1. Spring 事务抽象
    - PlatformTransactionManager
2. IOC--Bean 初始化方式
3. 分类
    - 客户端整个生命周期只依赖于单一的策略
    
### Spring JTA
1. 
    