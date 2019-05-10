2019-04-28


## 思考
1. 那为什么iterator.remove()方法可行呢？
    - 是没有在调用list.remove的前提下, 这样会修改 modCount
    - 此方法不修改 modCount, 只是 expectedModCount = modCount;
    - 调用 也只是做了 检查

2. 理解 hashmap, hashSet 重复添加同一个对象的问题
    - 现在hashcode, 然后 equal
    - 体现了 hashMap 使用 String作为 key的原因
    - 在 hashSet 添加或者是移除对象的时候, 先根据 hashcode 判断index, 
    - 如果在这个期间, 对象修改了自己的hashcode, n那么.........