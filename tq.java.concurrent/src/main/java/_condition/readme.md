2017-12-25
### Condition And AQS
1. AQS:AQS自己维护的队列是当前等待资源的队列，AQS会在资源被释放后，依次唤醒队列中从前到后的所有节点，使他们对应的线程恢复执行。直到队列为空
2. Condition:Condition自己也维护了一个队列，该队列的作用是维护一个等待signal信号的队列，两个队列的作用是不同，事实上，每个线程也仅仅会同时存在以上两个队列中的一个

### 线程获取锁的过程:
1. 线程1调用reentrantLock.lock时，线程被加入到AQS的等待队列中。
2. 线程1调用await方法被调用时，该线程从AQS中移除，对应操作是锁的释放。
3. 接着马上被加入到Condition的等待队列中，因为着该线程需要signal信号。
4. 线程2，因为线程1释放锁的关系，被唤醒，并判断可以获取锁，于是线程2获取锁，并被加入到AQS的等待队列中。
5. 线程2调用signal方法，这个时候Condition的等待队列中只有线程1一个节点，于是它被取出来，并被加入到AQS的等待队列中。 注意，**这个时候，线程1 并没有被唤醒(线程2还没有释放锁)**。
6. signal方法执行完毕，线程2调用reentrantLock.unLock()方法，释放锁。这个时候因为AQS中只有线程1，于是，AQS释放锁后按从头到尾的顺序唤醒线程时，线程1被唤醒，于是线程1回复执行。
7. 直到释放锁, 整个过程执行完毕。