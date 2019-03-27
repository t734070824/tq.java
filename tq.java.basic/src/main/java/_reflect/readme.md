2018-12-19

## 反射

### 特点
1. 灵活性高。因为反射属于动态编译，即只有到运行时才动态创建 &获取对象实例。
2. 执行效率低 , 因为反射的操作 主要通过JVM执行，所以时间成本会 高于 直接执行相同操作

### 应用场景
1. 动态获取 类文件结构信息（如变量、方法等） & 调用对象的方法
2. 常用的需求场景有：动态代理、工厂模式优化、Java JDBC数据库操作等 

### 获取反射中的Class对象
1. 使用 Class.forName 静态方法
    - Class clazz = Class.forName("java.lang,String")
2. 使用 .class 方法。
    - Class clz = String.class;
3. 使用类对象的 getClass() 方法。
    - String str = new String("Hello");
    - Class clz = str.getClass();


### 通过反射创建类对象
1. 通过 Class 对象的 newInstance() 方法。
    - clazz.newInstance()
    - 只能使用默认构造器
2. 通过 Constructor 对象的 newInstance() 方法
    - 通过 Constructor 对象创建类对象可以选择特定构造方法

### 源码解析
1. 反射中最最终的就是 Method 类的 invoke 方法了。

```java

public final class Method extends Executable {
        @CallerSensitive
        public Object invoke(Object obj, Object... args)
            throws IllegalAccessException, IllegalArgumentException,
               InvocationTargetException
        {
            if (!override) {
                if (!Reflection.quickCheckMemberAccess(clazz, modifiers)) {
                    Class<?> caller = Reflection.getCallerClass();
                    checkAccess(caller, clazz, obj, modifiers);
                }
            }
            MethodAccessor ma = methodAccessor;             // read volatile
            if (ma == null) {
                ma = acquireMethodAccessor();
            }
            return ma.invoke(obj, args);
        }
}
```

2. MethodAccessor 
    - 一个接口
    - sun.reflect.DelegatingMethodAccessorImpl
        - 代理类
        - 代理 NativeMethodAccessorImpl
    - sun.reflect.MethodAccessorImpl
        - 抽象类
    - sun.reflect.NativeMethodAccessorImpl
        - 具体实现类

3. acquireMethodAccessor
    - 代码先判断是否存在对应的 MethodAccessor 对象
    - 如果存在那么就复用之前的 MethodAccessor 对象
    - 否则调用 ReflectionFactory 对象的 newMethodAccessor 方法生成一个 MethodAccessor 对象。
        
```java

public final class Method extends Executable {
    private MethodAccessor acquireMethodAccessor() {
        // First check to see if one has been created yet, and take it
        // if so
        MethodAccessor tmp = null;
        if (root != null) tmp = root.getMethodAccessor();
        if (tmp != null) {
            methodAccessor = tmp;
        } else {
            // Otherwise fabricate one and propagate it up to the root
            tmp = reflectionFactory.newMethodAccessor(this);
            setMethodAccessor(tmp);
        }

        return tmp;
    }
}

```
4. reflectionFactory.newMethodAccessor(this)
    - 根据条件直接 创建 Java 版本 的 MethodAccessor 
        - Java 版本一开始加载慢，但是随着运行时间边长，速度变快
        - **ASM 实现 TODO**
    - 一个是 Native 版本
        - Native 版本一开始启动快，但是随着运行时间边长，速度变慢

5. NativeMethodAccessorImpl.invoke()
    - 所以第一次加载的时候我们会发现使用的是 NativeMethodAccessorImpl 的实现，
    - 而当反射调用次数超过 15 次之后，则使用 MethodAccessorGenerator的 generateMethod
        生成的 MethodAccessorImpl 对象去实现反射
        - 会**在内存中生成对应的字节码，并调用ClassDefiner.defineClass创建对应的class对象，**
    - 这两种各有千秋。而为了最大化性能优势，JDK 源码使用了代理的设计模式去实现最大化性能。
    
### 使用拼装出的字节码实现更快的原因
1. 每次反射都使用JNI跨越native边界会对优化有阻碍作用，
2. 相对来说使用拼装出的字节码可以直接以Java调用的形式实现反射，发挥了JIT优化的作用，
3. 避免了JNI为了维护OopMap（HotSpot用来实现准确式GC的数据结构）进行封装/解封装的性能损耗。
4. 因此在已经创建了MethodAccessor的情况下，使用Java版本的实现会比native版本更快。
5. 所以当调用次数到达一定次数（15次）后，会切换成Java实现的版本，来优化未来可能的更频繁的反射调用