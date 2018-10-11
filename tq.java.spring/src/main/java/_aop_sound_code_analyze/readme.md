2018-04-03

## AOP
http://www.importnew.com/24430.html
http://www.importnew.com/24459.html
1. 对类生成代理使用CGLIB
1. 对接口生成代理使用JDK原生的Proxy
1. 可以通过配置文件指定对接口使用CGLIB生成代理


### Spring-Aop相关概念
![](1.jpg)

- Target(目标对象)：需要被代理增强的对象
- Proxy(代理对象)：目标对象被AOP 织入 增强/通知后,产生的对象.
- Joinpoint(连接点)：指那些被拦截到的点.在Spring中,这些点指方法(因为Spring只支持方法类型的连接点).
- Pointcut(切入点)：指需要(配置)被增强的Joinpoint.
- Advice(通知/增强)：指拦截到Joinpoint后要做的操作.通知分为前置通知/后置通知/异常通知/最终通知/环绕通知等.
- Aspect(切面)：切入点和通知的结合。
- Weaving(织入)：指把增强/通知应用到目标对象来创建代理对象的过程(Spring采用动态代理织入,AspectJ采用编译期织入和类装载期织入).
- Introduction(引入增强)：一种特殊通知,在不修改类代码的前提下,可以在运行期为类动态地添加一些Method/Field(不常用).

### Spring处理AOP的源头
1. 加载Bean定义的时候应该有过特殊的处理-->解析了<aop:pointcut>标签中的内容并将之转换为**RootBeanDefintion**存储在Spring容器中。
    - DefaultBeanDefinitionDocumentReader.parseBeanDefinitions(Element root, BeanDefinitionParserDelegate delegate)
        - delegate.isDefaultNamespace(ele)--> 标签是否是默认的Namespace
            - BeanDefinition delegate.parseCustomElement(Element ele, BeanDefinition containingBd)
                - AopNamespaceHandler
                    - config–>ConfigBeanDefinitionParser
                    - aspectj-autoproxy–>AspectJAutoProxyBeanDefinitionParser
                    - scoped-proxy–>ScopedProxyBeanDefinitionDecorator
                    - spring-configured–>SpringConfiguredBeanDefinitionParser
                - BeanDefinition ConfigBeanDefinitionParser.parse(Element element, ParserContext parserContext)                 
                    - parsePointcut(elt, parserContext);
                    - parseAdvisor(elt, parserContext);
                    - parseAspect(elt, parserContext);
2. AspectJAwareAdvisorAutoProxyCreator及为Bean生成代理时机分析(getBean的时候应该有过特殊的处理)
    - AspectJAwareAdvisorAutoProxyCreator是BeanPostProcessor接口的实现类
    - postProcessBeforeInitialization方法与postProcessAfterInitialization方法实现在父类AbstractAutoProxyCreator中
    - postProcessBeforeInitialization方法是一个空实现
    - 逻辑代码在postProcessAfterInitialization方法中
    - **在每个Bean初始化之后，如果需要，调用AspectJAwareAdvisorAutoProxyCreator中的postProcessBeforeInitialization为Bean生成代理**
3. 初始化
    - AbstractAutowireCapableBeanFactory.initializeBean(final String beanName, final Object bean, RootBeanDefinition mbd)
    - applyBeanPostProcessorsAfterInitialization(Object existingBean, String beanName)
    - **AbstractAutoProxyCreator.postProcessAfterInitialization(Object bean, String beanName)**
    - wrapIfNecessary(Object bean, String beanName, Object cacheKey)                                          
                
4. <aop:config>这个节点中proxy-target-class=”false”或者proxy-target-class不配置，即不使用CGLIB生成代理                
5. createAopProxy().getProxy(classLoader);
    - 创建AopProxy接口实现类
    - 通过AopProxy接口的实现类的getProxy方法获取<bean>对应的代理
    
### 可以通过配置文件指定对接口使用CGLIB生成代理
1. ProxyConfig的isOptimize方法为true，这表示让Spring自己去优化而不是用户指定
1. ProxyConfig的isProxyTargetClass方法为true，这表示配置了proxy-target-class=”true”
1. ProxyConfig满足hasNoUserSuppliedProxyInterfaces方法执行结果为true，这表示<bean>对象没有实现任何接口或者实现的接口是SpringProxy接口
            
### 代理方法调用原理
1. //TODO

### 图
1. https://blog.csdn.net/u013430196/article/details/48290749

![](https://github.com/t734070824/tq.java/blob/master/tq.java.spring/src/main/java/_aop_sound_code_analyze/2.png?raw=true)
