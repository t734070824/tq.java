2018-03-28

## AbstractApplicationContext.refresh()

### obtainFreshBeanFactory 初始化 BeanFactory
1. ConfigurableListableBeanFactory AbstractApplicationContext.obtainFreshBeanFactory()
2. AbstractRefreshableApplicationContext.refreshBeanFactory()
3. AbstractXmlApplicationContext.loadBeanDefinitions(DefaultListableBeanFactory beanFactory)
4. AbstractXmlApplicationContext.loadBeanDefinitions(XmlBeanDefinitionReader reader)
6. XmlBeanDefinitionReader.loadBeanDefinitions(EncodedResource encodedResource)
7. XmlBeanDefinitionReader.doLoadBeanDefinitions(InputSource inputSource, Resource resource)
8. DefaultBeanDefinitionDocumentReader.doRegisterBeanDefinitions(Element root)
9. DefaultBeanDefinitionDocumentReader.parseBeanDefinitions(Element root, BeanDefinitionParserDelegate delegate)
10. DefaultBeanDefinitionDocumentReader.processBeanDefinition(Element ele, BeanDefinitionParserDelegate delegate)
11. BeanDefinitionReaderUtils.registerBeanDefinition(BeanDefinitionHolder definitionHolder, BeanDefinitionRegistry registry)
12. DefaultListableBeanFactory.registerBeanDefinition(String beanName, BeanDefinition beanDefinition)
13. **Xml --> BeanDefinition --> BeanFactroy**

### getBean()
1. 循环依赖
    - Spring容器将每一个正在创建的bean标识符放在一个“当前创建bean池”中，bean标识符在创建过程中将一直保持在这个池中，
    因此如果在创建bean过程中发现自己已经在"当前创建bean池"中时，将抛出BeanCurrentlyInCreationException异常标识循环依赖
    - 构造器循环依赖:表示通过构造器注入构成的循环依赖，此依赖是无法解决的
    - setter循环依赖:表示通过setter注入方法构成的循环依赖。对于setter注入造成的依赖是通过Spring容器提前暴露刚完成构造器注入但未完成其他步骤（比如setter注入）的bean来完成的。
    而且只能解决单例作用域的bean循环依赖。通过提前暴露一个单例工厂方法，从而使得其他bean能引用到该bean
    - prototype范围的依赖处理:对应prototype作用域bean，Spring容器无法完成依赖注入，因为Spring容器不进行缓存“prototype”作用域的bean，因此无法提前暴露一个创建中的bean
    - 对于“prototype”不做循环依赖的检查。

2. 已经初始化过了就从容器中直接返回，否则就先初始化再返回
3. createBean(beanName, mbd, args);
    - AbstractAutowireCapableBeanFactory.createBean(String beanName, RootBeanDefinition mbd, Object[] args)
    - doCreateBean(beanName, mbdToUse, args);
        - createBeanInstance(String beanName, RootBeanDefinition mbd, Object[] args);
            - instantiateBean(final String beanName, final RootBeanDefinition mbd)
            - InstantiationStrategy.instantiate(RootBeanDefinition bd, String beanName, BeanFactory owner)
                - bd.getMethodOverrides().isEmpty():如果不存在方法覆写，**即实例中是否有和IOC容器同名的方法**. 那就使用 java 反射进行实例化，否则使用 CGLIB, lookup-method 和 replaced-method
                    - java反射
                    - GGLIB
        - populateBean(beanName, mbd, instanceWrapper): bean 实例化完成（通过工厂方法或构造方法），但是还没开始属性设值
        - initializeBean(beanName, exposedObject, mbd): 属性注入完成后，这一步其实就是处理各种回调了
            - invokeAwareMethods(beanName, bean): 如果 bean 实现了 BeanNameAware、BeanClassLoaderAware 或 BeanFactoryAware 接口，回调
            - BeanPostProcessor 的 postProcessBeforeInitialization 回调
            - invokeInitMethods(beanName, wrappedBean, mbd): 处理 bean 中定义的 init-method，或者如果 bean 实现了 InitializingBean 接口，调用 afterPropertiesSet() 方法
            - BeanPostProcessor 的 postProcessAfterInitialization 回调
            - **BeanPostProcessor 的两个回调都发生在这边，只不过中间处理了 init-method**
