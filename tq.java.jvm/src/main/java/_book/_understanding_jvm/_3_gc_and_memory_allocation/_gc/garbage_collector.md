2018-09-21

## 垃圾收集器


### HotSpot
![](1.jpg)

### Serial / Serial old 收集器
![](2.jpg)
1. 单线程
    - 只使用一个CPU或一条收集线程去完成垃圾收集工作
    - **进行GC的时候, 必须暂停其他所有的工作线程** -- STW
2. 新生代(Serial)
    - 复制
    - STW
4. 其他特点(Serial)
    - **可以配合CMS使用**    

### ParNew / ParNew old 收集器
![](3.jpg)
1. Serial的多线程版本
2. 新生代(ParNew)
    - 复制
    - STW
3. 老年代(ParNew old)
    - 标记-整理
    - STW
4. 其他特点(ParNew)
    - **可以配合CMS使用**
    - 在JDK1.5 中, CMS收集老年代的时候, 新生代只能选择ParNew, Serial其中一个, 
    - -XX:+UseConcMarkSweepGC 选线的默认新生代收集器
    - -XX:+UseParNewGC 强制指定
5. **注:并行, 用户线程依然停止**
    
### Parallel Scavenge 收集器
1. 特点
    - 新生代收集器
    - 复制
    - 并行的多线程
    - VS ParNew
        - 达到一个可以控制的吞吐量
        - 高效率利用CPUs时间, 尽快完成程序的运算任务
        - 适合: 后台运算而不需要太多交互的任务
        
### Serial old
1. 单线程
1. 老年代(Serial old)
    - 标记-整理
    - STW
    - **作为CMS收集器的后备方案**
        - **在并发收集器发生 Concurrent Mode Failure 时使用**

### Parallel old 收集器
1. 多线程
2. 标记-整理
3. **配合 Parallel Scavenge 收集器 实现高吞吐量**


### CMS(Concurrent Mark Sweep) 收集器
![](4.jpg)
1. 目标
    - 获取最短回收停顿时间
2. 实现
    - **标记-清除**
3. 步骤
    - 初始标记 (CMS initial mark)
        - **STW**
        - 单线程，由于是从GCRoot寻找直达的对象，速度快
    - 并发标记 (CMS concurrent mark)
        - 与应用线程一起运行，是CMS最主要的工作阶段，通过直达对象，扫描全部的对象，进行标记
    - 重新标记 (CMS remark)
        - **STW**
        - 修正并发标记期间因用户程序继续运作而导致标记产生变动的那一部分对象的标记记录
    - 并发清除 (CMS concurrent sweep)
4. 特点
    - 并发收集, 低停顿
    - **新生代：复制算法，默认搭配ParNewGC，并行**
5. 缺点
    - CMS收集器对CPU资源非常敏感
        - 并发设计
        - 回收线程数 = (CPUs + 3) / 4, CPU越多, 占用的资源越多
        - 对用户程序影响大
    - 无法处理浮动垃圾, Concurrent Mode Failure 导致另外一处 Full GC 的发生
        - 并发清理阶段用户线程产生的新垃圾(浮动垃圾)需要下一次GC清理
    - 标记-清除
        - 收集接收后, 大量的空间碎片
        - 压缩
        - -XX:CMSFullGCsBeforeCompaction：由于并发收集器不对内存空间进行压缩、整理，所以运行一段时间以后会产生“碎片”，
            使得运行效率降低。此值设置运行多少次GC以后对内存空间进行压缩、整理。
        - -XX:+UseCMSCompactAtFullCollection：打开对年老代的压缩。可能会影响性能，但是可以消除碎片

### G1收集器
1. 目标
    - 替代 CMS
2. 实现
    - 标记-整理 
    - 将整个 java 堆划分为多个大小相等的独立区域(Region) 
    - 每个Region 被标记为 E, S, O, H, 每个Region 在运行时都充当一个角色
        - H(Humongous), 这表示这些Region存储的是巨型对象（humongous object，H-obj），
        - 当新建对象大小超过Region大小一半时，直接在新的一个或多个连续Region中分配，并标记为H。
3. 特点
    - 并发与并行
    - 分代收集  
    - 空间整合
    - 可预测的停顿
        - 有计划的避免在整个Java堆中进行全区域的垃圾回收
        - 跟踪各个Region 里面的垃圾堆积的价值大小, 后台维护一个优先列表, 根据允许的收集时间,优先回收垃圾最多的区域
        - 精确的控制停顿--> 避免全区域的垃圾回收
        -  将整个 JAVA 堆划分为多个大小固定的独立区域,跟踪每个区域的垃圾堆积程度.
    - 区域划分 以及 优先级的区域回收, 保证了 G1 收集器在优先的时间内可以获取更高的收集效率
4. 思考
    - java堆分为多个Region后, 垃圾收集器是否真的能以Region为单位进行
        - Region不是孤立的, 一个对象分配在某Region中, 并非只可以被本Region的其他对象引用, 可以和这个java堆中对象产生引用关系
        - 在做可达性判定对象是否存活的时候, 是不是要扫描整个堆才可以保证准确性
    - Remembered Set
        - Region之间的对象和**其他收集器中的新生代与老年代之间的对象引用**, 虚拟机都是使用Remembered Set 来避免全堆扫描
        - 每一个Region都有一个与之对应的 Remembered Set 
        - **用于记录进入该区块的对象引用（如区块 A 中的对象引用了区块 B，区块 B 的 Rset 需要记录这个信息），**
            - 回收的时候需要知道哪些其他Region的对象引用着自己Region的对象
            - **因为采用的copying算法, 需要移动对象, 更新引用为对象的新地址**
            - **所以 Rs 被放在被应用区块中, 这样移动对象的时候 引用对象无感**
        - 它用于实现收集过程的并行化以及使得区块能进行独立收集
        - 过程
            - 发现程序对Reference类型的数据进行写操作是, 产生一个 Write Barrier 暂时中断写操作
            - 检查Reference引用的对象是否处不同的Region 之中
            - 如果是, 通过 CardTable 把相关引用信息 记录到被引用对象所属的Region的Remembered Set
5. 其他
    - Region
        - 大小通过 -XX:G1HeapRegionSize 指定
        - 1M, 2M、4M、8M、16M和32M，总之是2的幂次方

### GC模式
1. young gc
    - 一般对象都在 eden region 分配, 当所有的 eden region 被耗尽, 就触发 young gc
    - 活跃对象被拷贝到 survivor region 或者 晋升到 old region
    - 参数
        - -XX:MaxGCPauseMillis: G1收集过程的目标时间
        - -XX:G1NewSizePercent: 新生代最小值 5%
        - -XX:G1MaxNewSizePercent: 新生代最大值 60%
2. mixed gc
    - 晋升老年代, 避免内存耗尽, mixed gc
    - 回收整个 young region 和 部分 old region
    - XX:InitiatingHeapOccupancyPercent: 当老年代大小占整个堆大小百分比达到该阈值时，会触发一次mixed gc.
    - 步骤
        - 初始标记
          - STW
        - 并发标记
        - 最终标记
            - STW
        - 筛选回收
3. full gc
    - 对象内存分配太快, mixed gc 来不及, 导致old region 被填满 触发 Full gc
    - 单线程 serial old gc, 长时间的暂停时间
    - 尽可能避免 full gc


![](5.jpg)

### 垃圾收集器参数
![](6.jpg)
![](7.jpg)