2018-11-20

## 思考

### spring同名bean覆盖问题
1. 如果两个bean是在同一个配置文件中，那么spring会报错。
2. 如果两个bean是在不同的配置文件中，默认情况下，spring会覆盖先前的bean。
3. 解决
    - DefaultListableBeanFactory.allowBeanDefinitionOverriding
        - context.setAllowBeanDefinitionOverriding(false);
        - 或者在web应用中继承ContextLoaderListener, 在 customizeContext 中修改为 false