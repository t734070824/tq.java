2018-06-05

## 其它

### Channel SocketChannel ServerSocketChannel
1.

### Selector Channel 
1. 既然一个 多个Channel 可以注册到一个 Selector上面, 那么 Selector.key.Channel是如何匹配Channel的??
    - channel注册到 Selector上, 实际上是 Channel 与 SelectionKey 一一对应, 
    - 当 某个通道上的 事件就绪, Selector就返回 SelectionKeyImpl
    - SelectionKeyImpl 由 Channel, SelectionKey 组合而成
    - //TODO 貌似不是这个

