2018-02-07

### CPU 占用高 100%
1. top --> 获取进程
2. top -Hp PID --> 获取线程 threadid
3. threadid --> 16进制 printf "%x\n" tid 
4. jstack pid --> jstack -l pid >1.txt
5. 查找对应  threadid  

### 分析如下问题
1. 系统无缘无故的cpu过高
1. 系统挂起，无响应
1. 系统运行越来越慢
1. 性能瓶颈（如无法充分利用cpu等）
1. 线程死锁，死循环等
1. 由于线程数量太多导致的内存溢出（如无法创建线程等）