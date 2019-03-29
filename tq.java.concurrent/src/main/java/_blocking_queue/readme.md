2019-03-29

## BlockQueue

### LinkedBlockingQueue
1. 为什么  使用signal()而不是 signalAll()
    - 这顺便会减少无效竞争，提升性能
    - 那么 signalAll 存在的意义什么
        - TODO

2. while (count.get() == capacity)
    - 防止在获取锁的过程中, 其他线程竞争到锁, 把队列填满了
    - 为什么会有其他线程竞争锁呢
        - 当生产者获取锁, 检查队列是否已满, 发现已满 ,await(), 放弃锁, 进度等待唤醒队列
        - 其他生产者线程获取锁, 队列任然是满的 await
        - 此时, 就会有多个线程等待被唤醒

3. 队列长度为1时，到底入队和出队之间存在竞争吗
    - TODO- 哨兵节点