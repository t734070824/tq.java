2017-11-15
### 解释
1. 源码来源于github
2. Adapter 适配器设计模式中有 3 个重要角色：被适配者 Adaptee，适配器 Adapter 和目标对象 Target。
其中两个现存的想要组合到一起的类分别是被适配者 Adaptee 和目标对象 Target 角色，
按照类图所示，我们需要创建一个适配器 Adapter 将其组合在一起。
3. 本例中需求方要求GoblinGlider 提供 Engineer中的operateDevice方法,但是GoblinGlider没有此方法,此时就需要适配者
GnomeEngineer实现Engineer接口,并包含一个GoblinGlider引用.
### 优点
1. 适配器模式将一个类的接口适配成用户所期待的。一个适配器通常允许因为接口不兼容而不能一起工作的类能够在一起工作
	
### 缺点
1. 必须实现一个接口
2. 当适配者和被适配者差异太大,就会因为无用方法过多,造成代码混乱.

### 想法
1. 与 JDK 的动态代理模式有点相似
2. AOP
