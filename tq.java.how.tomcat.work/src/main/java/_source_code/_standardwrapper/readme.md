2018-05-03

## StandardWrapper

### SingleThreadModel
1. 一个标识接口
2. 标识 当前servlet 不是线程安全的, 需要没有重新创建一个新的 servlet, 放入 stack中
3. 对于静态变量任然没有办法