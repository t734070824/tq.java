2019-04-19

## 思考
1. Spark 的全局时钟如何(WaterMask)
    - TODO
2. RDD, DataSet, DataFrame
    - TODO
3. 从source拿到数据, 经过 处理, sink 到别的地方
    - 那么, 从source拿到数据 最后在哪里? 内存?
    - 如果在内存, 
        - 流式处理中, 数据岂不是越来愈大??
3. outMode 有 Complete, Append, Update
    - 都是基于 Result Table rows , 难道 Result Table rows  一直都在内存里?
        - 快照?
        - CheckPoint? 
4. 容错 故障恢复实现的根本
    - TODo
5. Spark 为何需要那么大的机器承载
    - TODo
6. 从检查点恢复故障
    - TODO
8. A master URL must be set in your configuration   
    - 从提示中可以看出找不到程序运行的master，此时需要配置环境变量。
    - https://blog.csdn.net/shenlanzifa/article/details/42679577
    - -Dspark.master=local
1. Windows本地搭建Spark开发环境
    - https://blog.csdn.net/qq_32653877/article/details/81913648
1. Could not locate executable null\bin\winutils.exe in the Hadoop binaries.
    - https://www.cnblogs.com/hyl8218/p/5492450.html