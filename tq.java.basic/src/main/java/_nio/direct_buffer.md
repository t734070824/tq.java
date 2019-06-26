2019-06-26

## 堆外内存/直接内存
1. 内存映射

### 什么是直接内存
1. 脱离 JVM 管理的
2. unsafe.allocateMemory(size);
    - **malloc**


### 特点
1. java对象在堆中申请内存的时候 比 malloc 要快, 
2. 在进行网络/文件 读写的时候 比较快
    - 如果是 DirectBuffer 直接 writeFromNativeBuffer
    - 如果是 HeapByteBuffer, 先 DirectBuffer, 然后 writeFromNativeBuffer
        - 防止 gc的时候 内存移动

### 需求
1. java GC三大类算法，除了标记清除，标记整理和复制算法都会移动对象，
2. 并且如果直接把java堆地址传给I/O函数则需要保证I/O操作过程中该块内存不变化，则需要暂停GC，
    - --> 所以JDK实现使用拷贝的方式。

### 场景
1. 直接内存适用于不常申请，但是需要频繁读取的场景，
2. 在需要频繁申请的场景下不应该使用直接内存(DirectMemory)，而应该使用堆内内存(HeapMemory)。