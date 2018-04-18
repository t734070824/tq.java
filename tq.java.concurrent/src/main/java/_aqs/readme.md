2017-11-21

## AQS(AbstractQueuedSynchronizer)
http://www.cnblogs.com/xrq730/p/4979021.html

### AQS.Node
- Node SHARED = new Node()	表示Node处于共享模式
- Node EXCLUSIVE = null	    表示Node处于独占模式
- int CANCELLED = 1	        因为超时或者中断，Node被设置为取消状态，被取消的Node不应该去竞争锁，只能保持取消状态不变，不能转换为其他状态，处于这种状态的Node会被踢出队列，被GC回收
- int SIGNAL = -1	        **表示这个Node的继任Node被阻塞了，到时需要通知它**
- int CONDITION = -2	    表示这个Node在条件队列中，因为等待某个条件而被阻塞
- int PROPAGATE = -3	    使用在共享模式头Node有可能处于这种状态， 表示锁的下一次获取可以无条件传播
- int waitStatus	        0，新Node会处于这种状态
- Node prev	                队列中某个Node的前驱Node
- Node next	                队列中某个Node的后继Node
- Thread thread	            这个Node持有的线程，表示等待锁的线程
- Node nextWaiter	        表示下一个等待condition的Node

### AQS.变量和方法
- Thread exclusiveOwnerThread	                                这个是AQS父类AbstractOwnableSynchronizer的属性，表示独占模式同步器的当前拥有者
- Node	                                                        上面已经介绍过了，FIFO队列的基本单位
- Node head	                                                    FIFO队列中的头Node
- Node tail	                                                    FIFO队列中的尾Node
- int state	                                                    同步状态，0表示未锁
- int getState()	                                            获取同步状态
- setState(int newState)	                                    设置同步状态
- boolean compareAndSetState(int expect, int update) 	        利用CAS进行State的设置 
- long spinForTimeoutThreshold = 1000L	                        线程自旋等待的时间 
- Node enq(final Node node) 	                                插入一个Node到FIFO队列中 
- Node addWaiter(Node mode)	                                    为当前线程和指定模式创建并扩充一个等待队列
- void setHead(Node node)	                                    设置队列的头Node
- void unparkSuccessor(Node node)	                            如果存在的话，唤起Node持有的线程
- void doReleaseShared()	                                    共享模式下做释放锁的动作
- void cancelAcquire(Node node)	                                取消正在进行的Node获取锁的尝试
- boolean shouldParkAfterFailedAcquire(Node pred, Node node)	在尝试获取锁失败后是否应该禁用当前线程并等待
- void selfInterrupt()	                                        中断当前线程本身
- boolean parkAndCheckInterrupt()	                            禁用当前线程进入等待状态并中断线程本身
- boolean acquireQueued(final Node node, int arg)	            队列中的线程获取锁
- tryAcquire(int arg)	                                        尝试获得锁（由AQS的子类实现它）
- tryRelease(int arg)	                                        尝试释放锁（由AQS的子类实现它）
- isHeldExclusively()	                                        是否独自持有锁
- acquire(int arg)	                                            获取锁
- release(int arg)	                                            释放锁
- compareAndSetHead(Node update)	                            利用CAS设置头Node
- compareAndSetTail(Node expect, Node update)	                利用CAS设置尾Node
- compareAndSetWaitStatus(Node node, int expect, int update)	利用CAS设置某个Node中的等待状态

### ReentrantLock.lock()
1. 设置AbstractQueuedSynchronizer的state为1
2. 设置AbstractOwnableSynchronizer的thread为当前线程
3. 这两步做完之后就表示线程1独占了锁。然后线程2也要尝试获取同一个锁，在线程1没有释放锁的情况下必然是行不通的，所以线程2就要阻塞。那么，线程2如何被阻塞

### 线程2.lock()
1. acquire(1): 尝试获取锁
2. addWaiter(Node mode): 获取失败, 添加进等待队列, 独占模式
3. 头结点为空, 头结点的后面一个节点才是 等待节点
4. LockSupport.lock(Thread): 暂停线程
5. release(int arg): 锁持有者释放锁, 当释放次数=加锁次数之后, 真正释放锁
6. unparkSuccessor(Node node): 就从尾到头遍历，找出离head最近的一个node，对这个node进行unPark操作
7. acquireQueued(final Node node, int arg): 
    - 被阻塞的线程2是被阻塞在 parkAndCheckInterrupt()，注意这里并没有return语句，也就是说，阻塞完成线程2依然会进行for循环
    - 阻塞完成了，线程2所在的Node的前驱Node是p，线程2尝试tryAcquire成功，然后线程2就成为了head节点了，
    - 把p的next设置为null，这样原头Node里面的所有对象都不指向任何块内存空间，h属于栈内存的内容，方法结束被自动回收，这样随着方法的调用完毕，
    - 原头Node也没有任何的引用指向它了，这样它就被GC自动回收了。此时，遇到一个return语句，acquireQueued方法结束，后面的Node也是一样的原理。


### setHead
1. setHead方法里面的前驱Node是Null，也没有线程，那么为什么不用一个在等待的线程作为Head Node呢?
    - 因为一个线程随时有可能因为中断而取消，而取消的话，Node自然就要被GC了，那GC前必然要把头Node的后继Node变为一个新的头而且要应对多种情况，这样就很麻烦。
	- 用一个没有thread的Node作为头，相当于起了一个引导作用，因为head没有线程，自然也不会被取消。
	
### 怎么样的代码差别导致公平锁和非公平锁的产生的呢
1. FairSync: **直接将自己放入等待队列, 如果等待队列为空, 获取锁**
2. NonfairSync: **直接获取锁, 获取失败, 放入等待队列**