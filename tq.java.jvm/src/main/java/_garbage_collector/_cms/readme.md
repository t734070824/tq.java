2017-11-29
### CMS采用的垃圾回收算法?
1. CMS采用了标记--清除算法，由于标记清除算法会生成内存碎片，所以JVM提供了参数来使CMS可以在几次清除后作一次整理
-XX:CMSFullGCsBeforeCompaction：由于并发收集器不对内存空间进行压缩、整理，所以运行一段时间以后会产生“碎片”，
使得运行效率降低。此值设置运行多少次GC以后对内存空间进行压缩、整理。
-XX:+UseCMSCompactAtFullCollection：打开对年老代的压缩。可能会影响性能，但是可以消除碎片
摘自http://blog.csdn.net/iter_zc/article/details/41746265

### CMS为什么使用 标记--清除算法?
![](https://segmentfault.com/img/bVtUHO)

- XX:+UseConcMarkSweepGC
- 新生代：复制算法，默认搭配ParNewGC，并行
- 年老代：标记-清除，并发（如果发生Concurrent Mode Fail，则使用SerialOld做后备收集器）
- 初始标记：STW，单线程，由于是从GCRoot寻找直达的对象，速度快
- 并发标记：与应用线程一起运行，是CMS最主要的工作阶段，通过直达对象，扫描全部的对象，进行标记
- 重新标记：STW，修正并发标记时由于应用程序还在并发运行产生的对象的修改，多线程，速度快，需要全局停顿
- 并发清除：与应用程序一起运行，为何采用清除算法？**CMS主要关注低延迟，因而采用并发方式，
清理垃圾时，应用程序还在运行，如何采用压缩算法，则涉及到要移动应用程序的存活对象，
此时不停顿，是很难处理的，一般需要停顿下，移动存活对象，再让应用程序继续运行，
但这样停顿时间变长，延迟变大，所以CMS采用清除算法**。

### 什么是剩余空间不足
1. 剩余空间不够不是说整体的空间不够分配某个对象，**而是说连续的空间不够分配给某个对象**。
所以一旦内存碎片大多就可能发生剩余空间不够的问题，所以CMS这种收集器，需要在标记-清除几次之后进行压缩，
进行优化。CMSFullGCsBeforeCompaction可以设置进行几次清除之后进行压缩


### FULL GC

1. Full GC == Major GC指的是对老年代/永久代的stop the world的GC
2. Full GC的次数 = 老年代GC时 stop the world的次数
3. Full GC的时间 = 老年代GC时 stop the world的总时间
4. CMS 不等于Full GC，我们可以看到CMS分为多个阶段，只有stop the world的阶段被计算到了Full GC的次数和时间，而和业务线程并发的GC的次数和时间则不被认为是Full GC
5. Full GC的次数说的是stop the world的次数，所以一次**CMS至少会让Full GC的次数+2**，因为CMS Initial mark和remark都会stop the world，记做2次。而CMS可能失败再引发一次Full GC
6. **CMSScavengeBeforeRemark**

### real != user+sys

1. ``[Times: user=1.85 sys=0.10, real=1.36 secs]``
原因:user和sys代表处于用户和系统态的时间,不包含block的时间.但是由于多cpus这个东东是累加的.所以一般来说user和sys相加都大于real
real是从启动到终止的真实时间(现实中消耗),包含block.

### 无法处理浮动垃圾
1. 并发清楚期间用户线程还在运行, 自然还会有新的垃圾不断产生, CMS无法处理它们.
2. 由于并发运行, 需要预留足够的空间给用户线程使用, 因此CMS不会在老年代几乎填满的时候运行
3. 如果 CMS在运行期间无法满足程序需求,就会出现一次 "Concurrent Mode Failure" ,启动后备方案,
使用Serial Old收集器 重新进行老年代回收



