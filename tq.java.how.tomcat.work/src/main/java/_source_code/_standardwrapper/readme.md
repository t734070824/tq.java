2018-05-03

## StandardWrapper

### SingleThreadModel
1. 一个标识接口
2. 标识 当前servlet 不是线程安全的, 需要重新创建一个新的 servlet, 放入 stack中
3. 对于静态变量任然没有办法

### 外观设计模式
1.

### 过滤链
1. 每个过滤器的 doFilter都会拥有一个 FilterChain 参数
2. 执行完当前filter的doFilter方法之后, 直接调用 FilterChain 的 doFilter(request, response, chain)
3. this.iterator.hasNext()
4. 最后 servlet.service