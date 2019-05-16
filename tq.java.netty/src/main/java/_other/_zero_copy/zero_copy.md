2019-03-25

## 零拷贝

### 概念
1. 在操作数据时, 不需要将数据 buffer 从一个内存区域拷贝到另一个内存区域. 因为少了一次内存的拷贝, 因此 CPU 的效率就得到的提升.
2. **Netty  Zero-copy 的更多的是偏向于 优化数据操作 这样的概念.**

### 实现机制
    1. Netty的接收与发送 ByteBuf 采用 Direct Buffers, 使用堆外内存进行socket读写, 不需要进行字节缓冲区的二次拷贝
2. CompositeByteBuf 提供组合Buffer对象, 将多个ByteBuf 合并为一个逻辑上的ByteBuf, 避免各个 ByteBuf 的拷贝 
3. 通过 wrap 操作, 我们可以将 byte[] 数组、ByteBuf、ByteBuffer等包装成一个 Netty ByteBuf 对象, 进而避免了拷贝操作.
4. ByteBuf 支持 slice 操作, 因此可以将 ByteBuf 分解为多个共享同一个存储区域的 ByteBuf, 避免了内存的拷贝.
3. 通过 FileRegion 包装的FileChannel.tranferTo 实现文件传输, 可以直接将文件缓冲区的数据发送到目标 Channel, 
    避免了传统通过循环 write 方式导致的内存拷贝问题.
    