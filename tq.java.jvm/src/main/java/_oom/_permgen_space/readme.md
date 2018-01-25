2018-01-25

### JDK8 再见PermGen，你好Metaspace
1. 随着JDK8的到来，JVM不再有PermGen。但类的元数据信息（metadata）还在，只不过不再是存储在连续的堆空间上，而是移动到叫做“Metaspace”的本地内存（Native memory）中
2. 类的元数据信息转移到Metaspace的原因是PermGen很难调整。PermGen中类的元数据信息在每次FullGC的时候可能会被收集，但成绩很难令人满意。而且应该为PermGen分配多大的空间很难确定
，因为PermSize的大小依赖于很多因素，比如JVM加载的class的总数，常量池的大小，方法的大小等


### 方法区溢出
1. 使用 CGLIB字节码增强
2. 大量JSP 或者是 动态产生 JSP 文件的应用
3. 基于 OSGI 的应用(同一个类 被不同的类加载 加载)

