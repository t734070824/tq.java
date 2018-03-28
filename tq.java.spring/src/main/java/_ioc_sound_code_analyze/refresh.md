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