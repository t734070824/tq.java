2018-07-23

## Tomcat ClassLoader


### Web服务器的类加载结构需要解决的问题
1. 部署在同一个Web容器上的多个Web应用程序所使用的Java类库可以实现相互隔离
    - 服务器应当保证多个应用程序的类库可以互相独立使用
2. 部署在同一个Web容器上的两个Web应用程序所使用的Java类库可以互相共享
    - 如果类库不能共享，虚拟机的方法区就会很容易出现过度膨胀的风险。
3. Web容器需要尽可能的保证自身的安全不受部署为Web应用程序的影响
    - 容器所使用的类库应该与应用程序的类库互相独立
4. 需要支持 HotSwap的功能
    - JSP

### 解决
1. 每一个目录都会有一个相应的自定义类加载器去加载放置在里面的Java类库
    - 放置在/common目录中：类库可被Tomcat和所有的Web应用程序共同使用。
    - 放置在/server目录中：类库可被Tomcat使用，对所有的Web应用程序都不可见。
    - 放置在/shared目录中：类库可被所有的Web应用程序共同使用，但对Tomcat自己不可见。
    - 放置在/WebApp/WEB-INF目录中：类库仅仅可以被此Web应用程序使用，对Tomcat和其他Web应用程序都不可见。
2. 自定义多个类加载器
    - 启动类加载器 Bootstrap ClassLoader
    - 扩展类加载器 Extension ClassLoader
    - 应用程序类加载器 Application ClassLoader
    - Common类加载器 Common ClassLoader
        - Catalina 类加载器
        - share 类加载器
            - WebApp类加载器
            - JSP类加载器
3. CommonClassLoader能加载的类都可以被Catalina ClassLoader和SharedClassLoader使用，而CatalinaClassLoader和Shared ClassLoader自己能加载的类则与对方相互隔离
4. **当Web容器检测到JSP文件被修改时，会替换掉目前的JasperLoader的实例，并通过再建立一个新的Jsp类加载器来实现JSP文件的HotSwap功能**
5. Tomcat 6.x顺理成章地把/common、/server和/shared三个目录默认合并到一起变成一个/lib目录，这个目录里的类库相当于以前/common目录中类库的作用

### 加载类或资源时
1. JVM 的 Bootstrap 类
1. Web 应用的 /WEB-INF/classes 类
1. Web 应用的 /WEB-INF/lib/*.jar 类
1. Common 类加载器的类（如上所述）
            
### QA
1. 线程上下文类加载器
    - 如果有10个Web应用程序都是用Spring来进行组织和管理的话，可以把Spring放到Common或Shared目录下让这些程序共享。
    Spring要对用户程序的类进行管理，自然要能访问到用户程序的类，而用户的程序显然是放在/WebApp/WEB-INF目录中的，
    那么被CommonClassLoader或SharedClassLoader加载的Spring如何访问并不在其加载范围内的用户程序呢？
    - **使用线程上下文类加载器来实现的，使用线程上下文加载器，可以让父类加载器请求子类加载器去完成类加载的动作**,
    看spring源码发现，spring加载类所用的Classloader是通过Thread.currentThread().getContextClassLoader()来获取的，
    而当线程创建时会默认setContextClassLoader(AppClassLoader)，即线程上下文类加载器被设置为AppClassLoader，
    spring中始终可以获取到这个AppClassLoader(在Tomcat里就是WebAppClassLoader)子类加载器来加载bean，
    以后任何一个线程都可以通过getContextClassLoader()获取到WebAppClassLoader来getbean了
