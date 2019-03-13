2019-03-12

## 分布式锁
1. http://stor.51cto.com/art/201901/590874.htm
2. https://juejin.im/post/5bf3f15851882526a643e207

### 满足
1. 互斥，在任何时刻，对于同一条数据，只有一台应用可以获取到分布式锁；
1. 不能发生死锁，一台服务器挂了，程序没有执行完，但是redis中的锁却永久存在了，
    那么已加锁未执行完的数据，就永远得不到处理了，直到人工发现，或者监控发现；
1. 高可用性，可以保证程序的正常加锁，正常解锁；
1. 加锁解锁必须由同一台服务器进行，不能出现你加的锁，别人给你解锁了。

### V1.0

```java

public class Lock{
    trylock(){
        SET key 1
        Expire key Seconds
    }
    
    release(){
        delete key
    }
        
}

```

1. 设计目的
    - 给锁加一个过期时间, 为了避免应用在服务重启或者异常导致锁无法释放后, 不会出现锁一直无法释放的问题
2. 问题
    - 当执行完第一个命令之后应用异常或者重启, 锁无法过期

### V2.0 SETNX

```java
public class Lock{
    trylock(){
        SETNX key 1 Seconds
    }
    
    release(){
        delete key
    }
        
}

```
1. 设计目的
    - 解决了两条命令无法保证原子性的问题
2. 问题
    - C1获取锁, 之后C1进入GC或者是 未知原因(睡眠) 导致任务执行时间过长, **最后在锁失效前没有主动释放锁**
    - C2在锁失效后获取锁, 并且开始执行, 此时 C1, C2 同时执行, 造成重复数据或者数据不一致
    - 如果C1线执行完毕, 可能会释放C2的锁, 可能导致 C3获取锁
3. 总结
    - 由于C1的停顿导致C1 和C2同都获得了锁并且同时在执行，在业务实现间接要求必须保证幂等性
    - C1释放了不属于C1的锁

### V3.0

```java
public class Lock{
    trylock(){
        SETNX key UnixTimestamp Seconds  
    }
    
    release(){
        EVEL{
            //LuaScript
            if redis.call("get", KEYS[1]) == AVGV[1] then
                return redis.call("del", KEYS[1])
            else 
                return 0
            end
        }   
    }
        
}

``` 
1. 设计目的
    - 通过指定Value为时间戳，并在释放锁的时候检查锁的Value是否为获取锁的Value，避免了V2.0版本中提到的C1释放了C2持有的锁的问题
    - 另外在释放锁的时候因为涉及到多个Redis操作，并且考虑到Check And Set 模型的并发问题，所以使用Lua脚本来避免并发问题。
2. 问题
    - 并发极高的场景, 可能存在UnixTimestamp重复问题
    - 由于不能保证分布式环境下的物理时钟一致性，也可能存在UnixTimestamp重复问题
    
### V3.1

```java
public class Lock{
    trylock(){
        SET Key UniqId Seconds  
    }
    
    release(){
        EVEL{
            //LuaScript
            if redis.call("get", KEYS[1] == AVGV[1]) then
                return redis.call("del", KEYS[1])
            else 
                return 0
            end
        }   
    }
        
}

```
1. 设计目的
    - 是使用一个自增的唯一UniqId代替时间戳来规避V3.0提到的时钟问题。
2. 问题
    - 集群问题
        - 假设在Master节点获取到锁后未完成数据同步情况下Master节点crash，
        - 此时在新的Master节点依然可以获取锁，所以多个Client同时获取到了
3. 解决的问题
    - 锁必须设置一个过期时间
    - 加锁以及设置过期时间 原子操作
    - 设置 随机字符串 标记 自己的身份, 用于释放锁
    - 释放锁的操作必须使用Lua脚本来实现
        - get , del 要求 原子

### V4.0(Redlock)
1. 问题
    - 集群环境下, Redis节点宕机, 所有客户端无法获取锁, 服务不可用, 系统自动切换到 Slave ,
        但是主从复制是异步的, 可能导致 锁 还没有同步到 Slave, 导致其他请求可以获取锁
2. 分布式锁 RedLock(步骤)
    - 获取当前时间（毫秒数）。
    - 按顺序依次向N个Redis节点执行获取锁的操作。这个获取操作跟前面基于单Redis节点的获取锁的过程相同，
        包含随机字符串my_random_value，也包含过期时间(比如PX 30000，即锁的有效时间)。
        为了保证在某个Redis节点不可用的时候算法能够继续运行，这个获取锁的操作还有一个超时时间(time out)，
        **它要远小于锁的有效时间（几十毫秒量级）**。
        客户端在向某个Redis节点获取锁失败以后，应该立即尝试下一个Redis节点。
        这里的失败，应该包含任何类型的失败，比如该Redis节点不可用，
        或者该Redis节点上的锁已经被其它客户端持有（注：Redlock原文中这里只提到了Redis节点不可用的情况，但也应该包含其它的失败情况）。
        - 计算整个获取锁的过程总共消耗了多长时间，计算方法是用当前时间减去第1步记录的时间。
        如果客户端从大多数Redis节点（>= N/2+1）成功获取到了锁，并且获取锁总共消耗的时间没有超过锁的有效时间(lock validity time)，
        那么这时客户端才认为最终获取锁成功；否则，认为最终获取锁失败。
    - 如果最终获取锁成功了，那么这个锁的有效时间应该重新计算，它等于最初的锁的有效时间减去第3步计算出来的获取锁消耗的时间。
    - 如果最终获取锁失败了（可能由于获取到锁的Redis节点个数少于N/2+1，或者整个获取锁的过程消耗的时间超过了锁的最初有效时间），
        那么客户端应该立即向所有Redis节点发起释放锁的操作（即前面介绍的Redis Lua脚本）。

### 其他
1. fencing token
    - 果客户端长期阻塞导致锁过期，那么它接下来访问共享资源就不安全了（没有了锁的保护）
         - 
         ![](1.png)
    - 解决
         - fencing token
             - 一个单调递增的数字，当客户端成功获取锁的时候它随同锁一起返回给客户端。
             - 而客户端访问共享资源的时候带着这个fencing token，这样提供共享资源的服务就能根据它进行检查，
             拒绝掉延迟到来的访问请求（避免了冲突）
             - 
             ![](2.png)

2. Redlock对系统记时(timing)的过分依赖
    - http://zhangtielei.com/posts/blog-redlock-reasoning.html
    - TODO