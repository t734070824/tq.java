2018-01-12

### java 动态代理
1. 每一个动态代理类都必须要实现InvocationHandler这个接口
2. Proxy这个类的作用就是用来动态创建一个代理对象的类，它提供了许多的方法，但是我们用的最多的就是 newProxyInstance 这个方法
3. 在运行是动态生成的一个对象，并且命名方式都是这样的形式，以$开头，proxy为中，最后一个数字表示对象的标号
4. 缺点: **只能对实现了接口的类进行，没有实现接口的类不能使用JDK动态代理。**, 也只是代理了接口中的方法
5. 实现了 equals,toString,hashcode

### 源码
1. InvocationHandler 接口
1. Proxy.newProxyInstance()
    - getProxyClass0()
        - Factory.get()
            - ProxyClassFactory.apply()
                - 生成代理类，并写入文件
                    - byte[] proxyClassFile = ProxyGenerator.generateProxyClass(
                                  proxyName, interfaces, accessFlags);
                - 加载代理类，并返回 Class 对象
                    - defineClass0(proxyClassFile,..)