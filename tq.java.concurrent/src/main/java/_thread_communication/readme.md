2017-12-22
### 线程通信
+ wait() 方法以及 notify, notifyall 方法都需要先获取对象锁
+ notify 只会唤醒监听在当前锁的线程
+ 当执行到notify的时候,并不是线程直接被唤醒,**因为此时还没有释放锁**,只有在notify后面的代码执行完后,等待锁被释放,wait 线程才会去争夺锁