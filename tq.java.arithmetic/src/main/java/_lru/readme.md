2017-11-29
## 1.LRU
LRU是Least Recently Used 的缩写，翻译过来就是“最近最少使用”，LRU缓存就是使用这种原理实现，简单的说就是缓存一定量的数据，当超过设定的阈值时就把一些过期的数据删除掉，比如我们缓存10000条数据，当数据小于10000时可以随意添加，当超过10000时就需要把新的数据添加进来，同时要把过期数据删除，以确保我们最大缓存10000条，那怎么确定删除哪条过期数据呢，采用LRU算法实现的话就是将最老的数据删掉

## LRU Cache的LinkedHashMap实现
因为LinkedHashMap本身就实现了有序存储,默认是按照插入顺序排序.可以通过构造函数来实现按照访问顺序排序
```
//LinkedHashMap的一个构造函数，当参数accessOrder为true时，即会按照访问顺序排序，最近访问的放在最前，最早访问的放在后面
public LinkedHashMap(int initialCapacity, float loadFactor, boolean accessOrder) {
        super(initialCapacity, loadFactor);
        this.accessOrder = accessOrder;
}

//LinkedHashMap自带的判断是否删除最老的元素方法，默认返回false，即不删除老数据
//我们要做的就是重写这个方法，当满足一定条件时删除老数据
protected boolean removeEldestEntry(Map.Entry<K,V> eldest) {
        return false;
}
```
如果想实现线程安全的LRU缓存,只需要在get,put,remove方法加锁

## LRU Cache 不用LinkedHashMap实现的基本思想
- 一个entry含有 pre,next,k,v
- 一个hashMap
- **一个双向链表:** 当有数据插入的时候,判断长度,删除最后的数据,当查询数据的时候,将查找的entry移动到链表第一位