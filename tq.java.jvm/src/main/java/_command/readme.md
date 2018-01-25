2017-11-29
### 命令
1. 查看线程的堆栈信息 : jstack -l pid
2. dump堆内的对象 : jmap -dump:live,format=b,file=xxx pid
3. -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=xxx  -- 设置JVM参数，当JVM OOM时输出堆的dump
4. 获得当前系统占用CPU最高的10个进程，线程 ps Hh -eo pid,tid,pcpu,pmem | sort -nk3 |tail > temp.txt