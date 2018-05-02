2018-04-30

## 载入器

### 为什么要单独实现一个载入器
1. servlet容器不应该完全信任他正在运行的 servlet 类
2. servlet 应该只允许 载入 WEB-INF/classes 目录及其子目录下的类, 和 部署到WEB-INF/lib 目录下的类
3. **提供自动重载的功能**

### Tomcat 使用自定义类加载器的原因
1. 在载入类中指定某些原则
2. 缓存已载入的类
3. 实现类的预加载, 方便使用

### webAppClassLoader
1. 载入类, 遵循以下原则
    - 载入类的时候, 会先检查本地缓存
    - 入本地缓存中没有, 则检查上一层缓存, 即调用 java.lang.ClassLoader 类的findLoadedClass()方法
    - 如果两个缓存都没有, 则使用系统的类加载器进行加载, **防止 web 应用程序中的类覆盖 J2EE的类**        
        - 同时也会防止 覆盖 非 J2EE的类(自己编写的类)
    - 如果启用了 Securitymanager, 则检查是否允许载入该类, 如果该类是禁止载入的类, 抛出 ClassNotFoundException
    - 如果打开 delegate, 或者待载入的类是包触发器中的包名, 则调用父加载器来加载, 如果父加载器为 null, 则使用系统加载器
    - 从当前仓库载入相关类
    - 如果当前仓库没有需要的类, 且标志位 delegate 关闭, 使用父加载器, 如果父加载器 =null, 使用 系统 的类加载器进行加载
    - 仍然没有找到类,   ClassNotFoundException
    
### reload
1. reload重新加载也只限于 被 webAppClassLoader 加载的 servlet
2. 被 系统 classLoader加载的类 并不会计入 监控中
3. 只有被 webAppClassLoader 记载的 servlet 才会通过 findResourceInternal(String name, String path), 放入监控列表中
4. 重新加载的 servlet 在被重新加载之前 会 destroy, 再次被加载的时候 init 
    
### 总结
1. 理解 servlet 放的位置的意义
2. setPath, setDocPath 的意义
3. 一个 servlet记载到容器的原理    