2018-06-01

## 分布式锁
http://www.importnew.com/27477.html

### 实现方式
1. 数据库乐观锁
2. 基于Redis的分布式锁
3. 基于 ZooKeeper的分布式锁

### 要求
1. 可重入
    - 身份串
2. 惊群效应(Herd Effect)
    - 在有多个请求等待获取锁的时候，一旦占有锁的线程释放之后，如果所有等待的方都同时被唤醒，尝试抢占锁
    - 解决
        - 分段
        - 分配顺序(链表)

### Redis分布式锁
1. 满足四个条件
    - 互斥性: 在任意时刻, 只有一个客户端可以持有锁
    - 不会发生死锁: 即使持有锁的客户端因为崩溃等原因没有释放锁, 也能保证后续客户端可以获取锁
    - 容错性: 只要大部分的Redis节点正常运行, 客户端就可以加锁与解锁
    - 解铃还须系铃人: 加锁和解锁必须是同一个客户端
2. 加锁: jedis.set(lockKey, requestId, "NX", "PX", expireTime)
    - lockKey: 使用key来当锁，因为key是唯一的。
    - **requestId: 在解锁的时候就可以有依据(UUID), 保证加锁与解锁都是同一个客户端**
    - NX: SET IT NOT EXIST, 当key不存在时，我们进行set操作；若key已经存在，则不做任何操作
    - PX: 给这个key加一个过期的设置，具体时间由第五个参数决定--防止死锁
    - expireTime: 过期时间
3. 解锁
    - String script = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
    - Object result = jedis.eval(script, Collections.singletonList(lockKey), Collections.singletonList(requestId));
    - Redis 执行 evel()可以确保原子性
    - 就是在eval命令执行Lua代码的时候，Lua代码将被当成一个命令去执行，并且直到eval命令执行完成，Redis才会执行其他命令
4. 其他:
    - **如果Redis是多机部署的，那么可以尝试使用Redisson实现分布式锁，这是Redis官方提供的Java组件**