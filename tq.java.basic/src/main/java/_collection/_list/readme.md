2018-03-03

### LinkedList
1. **双向链表**

### 循环删除倒数第二个元素的时候不会抛出异常
1. modCount是指这个list对象从new出来到现在被修改次数，当调用List的add或者remove方法的时候，这个modCount都会自动增减;
2. expectedModCount是指Iterator现在期望这个list被修改的次数是多少次。
3. **iterator创建的时候modCount被赋值给了expectedModCount**，但是调用list的add和remove方法的时候不会同时自动增减expectedModCount
3. 想让其不抛出异常
    - 一个办法是让iterator在调用hasNext()方法的时候返回false，这样就不会进到next()方法里了
    - **比如删除倒数第二个元素的时候，cursor指向最后一个元素的，而此时删掉了倒数第二个元素后，cursor和size()正好相等了，所以hasNext()返回false，遍历结束，这样就成功的删除了倒数第二个元素了**