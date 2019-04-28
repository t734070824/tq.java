2019-04-28


## 思考
1. 那为什么iterator.remove()方法可行呢？
    - 是没有在调用list.remove的前提下, 这样会修改 modCount
    - 此方法不修改 modCount, 只是 expectedModCount = modCount;
    - 调用 也只是做了 检查