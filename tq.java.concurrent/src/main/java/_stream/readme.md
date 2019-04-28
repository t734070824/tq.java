2019-04-28

## Stream API

### 为什么需要 Stream
1. 对集合(Collection) 对象功能的增强
2. 和 新出现的 Lambda 表达式, 提高编程效率和程序可读性
3. 提供串行和并行两种模式进行 汇聚操作
    - 并发模式充分利用多核处理器优势
    - 使用 fork/join 并行方式来拆分任务和加速 处理过程
    
### 总览
1. 不是集合元素, 不是数据结构也不保存数据, 高级版本的 Iterator
2. 如同一个迭代器, **单向, 不可往复, 只遍历一次**

### 流的操作类型(Intermediate, Terminal)
1. Intermediate
    - 一个流后面可以跟多个或者零个 Intermediate 操作
    - 主要目的是打开流, 做出某种程序的数据映射/过滤 , 然后返回一个新的流, 交给下一个操作使用, 
    - 这类操作是惰性化的(lazy), 仅仅是调用方法, 没有开始真正的流
        - 相当于水流的路径上 只是安装了栅栏, 水还没有开始流动 
2. Terminal
    - 一个流只能有一个 terminal 操作
    - 当这个操作执行后，流就被使用“光”了，无法再被操作。
    - 所以这必定是流的最后一个操作。Terminal 操作的执行，才会真正开始流的遍历，并且会生成一个结果，或者一个 side effect。
3. short-circuiting
    - 对于一个 Intermediate 操作, 它接收一个无限大 的 Stream, **但返回一个有限的新Stream**
    - 对于一个 terminal 操作，如果它接受的是一个无限大的 Stream，**但能在有限的时间计算出结果**。
    
    
### 使用详解
1. 常用方法
```java
public class Demo{
    public static void main(String[] args){
      Stream stream = java.util.stream.Stream.of("a", "b", "c");
      stream = Stream.of(new String[]{});
      stream = java.util.Arrays.asList(strArray).stream();
    }
}

```
     
2. 操作
    - Intermediate
        - map(mapToInt, flatMap), filter, distinct, sorted, peek, limit, skip, parallel,
        sequential、 unordered
    - Terminal
        - forEach, forEachOrdered, toArray, reduce, collect, min, count, anyMatch, allMatch, noneMatch
        findFist, findAny, iterator