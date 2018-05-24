2018-05-24

## jstat
https://blog.csdn.net/zlzlei/article/details/46471627

### 命令格式
1. jstat命令命令格式：
    - jstat [Options] vmid [interval] [count]
2. 参数说明：
    - Options，选项，我们一般使用 -gcutil 查看gc情况
    - vmid，VM的进程号，即当前运行的java进程号
    - interval，间隔时间，单位为秒或者毫秒
    - count，打印次数，如果缺省则打印无数次
3. 常用参数
    - class (类加载器)
    - **gc** (GC堆状态) 
    - gccapacity (各区大小) 
    - gccause (最近一次GC统计和原因) 
    - gcnew (新区统计)
    - gcnewcapacity (新区大小)
    - gcold (老区统计)
    - gcoldcapacity (老区大小)
    - gcpermcapacity (永久区大小)
    - **gcutil** (GC统计汇总)
    - printcompilation (HotSpot编译统计)
    
    
### 示例说明
1. $ jstat -gc 14921 1000
    ```text
     S0C    S1C    S0U    S1U      EC       EU        OC         OU       MC     MU    CCSC   CCSU   YGC     YGCT    FGC    FGCT     GCT   
    14848.0 10240.0  0.0    0.0   54784.0  42900.9   188416.0   133267.0  28544.0 27869.1 3200.0 2985.9 191557 1018.188 2621   349.068 1367.256
    12800.0 13824.0 3728.0  0.0   66048.0  15824.8   188416.0   133267.0  28544.0 27869.1 3200.0 2985.9 191558 1018.195 2621   349.068 1367.263
    12800.0 13824.0 3728.0  0.0   66048.0  32442.5   188416.0   133267.0  28544.0 27869.1 3200.0 2985.9 191558 1018.195 2621   349.068 1367.263
    12800.0 13824.0 3728.0  0.0   66048.0  46191.4   188416.0   133267.0  28544.0 27869.1 3200.0 2985.9 191558 1018.195 2621   349.068 1367.263
    12800.0 13824.0 3728.0  0.0   66048.0  59991.3   188416.0   133267.0  28544.0 27869.1 3200.0 2985.9 191558 1018.195 2621   349.068 1367.263
    12800.0 13824.0  0.0   1567.0 66048.0   9259.8   188416.0   133419.0  28544.0 27869.1 3200.0 2985.9 191559 1018.201 2621   349.068 1367.269
    12800.0 13824.0  0.0   1567.0 66048.0  64092.5   188416.0   133419.0  28544.0 27869.1 3200.0 2985.9 191559 1018.201 2621   349.068 1367.269
    
    ```
2. 解释
    - S0C: Current survivor space 0 capacity (kB).
    - S1C: Current survivor space 1 capacity (kB).
    - S0U: Survivor space 0 utilization (kB).
    - S1U: Survivor space 1 utilization (kB).
    - EC: Current eden space capacity (kB).
    - EU: Eden space utilization (kB).
    - OC: Current old space capacity (kB).
    - OU: Old space utilization (kB).
    - MC: Metaspace capacity (kB).
    - MU: Metacspace utilization (kB).
    - CCSC: Compressed class space capacity (kB).
    - CCSU: Compressed class space used (kB).
    - YGC: Number of young generation garbage collection events.
    - YGCT: Young generation garbage collection time(s).
    - FGC: Number of full GC events.
    - FGCT: Full garbage collection time(s).
    - GCT: Total garbage collection time(s).
3. jstat -gcutil 28601 1000
    ```text
      S0     S1     E      O      M     CCS    YGC     YGCT    FGC    FGCT     GCT   
      5.48   0.00  54.50  86.74  97.64  93.31 193018 1027.945  2648  353.905 1381.850
      5.48   0.00  75.92  86.74  97.64  93.31 193018 1027.945  2648  353.905 1381.850
      5.48   0.00  80.89  86.74  97.64  93.31 193018 1027.945  2648  353.905 1381.850
      5.48   0.00  89.40  86.74  97.64  93.31 193018 1027.945  2648  353.905 1381.850
      0.00  98.20   3.40  86.74  97.64  93.31 193019 1027.949  2648  353.905 1381.854
      0.00  98.20  12.15  86.74  97.64  93.31 193019 1027.949  2648  353.905 1381.854
    
    ```
4. 解释:
    - S0: Survivor space 0 utilization as a percentage of the space's current capacity.
    - S1: Survivor space 1 utilization as a percentage of the space's current capacity.
    - E: Eden space utilization as a percentage of the space's current capacity.
    - O: Old space utilization as a percentage of the space's current capacity.
    - M: Metaspace utilization as a percentage of the space's current capacity.
    - CCS: Compressed class space utilization as a percentage.
    - YGC: Number of young generation GC events.
    - YGCT: Young generation garbage collection time.
    - FGC: Number of full GC events.
    - FGCT: Full garbage collection time.
    - GCT: Total garbage collection time.

5. 注意:
    - 各个分区的容量都在动态变化的...//TODO