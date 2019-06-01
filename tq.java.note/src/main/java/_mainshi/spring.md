#### Spring
1. Spring主要模块
    - JDBC, ORM, Servlet, Transactions
    - Aop, Aspectj, 
    - Core Container
        - Beans, Core, Context
    - Test
1. spring bean初始化过程
2. spring 事物回滚机制(传播性) 
3. **用到的设计模式以及 运用**
    - 代理模式—在AOP和remoting中被用的比较多。
    - 单例模式—在spring配置文件中定义的bean默认为单例模式。
    - 模板方法—用来解决代码重复的问题。比如. RestTemplate, JmsTemplate, JpaTemplate。
    - 前端控制器—Spring提供了DispatcherServlet来对请求进行分发。
    - 视图帮助(View Helper )—Spring提供了一系列的JSP标签，高效宏来辅助将分散的代码整合在视图里。
    - 依赖注入—贯穿于BeanFactory / ApplicationContext接口的核心理念。
    - 工厂模式—BeanFactory用来创建对象的实例。
4. IOC AOP的实现
5. Spring, Spring MVC原理,流程
    - springmvc
        - request -- DispatcherServlet
        - 查询 HandlerMapping, 分发指定的 Controller
        - Controller 返回 ModelAndView
        - DispatcherServlet 查询一个或多个 ViewResolve 视图解析器, 找到 ModelAndView 指定的视图
        - 返回
6. 设计模式在Spring中的应用
7. Servlet中filter和spring中的Interceptor的区别 
8. aop的底层实现，动态代理是如何动态，假如有100个对象，如何动态的为这100个对象代理
    - 动态代理
        - TODO 假如有100个对象，如何动态的为这100个对象代理
    - Cglib
        - ASM
9. spring的bean配置的几种方式
    - xml
    - anno
    - java
10. spring的注入bean的方式
    - Byname
    - byType
    - 构造函数
11. @Transaction注解一般写在什么位置?如何控制其回滚?
    - 类或者方法
    - 代理 rollback
12. 说说Spring的IOC容器初始化流程？
    - refresh()
    - DefaultResourceLoader
    - BeanDefinition
    - BeanDefinitionReader
    - BeanDefinitionParseDelegate 解析 Bean 
    - BeanDefinitionRegistry.registerBeanDefinition 注册bean
    - ConcurrentHashMap  保存 BeanDefinition
13. 循环依赖
    - 怎么检测
        - Bean在创建过程中给该Bean 打标, 如果递归调用发现正在创建中, --> 循环依赖
    - 基于 setter 属性的循环依赖为什么不会出问题
        - TODO
14. bean 的生命周期
    - InitializingBean和DisposableBean回调接口
    - 针对特殊行为的其他Aware接口
    - Bean配置文件中的Custom init()方法和destroy()方法
    - @PostConstruct和@PreDestroy注解方式
1. 声明式事务的实现方式
    - 拦截器
1. 为什么需要代理模式？
1. 讲讲静态代理模式的优点及其瓶颈？
1. 对Java 接口代理模式的实现原理的理解？
1. 如何使用 Java 反射实现动态代理？
1. Java 接口代理模式的指定增强？
1. 谈谈对Cglib 类增强动态代理的实现？
1. 怎么理解面向切面编程的切面？
1. 讲解OOP与AOP的简单对比？
1. 讲解JDK 动态代理和 CGLIB 代理原理以及区别？
1. 讲解Spring 框架中基于 Schema 的 AOP 实现原理？
1. 讲解Spring 框架中如何基于 AOP 实现的事务管理？
1. 谈谈对控制反转的设计思想的理解？
1. 怎么理解 Spring IOC 容器？
1. Spring IOC 怎么管理 Bean 之间的依赖关系，怎么避免循环依赖？
1. 对Spring IOC 容器的依赖注入的理解？
1. 说说对Spring IOC 的单例模式和高级特性？
1. BeanFactory 和 FactoryBean 有什么区别？
1. BeanFactory 和 ApplicationContext 又有什么不同？
1. Spring 在 Bean 创建过程中是如何解决循环依赖的？
1. 谈谈Spring Bean 创建过程中的设计模式？