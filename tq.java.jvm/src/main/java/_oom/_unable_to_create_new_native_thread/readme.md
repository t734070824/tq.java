2017-11-28

### OOM : Unable to create new native thread
1. 因为window系统没有对进程的最大可以创建的线程数进行限制,所以可以创建的线程数为
	```
	(MaxProcessMemory - JVMMemory - ReservedOsMemory) / (ThreadStackSize) = Number of threads 
    MaxProcessMemory 	指的是一个进程的最大内存
    JVMMemory         	JVM内存
    ReservedOsMemory  	保留的操作系统内存
    ThreadStackSize     线程栈的大小 
	```
	
2. 你给JVM内存越多，那么你能创建的线程越少，越容易发生java.lang.OutOfMemoryError: unable to create new native thread
3. Thread.start()和 线程池创建线程 报的错误是不一样的
4. linux对每个用户都限制了最大进程数（包括线程）(ulimit -a)(ulimit -u)