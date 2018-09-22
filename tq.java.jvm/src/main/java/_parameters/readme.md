2018-03-03

## JVM 常用参数

### 堆内存设置
1. -Xmx4550m: 设置JVM最大可用内存为4550M
2. -Xms4550m：设置JVM初始内存为4550m
3. -Xmn2g：设置年轻代大小为2G
    - **默认等效效果是：-XX:NewSize==-XX:MaxNewSize==1024m**
4. -Xss128k：设置每个线程的堆栈大小
5. -XX:NewRatio=5:设置年轻代（包括Eden和两个Survivor区）与年老代的比值（除去持久代）, 默认=2, //TODO CMS失效???
6. -XX:SurvivorRatio=5：设置年轻代中Eden区与Survivor区的大小比值
7. -XX:MaxPermSize=16m:设置持久代大小为16m
8. -XX:MaxTenuringThreshold=0：设置垃圾最大年龄。
如果设置为0的话，则年轻代对象不经过Survivor区，直接进入年老代.
但是当年轻代不够用的时候,这个数值可以选择忽略
9. 


### 垃圾回收设置
1. -XX:+UseSerialGC:设置串行收集器 
2. -XX:+UseParallelGC：选择垃圾收集器为并行收集器。此配置仅对年轻代有效。即上述配置下，年轻代使用并发收集，而年老代仍旧使用串行收集。
3. -XX:ParallelGCThreads=20：配置并行收集器的线程数，即：同时多少个线程一起进行垃圾回收。此值最好配置与处理器数目相等。
4. -XX:+UseParallelOldGC：配置年老代垃圾收集方式为并行收集。JDK6.0支持对年老代并行收集
5. -XX:MaxGCPauseMillis=100:设置每次年轻代垃圾回收的最长时间，如果无法满足此时间，JVM会自动调整年轻代大小，以满足此值。
6. -XX:CMSFullGCsBeforeCompaction：由于并发收集器不对内存空间进行压缩、整理，
所以运行一段时间以后会产生“碎片”，使得运行效率降低。此值设置运行多少次GC以后对内存空间进行压缩、整理。
7. -XX:+UseConcMarkSweepGC: CMS,“对响应时间有高要求”，多CPU、对应用响应时间有较高要求的中、大型应用。
举例：Web服务器/应用服务器、电信交换、集成开发环境

### 辅助信息
1. -XX:+PrintGC: [GC 118250K->113543K(130112K), 0.0094143 secs][Full GC 121376K->10414K(130112K), 0.0650971 secs]
2. -XX:+PrintGCDetails: [GC [DefNew: 8614K->781K(9088K), 0.0123035 secs] 118250K->113543K(130112K), 0.0124633 secs]
                        [GC [DefNew: 8614K->8614K(9088K), 0.0000665 secs][Tenured: 112761K->10414K(121024K), 0.0433488 secs] 121376K->10414K(130112K), 0.0436268 secs]