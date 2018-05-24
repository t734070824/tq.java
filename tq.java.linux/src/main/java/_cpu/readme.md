2017-12-27

### Linux查看物理CPU个数、核数、逻辑CPU个数
1. 总核数 = 物理CPU个数 X 每颗物理CPU的核数 
2. 总逻辑CPU数 = 物理CPU个数 X 每颗物理CPU的核数 X 超线程数
3. 查看物理CPU个数
    ``cat /proc/cpuinfo| grep "physical id"| sort| uniq| wc -l``
4. 查看每个物理CPU中core的个数(即核数)
``cat /proc/cpuinfo| grep "cpu cores"| uniq``
5. 查看逻辑CPU的个数
``cat /proc/cpuinfo| grep "processor"| wc -l``

### cpu load
1. cpu load高不代表使用率高
2. 如果线程过多, 线程之间的切换所需要的资源也会使 load 高
3. ps -mp pid -o THREAD,tid,time
4. CPU利用率:显示的是程序在运行期间实时占用的CPU百分比
5. CPU负载:显示的是一段时间内正在使用和等待使用CPU的平均任务数
6. http://heipark.iteye.com/blog/1340384

### 20180322 CPU load
1. 线上项目 2cpu , cpu load在3+以上
2. 监控显示 1000+线程数
3. jstack pid--> total:1002, Mongodb:574, RabbitMQ:53, Consumer:53, MessageService:53
4. 运行本地, visualvm.exe监控, 在重启任务时, 原来的Mongodb连接没有关闭, 并创建新的线程池
5. 在重启启动任务时,关闭原有连接

### 查看CPU信息
http://www.dayanmei.com/centos_cpu/
1. 查看物理CPU的个数
    - cat /proc/cpuinfo |grep "physical id"|sort |uniq|wc -l
2. 查看逻辑CPU的个数
    - cat /proc/cpuinfo |grep "processor"|wc -l
3. 查看CPU是几核
    - cat /proc/cpuinfo |grep "cores"|uniq
