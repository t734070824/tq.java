2018-01-23

## ByteBuf

### ByteBuf 优点
1. 可以被用户自定义的缓冲区类型扩展
2. 通过内置的复合缓冲区类型实现了透明的零拷贝????
3. 容量可以按需增长
4. 在读和写着两种模式之间切换不用调用 ByteBuffer的flip()方法
5. 读和写使用了不同的索引
6. 支持方法的链式调用
7. 支持引用计数
8. 支持池化

### 概念
1. 如何工作
    - readerIndex, writeIndex
    - readerIndex > writeIndex--> error, writeIndex > MAX_CAPACITY-->error
2. 使用模式
    - **一个由不同的索引分别控制读访问以及写访问的字节数组**
    - 堆缓冲区
        - 


### 直接缓冲区
1. 直接缓冲区的内容将驻留在常规的会被垃圾回收的堆之外,
2. 如果数据 包含在一个在堆上分配的缓冲区中, 在通过套接字发送之前, JVM会在内部把这个缓冲区复制到一个直接缓冲区中

### 顺序访问索引
1. JDK的 ByteBuffer 需要调用 flip() 的重要原因就是要 在 读模式和写模式之间切换(readIndex, writeIndex) 


### discardReadBytes():回收已度过数据的内存
1. 迁移 readIndex--writeIndex 之间得到数据到0-(writeIndex - readIndex)
1. readerIndex = 0, 修改writerIndex = (writeIndex - readIndex),
2. 迁移write导致内存复制,
2. 最好在 内存非常宝贵的时候使用

### ByteBuf.clear()
1. clear()方法来将 readerIndex 和 writerIndex 都设置为 0。注意， **这并不会清除内存中的内容**
2. **只重置索引但不会重置任何内容**

### 派生缓冲区
1. duplicate(), slice() 虽然有全新的索引, 但是对源 ByteBuf 的修改依然体现在拍摄缓冲区中, 反之依然
2. copy()方法可以得到一个真实副本, 拥有独立的数据缓冲区

### 引用计数
1. //TODO

### 总结
1. 使用**不同的读索引和写索引**来控制数据访问
1. 使用内存的不同方式——基于**字节数组和直接缓冲区**；
1. 通过 CompositeByteBuf 生成多个 ByteBuf 的聚合视图；
1. 数据访问方法——**搜索、切片以及复制**；
1. 读、写、获取和设置 API；
1. **ByteBufAllocator 池化和引用计数**。