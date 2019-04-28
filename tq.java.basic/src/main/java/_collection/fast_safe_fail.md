2019-04-28

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
    - 如果迭代过程中发生了改变, 但是灭有 next调用 迭代, 那么 CME 就不会抛出

### fail-safe
1. 解决 fail-fast 抛出异常处理不方便的地方, 针对线程安全的类
2. 是一个概念
    - 并发容器的并发修改不会抛出异常, 
    - 和实现有关
    - 并发容器的 Iterator 对象返回是集合对象的一个副本 
    - **你可以并发读取，不会抛出异常，但是不保证你遍历读取的值和当前集合对象的状态是一致的**