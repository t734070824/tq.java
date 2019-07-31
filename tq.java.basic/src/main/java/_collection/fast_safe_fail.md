2019-04-28

### 20190731 新
1. 其实list 循环删除 报错的原因就是 modCount 和 expectedModCount 不一致
    - 为什么 采用 for + index 的形式不会报错
        - 因为这里的处理根本不关心 modCount 和 expectedModCount
    - 那为什么 foreach 形式会报错
        - 因为foreach 底层就是 Iterator
        - 但是 又没有 去同步 modCount 和 expectedModCount
        - 造成 expectedModCount 不变, modCount 增加
    - Iterator.remove(), 不报错
        - 同步 modCount 和 expectedModCount
    - 取巧的方法解决漏删的问题
        - 引起漏删是因为 list 删除的时候 节点会前移, 但是当前访问的 index 不会改变, 相当于跳过了一个节点
        - 解决
            - 从后往前删除--> 数组的节点不会前移


## fail-fast, fail-safe
1. 对于线程不安全的类, 并发修改的情况下可能出现 fail-fast
2. 对于线程安全的类, 可能出现 fail-safe

### fail-fast快速失败
1. 当遍历一个集合对象时，如果集合对象的结构被修改了，就会抛出ConcurrentModificationExcetion异常
    - 在 Iterator 对象遍历的过程中, 调用了集合本身的remove, add, clear 方法
    - 在 Iterator的 modCount != expectedModCount 检查中, 引起 CME
2. 快速失败行为 无法得到保证 
3. **快速失败迭代器会尽最大努力抛出 ConcurrentModificationException**
    - 只有在 调用 Iterator.next 才会去检查 modCount 是否改变, 
    - 如果迭代过程中发生了改变, 但是没有 next调用 迭代, 那么 CME 就不会抛出
    - (20190731)
        - remove方法也会检测 modCount 以及 expectedModCount
        - 并 expectedModCount = modCount;

### fail-safe
1. 解决 fail-fast 抛出异常处理不方便的地方, 针对线程安全的类
2. 是一个概念
    - 并发容器的并发修改不会抛出异常, 
    - 和实现有关
    - 并发容器的 Iterator 对象返回是集合对象的一个副本 
    - **你可以并发读取，不会抛出异常，但是不保证你遍历读取的值和当前集合对象的状态是一致的**