2018-09-19

## 思考
1. 软, 弱, 虚 使用场景
    - 软:
        - 实现内存敏感的高速缓存
        - 可以通过其他方式恢复的对象
    - 弱
        - 可以和一个引用队列（ReferenceQueue）联合使用
        - 如果弱引用所引用的对象被垃圾回收，Java虚拟机就会把这个弱引用加入到与之关联的引用队列中
    - 虚
        - **虚引用必须和引用队列（ReferenceQueue）联合使用**

2. ReferenceQueue 的作用
    - 只是获取一个通知, 在外面循环获取 Queue 里面的内容
        
2. Parallel Scavenge 收集器 的特点
    - 追求吞吐量

3. Parallel Scavenge 收集器 -- > 适合: 后台运算而不需要太多交互的任务??


4. 什么是剩余空间不足
    - 剩余空间不够不是说整体的空间不够分配某个对象，**而是说连续的空间不够分配给某个对象**。

5. Remembered Set 记录在被引用方
    - 对象移动无感知
