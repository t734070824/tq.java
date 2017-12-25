2017-12-25
### ReentrantLock的内存可见性
- ReentrantLock的同步其实是委托给AbstractQueuedSynchronizer的。加锁和解锁是通过改变AbstractQueuedSynchronizer的state属性，
这个属性是volatile的，volatile也能保证可见性。和你说的“比如A类的成员变量b，线程1在synchronized块中修改A.b，
在synchronized块离开前肯定会把修改的值从工作内存flush到主内存中，然后当线程2在synchronized块中读取A.b，
工作内存会被设置无效，所以从主内存中读取它的实际值，这样完成了A.b的可见性
- Happens-before:**如果A操作happens-before B操作，那么A操作的执行结果（比如对变量的写入）必定在执行B操作时可见**
- 当ThreadA释放锁M时，它所写过的变量（比如，x和y，存在它工作内存中的）都会同步到主存中，
而当ThreadB在申请同一个锁M时，ThreadB的工作内存会被设置为无效，然后ThreadB会重新从主存中
加载它要访问的变量到它的工作内存中（这时x=1，y=1，是ThreadA中修改过的最新的值）。
通过这样的方式来实现ThreadA到ThreadB的线程间的通信
### Java内存模型对synchronized语义做了以下的保证
![](https://github.com/t734070824/tq.java/blob/master/tq.java.concurrent/src/main/java/_reentrantlock/1.png?raw=true)
  