2018-02-07

### CPU 占用高
1. top --> 获取进程
2. top -Hp PID --> 获取线程 threadid
3. threadid --> 16进制
4. jstack pid
5. 查找对应  threadid