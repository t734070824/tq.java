2018-06-05

## 其它

### Channel SocketChannel ServerSocketChannel
1.

### Selector Channel  SelectionKey
1. http://www.cnblogs.com/duanxz/p/6782783.html
1. **SelectionKey 封装了特定的通道与特定的选择器的注册关系**
2. select()方法返回的值表示有多少个 Channel 可操作
3. 每个键都关联一个已经准备好至少一种操作的通道
4. Selector维护的三种类型SelectionKey集合
    - 已注册的键的集合(Registered key set)
    - 已选择的键的集合(Selected key set)
    - 已取消的键的集合(Cancelled key set)
5. remove()
    - 在每次迭代时, 我们都调用 "keyIterator.remove()" 将这个 key 从迭代器中删除, 
    - 因为 select() 方法仅仅是简单地将就绪的 IO 操作放到 selectedKeys 集合中, 因此如果我们从 selectedKeys 获取到一个 key, 
    - 但是没有将它删除, 那么下一次 select 时, 这个 key 所对应的 IO 事件还在 selectedKeys 中
2. 既然一个 多个Channel 可以注册到一个 Selector上面, 那么 Selector.key.Channel是如何匹配Channel的??
    - channel注册到 Selector上, 实际上是 Channel 与 SelectionKey 一一对应, 
    - 当 某个通道上的 事件就绪, Selector就返回 SelectionKeyImpl
    - SelectionKeyImpl 由 Channel, SelectionKey 组合而成
    - //TODO 貌似不是这个

