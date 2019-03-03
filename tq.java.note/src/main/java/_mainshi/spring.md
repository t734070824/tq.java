#### Spring
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
10. spring的注入bean的方式
    - Byname
    - byType
    - 构造函数
11. @Transaction注解一般写在什么位置?如何控制其回滚?
    - TODO
12. 说说Spring的IOC容器初始化流程？
    - TODO
13. 循环依赖
    - 怎么检测
        - TODO
    - 基于 setter 属性的循环依赖为什么不会出问题
        - TODO
14. bean 的生命周期
    - InitializingBean和DisposableBean回调接口
    - 针对特殊行为的其他Aware接口
    - Bean配置文件中的Custom init()方法和destroy()方法
    - @PostConstruct和@PreDestroy注解方式