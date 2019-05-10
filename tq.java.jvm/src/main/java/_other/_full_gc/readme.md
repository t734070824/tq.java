2017-11-29

### 什么时候进行Full GC 

1. 悲观策略:在发生Minor GC之前，虚拟机会先检查老年代最大可用的连续空间是否大于新生代所有对象的总空间。
如果大于则进行Minor GC，如果小于则看HandlePromotionFailure设置是否允许担保失败（不允许则直接Full GC）。
如果允许，那么会继续检查老年代最大可用的连续空间是否大于历次晋升到老年代对象的平均大小，
如果大于则尝试Minor GC（如果尝试失败也会触发Full GC），如果小于则进行Full GC。
2. old空间不足，perm空间不足，调用方法System.gc() ，ygc时的悲观策略, dump live的内存信息时(jmap –dump:live)
3. **Major GC 是清理永久代**。
4. **Full GC 是清理整个堆空间—包括年轻代和永久代**。


### 20180524 来自R大的回答
1. 针对HotSpot VM的实现，它里面的GC其实准确分类只有两大种：
    - Partial GC：并不收集整个GC堆的模式
        - Young GC：只收集young gen的GC
        - Old GC：只收集old gen的GC。只有CMS的concurrent collection是这个模式
        - Mixed GC：收集整个young gen以及部分old gen的GC。只有G1有这个模式
    - Full GC：收集整个堆，包括young gen、old gen、perm gen（如果存在的话）等所有部分的模式。
2. Major GC通常是跟full GC是等价的，收集整个GC堆。但因为HotSpot VM发展了这么多年，外界对各种名词的解读已经完全混乱了，
    当有人说“major GC”的时候一定要问清楚他想要指的是上面的full GC还是old GC。
3. 最简单的分代式GC策略，按HotSpot VM的serial GC的实现来看，触发条件是：
    - young GC：当young gen中的eden区分配满的时候触发。注意young GC中有部分存活对象会晋升到old gen，所以young GC后old gen的占用量通常会有所升高。
    - full GC：当准备要触发一次young GC时，如果发现统计数据说之前young GC的平均晋升大小比目前old gen剩余的空间大，
    **则不会触发young GC而是转为触发full GC**（因为HotSpot VM的GC里，除了CMS的concurrent collection之外，
    其它能收集old gen的GC都会同时收集整个GC堆，包括young gen，
    所以不需要事先触发一次单独的young GC）；
        - 或者，如果有perm gen的话，要在perm gen分配空间但已经没有足够空间时，也要触发一次full GC；
        - 或者System.gc()、heap dump带GC，默认也是触发full GC。
    - HotSpot VM里其它非并发GC的触发条件复杂一些，不过大致的原理与上面说的其实一样。
    当然也总有例外。Parallel Scavenge（-XX:+UseParallelGC）框架下，默认是在要触发full GC前先执行一次young GC，
    并且两次GC之间能让应用程序稍微运行一小下，以期降低full GC的暂停时间（因为young GC会尽量清理了young gen的死对象，减少了full GC的工作量）。
    控制这个行为的VM参数是-XX:+ScavengeBeforeFullGC。
    以CMS GC为例，它主要是定时去检查old gen的使用量，当使用量超过了触发比例就会启动一次CMS GC，对old gen做并发收集。
    
### FULL GC
4. CMS 不等于Full GC，我们可以看到CMS分为多个阶段，只有stop the world的阶段被计算到了Full GC的次数和时间，
    而和业务线程并发的GC的次数和时间则不被认为是Full GC
5. Full GC的次数说的是stop the world的次数，所以一次**CMS至少会让Full GC的次数+2**，
    因为CMS Initial mark和remark都会stop the world，记做2次。而CMS可能失败再引发一次Full GC
6. **CMSScavengeBeforeRemark**:执行CMS remark之前进行一次youngGC，这样能有效降低remark的时间
