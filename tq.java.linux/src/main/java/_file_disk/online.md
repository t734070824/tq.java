2019-01-14

## 线上问题解决

### 磁盘占用告警
1. df -hl
    - 查看各个分区的磁盘占用情况
2. 发现 /dev/vda1 还有 7% 剩余
3. du -sh /usr/* | sort -rn 获取文件大小排序
    - 没有发现大文件 > 10G
3. 搜索 /dev/vda1 看不到
    - 发现是因为 有进程一直占用文件
4. 用lsof检查后才发现原因是,有文件被删除,而进程还活着,因而造成还占用空间的现象
    - lsof |grep delete
5. 根据lsof列出的进程号,kill这些进程后,空间就释放出来了
6. 造成这种情况的原因
    - TODO
    - lsof命令 TODO


### df 命令长时间无响应
1. TODO 
    - https://arstercz.com/centos7-%E7%B3%BB%E7%BB%9F-df-hang-%E9%97%AE%E9%A2%98%E5%A4%84%E7%90%86%E8%AF%B4%E6%98%8E/