2018-05-24

## jmap

### jmap -heap pid 
1. 内容
    ```text
        Attaching to process ID 28601, please wait...
        Debugger attached successfully.                        |
        Server compiler detected.                              |
        JVM version is 25.45-b02                               |
                                                               |
        using thread-local object allocation.                  |
        Parallel GC with 2 thread(s)                           |  	GC 方式
                                                               |	对应jvm启动参数-XX:MinHeapFreeRatio设置JVM堆最小空闲比率(default 40)
        Heap Configuration:                                    |	
           MinHeapFreeRatio         = 0                        |	
           MaxHeapFreeRatio         = 100                      |	对应jvm启动参数 -XX:MaxHeapFreeRatio设置JVM堆最大空闲比率(default 70)
           MaxHeapSize              = 994050048 (948.0MB)      |	对应jvm启动参数-XX:MaxHeapSize=设置JVM堆的最大大小
           NewSize                  = 20971520 (20.0MB)        |	对应jvm启动参数-XX:NewSize=设置JVM堆的‘新生代’的默认大小
           MaxNewSize               = 331350016 (316.0MB)      |	对应jvm启动参数-XX:MaxNewSize=设置JVM堆的‘新生代’的最大大小
           OldSize                  = 41943040 (40.0MB)        |	对应jvm启动参数-XX:OldSize=<value>:设置JVM堆的‘老生代’的大小
           NewRatio                 = 2                        |	对应jvm启动参数-XX:NewRatio=:‘新生代’和‘老生代’的大小比率
           SurvivorRatio            = 8                        |	对应jvm启动参数-XX:SurvivorRatio=设置年轻代中Eden区与Survivor区的大小比值
           MetaspaceSize            = 21807104 (20.796875MB)   |	对应jvm启动参数-XX:MaxPermSize= :设置JVM堆的‘永生代’的最大大小
           CompressedClassSpaceSize = 1073741824 (1024.0MB)    |	
           MaxMetaspaceSize         = 17592186044415 MB        |
           G1HeapRegionSize         = 0 (0.0MB)                |
                                                               |
        Heap Usage:                                            |	堆内存分步 
        PS Young Generation                                    |
        Eden Space:                                            |	Eden区内存分布
           capacity = 142606336 (136.0MB)                      |	Eden区总容量
           used     = 47631752 (45.42517852783203MB)           |	Eden区已使用
           free     = 94974584 (90.57482147216797MB)           |	Eden区剩余容量
           33.40086656458237% used                             |	Eden区使用比率 
        From Space:                                            |
           capacity = 1048576 (1.0MB)                          |
           used     = 654616 (0.6242904663085938MB)            |
           free     = 393960 (0.37570953369140625MB)           |
           62.429046630859375% used                            |
        To Space:                                              |
           capacity = 26214400 (25.0MB)                        |
           used     = 0 (0.0MB)                                |
           free     = 26214400 (25.0MB)                        |
           0.0% used                                           |
        PS Old Generation                                      |	当前的Old区内存分布
           capacity = 227016704 (216.5MB)                      |
           used     = 174447312 (166.3659210205078MB)          |
           free     = 52569392 (50.13407897949219MB)           |
           76.84338153372185% used                             |
                                                               |
        13070 interned Strings occupying 1442112 bytes.        |

    ```
    