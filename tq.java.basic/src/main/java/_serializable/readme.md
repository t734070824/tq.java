2019-04-22

## Java 序列化

### Java对象的序列化
1. 对象序列化保存的是对象的 **状态**, 不会关注类中的静态变量
    - 通过反序列化后仍然可以获取静态变量的值
2. 在网络中传递对象
    - RMI
    - RPC
    - 数据存储

### 相关
1. 需要实现 java.io.Serializable 接口，才可以被序列化。
2. 通过 **ObjectOutputStream 和 ObjectInputStream** 对对象进行序列化及反序列化
3. 虚拟机是否允许反序列化，不仅取决于类路径和功能代码是否一致，
    一个非常重要的一点是两个类的序列化 ID 是否一致（就是 private static final long serialVersionUID ）
3. Transient 关键字的作用是控制变量的序列化
    - 例如在 ArrayList 中就对  Object[] elementData 添加了 Transient修饰
    - 自定义

### ArrayList的序列化
1.  Object[] elementData 添加了 Transient修饰
2. 定义  writeObject 和 readObject 来实现对 elementData 的自定义序列化
    - why transient
        - 动态数组
        - 数组中会有大量 null 元素
        - 如果采用默认方式, 会有大量的 null 被同时序列化
    - why writeObject and readObject
        - 仍然有 记录数组内容的需要
       
    
### 底层
1. 序列化的类中定义了writeObject 和 readObject 方法，虚拟机会试图调用对象类里的 writeObject 和 readObject 方法，
    进行用户自定义的序列化和反序列化
2. 如果没有这样的方法，则默认调用是 ObjectOutputStream 的 defaultWriteObject 方法以及 ObjectInputStream 的 defaultReadObject 方法。
3. 通过 **反射** 调用 序列化的类中定义了writeObject 和 readObject 方法

### serialVersionUID 
1. 验证两个类 是否可以序列化和反序列化
2. 不一致 就会 InvalidClassException
3. 一致
    - 类名不一致会如何, 包一致
        - ClassCastException
    - 类名一致, 包不一致
        - ClassCastException
    - 类名 包名 serialVersionUID一致, 但是字段不一致
        - 数据丢失