2019-06-26

## 思考

1. java对象在堆中申请内存的时候 比 malloc 要快
    - 需要调用本地函数
    - java堆 直接划分内存就好了

2. 如果是 HeapByteBuffer, 先 DirectBuffer, 然后 writeFromNativeBuffer
    - 写入 网络/文件, 内存不能动
    - gc
    - 先把要发送的 东西放入 一块 地址不会变化的内存 --> DirectBuffer