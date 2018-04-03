2018-03-27

### BeanFactory 和 ApplicationContext 关系
1. ApplicationContext 间接继承 BeanFactory
2. BeanFactory 默认采用延时初始化策略, ApplicationContext 默认全部初始化并绑定完成

### id 和 name
1. id属性唯一, 
2. name, 类似别名, 可以通过 逗号, 空格 分割多个name

### ref lcoal parent bean
1. local : 只能指定与当前配置的对象在同一个配置文件的对象定义的名称
2. parent : 只能指定位于当前容器的父容器中定义的对象引用
3. bean: 基本通吃

### list 
1. list:对应注入对象类型为 java.util.list 及其 子类, 或者数组类型的依赖对象 

### lazy-init
1. 主要是 针对 ApplicationContext