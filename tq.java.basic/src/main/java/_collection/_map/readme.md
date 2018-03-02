2018-01-05
### 根据 Key 从 Map 中获取数据的过程
1. key.hash --> index --> 链表 Or 红黑树 --> key == k

## Hashmap 1.8
1. https://tech.meituan.com/java-hashmap.html
### threshold
1. threshold = length * Load factor
2. 所能容纳的key-value对极限

### Load factor
1. 果内存空间很多而又对时间效率要求很高，可以降低负载因子Load factor的值；
相反，如果内存空间紧张而对时间效率要求不高，可以增加负载因子loadFactor的值，这个值可以大于1。
2. 

### modCount
1. 来记录HashMap内部结构发生变化的次数，主要用于迭代的快速失败
2. 内部结构发生变化指的是结构发生变化，例如put新键值对，但是某个key对应的value值被覆盖不属于结构变化

### 小结
1. 扩容是一个特别耗性能的操作，所以当程序员在使用HashMap的时候，估算map的大小，初始化的时候给一个大致的数值，避免map进行频繁的扩容。
2. 负载因子是可以修改的，也可以大于1，但是建议不要轻易修改，除非情况非常特殊。
3. HashMap是线程不安全的，不要在并发的环境中同时操作HashMap，建议使用ConcurrentHashMap。
4. JDK1.8引入红黑树大程度优化了HashMap的性能。
 
