2017-11-15
### 理解
1. ThreadLocal内部是用数组实现的,数组中的成员是Entry,此Entry继承了WeakReference
2. ThreadLocal有一个静态内部类 ThreadLocalMap
3. 当ThreadLocal调用get方法的时候,首先获取当前线程对象,然后获取当前线程的ThreadLocalMap成员变量,通过ThreadLocal本身作为key
获取当前ThreadLocal对象threadLocalHashCode,取模,获取数组下标,若果当前Entry的key==ThreadLocal就返回,如果不等,从当前下标往数组末尾查找,
到数组末尾后,从0开始,还没有的话就创建并返回
		
### 优点(什么时候使用)
1. 当对象不是线程安全的,并且不想加锁的时候
2. ThreadLocal会为每一个线程提供一个独立的变量副本，从而隔离了多个线程对数据的访问冲突
3. 时间换空间
	
### 缺点
1. 内存泄漏:ThreadLocalMap使用ThreadLocal的弱引用作为key，如果一个ThreadLocal没有外部强引用来引用它，
那么系统 GC 的时候，这个ThreadLocal势必会被回收，这样一来，ThreadLocalMap中就会出现key为null的Entry，
就没有办法访问这些key为null的Entry的value，如果当前线程再迟迟不结束的话，这些key为null的Entry的value就会一直存在一条强引用链：
Thread Ref -> Thread -> ThreaLocalMap -> Entry -> value永远无法回收，造成内存泄漏.
其实，ThreadLocalMap的设计中已经考虑到这种情况，也加上了一些防护措施：
在ThreadLocal的get(),set(),remove()的时候都会清除线程ThreadLocalMap里所有key为null的value
但是这些被动的预防措施并不能保证不会内存泄漏：
使用static的ThreadLocal，延长了ThreadLocal的生命周期，可能导致的内存泄漏
分配使用了ThreadLocal又不再调用get(),set(),remove()方法，那么就会导致内存泄漏。
(http://blog.xiaohansong.com/2016/08/06/ThreadLocal-memory-leak/)
		