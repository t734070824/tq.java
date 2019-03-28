2018-04-17

## LinkedBlockingQueue
https://blog.csdn.net/u010887744/article/details/73010691

### LinkedBlockingQueue插入数据小结
1. 线程A入队操作前会获取putLock锁，插入数据完毕后释放；
2. 队列未满将新建Node节点，添加到队列末尾；
3. 队列已满则阻塞线程（notFull.await()）或返回false；若线程B取出数据，则会调用notFull.signal()唤醒notFull上的等待线程（线程A继续插数据）。
4. 若入队前队列为空，则唤醒notEmpty上等待的获取数据的线程。

### LinkedBlockingQueue取数据小结
1. 线程A取数据前会获取takeLock锁，取完数据后释放锁
2. 队列有数据则（通常）返回队首数据
3. 若队列为空，则阻塞线程（notEmpty.await()）或返回null等；当线程B插入数据后，会调用notEmpty.signal()唤醒notEmpty上的等待线程（线程A继续取数据）
4. 若取数据前队列已满，则通过notFull.signal()唤醒notFull上等待插入数据的线程。

### 线程唤醒signal()
1. 值得注意的是，对notEmpty和notFull的唤醒操作均使用的是signal()而不是signalAll()
2. signalAll() 虽然能唤醒Condition上所有等待的线程，但却并不见得会节省资源，相反，唤醒操作会带来上下文切换，且会有锁的竞争
3. 此外，由于此处获取的锁均是同一个（putLock或takeLock），同一时刻被锁的线程只有一个，也就无从谈起唤醒多个线程了。

### LinkedBlockingQueue与ArrayBlockingQueue简要比较
1. ArrayBlockingQueue**底层基于数组，创建时必须指定队列大小，“有界”**；
    LinkedBlockingQueue“无界”，节点动态创建，节点出队后可被GC，故伸缩性较好；
2. ArrayBlockingQueue**入队和出队使用同一个lock**（但数据读写操作已非常简洁），
    读取和写入操作无法并行，LinkedBlockingQueue使用双锁可并行读写，其吞吐量更高
3. ArrayBlockingQueue**在插入或删除元素时直接放入数组指定位置（putIndex、takeIndex）**，不会产生或销毁任何额外的对象实例；
    而LinkedBlockingQueue则会生成一个额外的Node对象，在高效并发处理大量数据时，对GC的影响存在一定的区别

### 总结
1. LinkedBlockingQueue通过对 插入、取出数据 使用不同的锁，实现多线程对竞争资源的互斥访问
2. (之前队列为空)添加数据后调用signalNotEmpty()方法唤醒等待取数据的线程；
    (之前队列已满)取数据后调用signalNotFull()唤醒等待插入数据的线程。这种唤醒模式可节省线程等待时间
3. 个别操作需要调用方法fullyLock()同时获取putLock、takeLock两把锁
    （如方法：clear()、contains(Object o)、remove(Object o)、toArray()、toArray(T[] a)、toString()），
    **注意fullyLock和fullyUnlock获取锁和解锁的顺序刚好相反，避免死锁**。
4. LinkedBlockingQueue的头部具有一个不变性: 头部的元素总是为null，head.item==null

### 线程池 选择LinkedBlockingQueue的理由
1. **选用LinkedBlockingQueue作为阻塞队列的原因就在于其无界性**       
2. 而使用无界队列由于其良好的存储容量的伸缩性，可以很好的去缓冲任务繁忙情况下场景，即使任务非常多，也可以进行动态扩容，当任务被处理完成之后，
                     队列中的节点也会被随之被GC回收，非常灵活
    