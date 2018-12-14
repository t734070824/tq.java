2018-12-14

## 大量定时任务，如何高效触发超时
1. 对于客户端的TCP连接, 如果连续30s没有请求包（例如登录，消息，keepalive包），服务端就要将这个用户的状态置为离线

### 轮询扫描
1. 过程
    - 用一个Map<uid, last_packet_time> 记录每一个uid最近一次请求时间
    - 当一个用户包到达的时候, 实时更新这个Map
    - 启动一个 timer, 当map不为空的时候, 轮询扫描Map, 看每个uid的last_packet_time是否超过30s, 如果超过, 做超时处理
2. 缺点
    - 只启动一个timer, 需要轮询, 效率低

### 多 Timer 触发
1. 过程
    - 用一个Map<uid, last_packet_time>来记录每一个uid最近一次请求时间last_packet_time
    - 当某个**新用户**uid有请求包来到，实时更新这个Map，并同时对这个uid请求包启动一个timer，30s之后触发
    - 每个uid请求包对应的timer触发后，看Map中，查看这个uid的last_packet_time是否超过30s，如果超过则进行超时处理
2. 缺点
    - 不需要轮询，但每个请求包要启动一个timer，比较耗资源
    
### 环形队列法
1. 过程
    - 30s超时，就创建一个index从0到30的环形队列（本质是个数组）
    - 环上每一个slot是一个Set<uid>，任务集合
    - 同时还有一个Map<uid, index>，记录uid落在环上的哪个slot里
    - 启动一个 Timer, 每隔一秒, 移动一格, 0-1-2-3-...--19-30-0-1
    - 有一个Current Index 指针来标识当前正在检测的slot
2. 当用户uid请求到达的时候
    - 从Map结构中，查找出这个uid存储在哪一个slot里
    - 从这个slot的Set结构中，删除这个uid
    - 将uid重新加入到新的slot中，具体是哪一个slot呢 => **Current Index指针所指向的上一个slot**，因为这个slot，会被timer在30s之后扫描到
    - 更新Map，这个uid对应slot的index值
3. 集体超时
    - Current Index每秒种移动一个slot，这个slot对应的Set<uid>中所有uid都应该被集体超时
4. 优点
    - 一个 Timer
    - 每1s只触发一次
    - 批量超时
    