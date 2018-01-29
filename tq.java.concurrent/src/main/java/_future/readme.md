2018-01-29

### Future
1. 是一种设计模式, 也只是一种设计模式
2. 可以看做一个对 异步处理结果的引用
3. Future 可以在连续流程中满足数据驱动的并发需求, 即获得了 并发执行的性能提升, 又不失连续流程的简单优雅
4. **但是**:如果Future结果生成太慢的话, 就会导致 消费者阻塞,
5. 理解: 就是在不急于需要此次处理的数据,并且有其他事情需要完成的时候, 使用Future模式

### Future接口
- cancel方法用来取消任务，如果取消任务成功则返回true，如果取消任务失败则返回false。
参数mayInterruptIfRunning表示是否允许取消正在执行却没有执行完毕的任务，如果设置true，
则表示可以取消正在执行过程中的任务。如果任务已经完成，则无论mayInterruptIfRunning为true还是false，
此方法肯定返回false，即如果取消已经完成的任务会返回false；如果任务正在执行，若mayInterruptIfRunning设置为true，
则返回true，若mayInterruptIfRunning设置为false，则返回false；如果任务还没有执行，则无论mayInterruptIfRunning为true还是false，肯定返回true。
- isCancelled方法表示任务是否被取消成功，如果在任务正常完成前被取消成功，则返回 true。
- isDone方法表示任务是否已经完成，若任务完成，则返回true；
- get()方法用来获取执行结果，这个方法会产生阻塞，会一直等到任务执行完毕才返回；
- get(long timeout, TimeUnit unit)用来获取执行结果，如果在指定时间内，还没获取到结果，就直接返回null。