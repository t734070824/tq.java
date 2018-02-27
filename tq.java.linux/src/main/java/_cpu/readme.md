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
