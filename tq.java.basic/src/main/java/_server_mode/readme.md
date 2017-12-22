2017-12-22
### JVM Server模式
+ JVM被设置成-server模式时 是为了线程执行的效率,线程一直在私有堆栈中取得isRunning的值时true
+ **为什么加了``System.err.println("AAAAAAAA");``就好了呢**