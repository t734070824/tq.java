2018-08-07

## 练习

### 练习
1. 有序性对二列表查找操作效率癿提高有多大作用？
    - 没有实质的提升
    - 当列表是有序的时候, 可以通过二分查找, 将 O(n) 降为 O(logn)
2. 考查如教材 73页代码 3.7和 74页代码 3.8所示的列表节点插入算法 LisrNode::insertAsPred()
   和 ListNode::insertAsSucc()
   ```text
        1 template <typename T> 
        2 ListNodePosi(T) ListNode<T>::insertAsPred(T const& e) {
        3 ListNodePosi(T) x = new ListNode(e, pred, this); 
        4 pred->succ = x; pred = x; 
        5 return x; 
        6 }
     
        1 template <typename T> 
        2 ListNodePosi(T) ListNode<T>::insertAsSucc(T const& e) {
        3 ListNodePosi(T) x = new ListNode(e, this, succ); 
        4 succ->pred = x; succ = x; 
        5 return x; 
        6 }
    ```
    - 在什么情冴下，新插入的节点既是首节点也是末节点？
        - 列表为空
    - 此时，返两种算法是否依然适用？为什么？试通过实测验证你的结论
        - 哨兵节点
3. 对于数据结构的操作, 往往几种在数据元素的较小子集, 实现一个自适应调整的列表, 可以在每次访问的节点在数据的前端, 提高效率
    - 新元素作为首节点
    - 已有的元素一旦被访问, 转移到最前端
    - LRU
4. 假设序列中n个元素的数值为独立均匀的随机分布, 
    - 列表的插入排序的算法平均时间 n^2/4=O(n^2)次比较操作
        - 数学期望
        - O(n^2)
    - 序列的插入排序算法过程中平均有 expected-O(logn)个元素无需移动。
        - //TODO
    
