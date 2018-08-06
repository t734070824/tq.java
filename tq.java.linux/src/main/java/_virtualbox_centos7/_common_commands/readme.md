2017-11-29

## 常用命令
1. 如何在Linux中统计一个进程的线程数
    - $ ps hH p <pid> | wc -l
2. linux如何查看端口被哪个进程占用
    - netstat -tunlp|grep 7917