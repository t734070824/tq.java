2018-01-31

### 乐观锁
1. 每次不加锁而是假设没有冲突而去完成某项操作，如果因为冲突失败就重试，直到成功为止。
某个线程可以不让出cpu,而是一直while循环，如果失败就重试，直到成功为止。
所以，当数据争用不严重时，乐观锁效果更好。比如CAS就是一种乐观锁思想的应用

### CAS
1. CAS有3个操作数，内存值V，旧的预期值A，要修改的新值B。当且仅当预期值A和内存值V相同时，将内存值V修改为B，否则什么都不做
2. ``public final native boolean compareAndSwapInt(Object var1, long var2, int var4, int var5);`` 对象、对象的地址、预期值、修改值
3. CPU提供了两种方法来实现多处理器的原子操作：总线加锁或者缓存加锁。

### 总线加锁
1. 总线加锁就是就是使用处理器提供的一个LOCK#信号，当一个处理器在总线上输出此信号时，
其他处理器的请求将被阻塞住,那么该处理器可以独占使用共享内存。
但是这种处理方式显得有点儿霸道，不厚道，他把CPU和内存之间的通信锁住了，
在锁定期间，其他处理器都不能读取其内存地址的数据，其开销有点儿大。所以就有了缓存加锁
2. 其实针对于上面那种情况我们只需要保证在同一时刻对某个内存地址的操作是原子性的即可。
缓存加锁就是缓存在内存区域的数据如果在加锁期间，当它执行锁操作写回内存时，
处理器不在输出LOCK#信号，而是修改内部的内存地址，利用缓存一致性协议来保证原子性。
缓存一致性机制可以保证同一个内存区域的数据仅能被一个处理器修改，
也就是说当CPU1修改缓存行中的i时使用缓存锁定，那么CPU2就不能同时缓存了i的缓存行

### 缺点
1. 如果CAS一直不成功,则会导致循环时间太长,会给CPU带来非常大的开销--> 限制CAS自旋次数
2. 只能保证一个共享变量原子操作 --> 多个变量整成一个变量
3. ABA问题--> 每个变量都加上一个版本号，每次改变时加1，即A —> B —> A，变成1A —> 2B —> 3A (AtomicStampedReference)

### unsafe.cpp-->compxchg

![](1.png)
