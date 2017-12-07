2017-12-07
[摘自](http://blog.csdn.net/shendl/article/details/1427475)
#java路径
###相对于当前用户目录的相对路径
`System.getProperty("user.dir")`,对于一般项目，这是项目的根路径。对于JavaEE服务器，这可能是服务器的某个路径

###相对路径最佳实践
- 因此，我们在使用相对路径时，应当使用相对于当前classpath的相对路径
- ClassLoader类的getResource(Stringname),getResourceAsStream(String name)等方法，使用相对于当前项目的classpath的相对路径来查找资源。
- 读取属性文件常用到的ResourceBundle类的getBundle(String path)也是如此

###相对路径本质上还是绝对路径
- 因此，归根结底，Java本质上只能使用绝对路径来寻找资源。所有的相对路径寻找资源的方法，都不过是一些便利方法。不过是API在底层帮助我们构建了绝对路径，从而找到资源的！

###Web应用程序中资源的寻址
- 在Web应用程序中，我们一般通过ServletContext.getRealPath("/")方法得到Web应用程序的根目录的绝对路径