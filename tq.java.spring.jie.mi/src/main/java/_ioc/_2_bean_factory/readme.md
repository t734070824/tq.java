2018-01-09
### Spring的IoC容器和IoC Service Provider之间的关系
![](https://github.com/t734070824/tq.java/blob/master/tq.java.spring.jie.mi/src/main/java/_ioc/_2_bean_factory/1.png?raw=true)

### BeanFactory和ApplicationContext继承关系

![](https://github.com/t734070824/tq.java/blob/master/tq.java.spring.jie.mi/src/main/java/_ioc/_2_bean_factory/2.png?raw=true)

### Bean的实例化过程
![](https://github.com/t734070824/tq.java/blob/master/tq.java.spring.jie.mi/src/main/java/_ioc/_2_bean_factory/3.png?raw=true)

### BeanFactory的基本类体系结构（接口为主）
![](https://github.com/t734070824/tq.java/blob/master/tq.java.spring.jie.mi/src/main/java/_ioc/_2_bean_factory/4.png?raw=true)

1. BeanFactory作为一个主接口不继承任何接口，暂且称为一级接口。
2. 有3个子接口继承了它，进行功能上的增强。这3个子接口称为二级接口。
3. ConfigurableBeanFactory可以被称为三级接口，对二级接口HierarchicalBeanFactory进行了再次增强，它还继承了另一个外来的接口SingletonBeanRegistry
4. ConfigurableListableBeanFactory是一个更强大的接口，继承了上述的所有接口，无所不包，称为四级接口。
　　（这4级接口是BeanFactory的基本接口体系。继续，下面是继承关系的2个抽象类和2个实现类：）
5. AbstractBeanFactory作为一个抽象类，实现了三级接口ConfigurableBeanFactory大部分功能。
6. AbstractAutowireCapableBeanFactory同样是抽象类，继承自AbstractBeanFactory，并额外实现了二级接口AutowireCapableBeanFactory
7. DefaultListableBeanFactory继承自AbstractAutowireCapableBeanFactory，实现了最强大的四级接口ConfigurableListableBeanFactory，并实现了一个外来接口BeanDefinitionRegistry，它并非抽象类。
8. 最后是最强大的XmlBeanFactory，继承自DefaultListableBeanFactory，重写了一些功能，使自己更强大。

### Bean初始化过程
```javascript
BeanFactory.getBean() --> AbstractBeanFactory.doGetBean() --> cache, parentBeanFactory
--> dependsOn --> AbstractAutowireCapableBeanFactory.createBean() --> AbstractAutowireCapableBeanFactory.doCreateBean()
--> AbstractAutowireCapableBeanFactory.createBeanInstance() --> BeanUtils.instantiateClass() OR CGLIB --> BeanWrapper
--> AbstractAutowireCapableBeanFactory.populateBean() --> AbstractAutowireCapableBeanFactory.initializeBean()
```
