2018-05-08

## 多实例部署
1. Redis 单线程架构导致无法充分利用多核CPU
2. 一台机器部署多个Redis实例
3. 开启 AOF重写后, 多个进程 消耗 CPU 和 IO
4. **CPU 和 IO 竞争**

### 解决方案
![](https://github.com/t734070824/tq.java/blob/master/tq.java.redis/src/main/java/_redis_development_and_operation/_5_persistence/7.jpg?raw=true)

1. 流程
    - 关闭自动重写功能
    - 外部程序轮训监控机器上所有的 Redis实例
    - 对于开启AOF的实例， 查看（aof_current_sizeaof_base_size） /aof_base_size确认增长率
    - 当增长率超过特定阈值（如100%） ， 执行bgrewriteaof命令手动触发当前实例的AOF重写
    - 运行期间循环检查aof_rewrite_in_progress和aof_current_rewrite_time_sec指标， 直到AOF重写结束
    - 确认实例AOF重写完成后， 再检查其他实例并重复以上操作。**从而保证机器内每个Redis实例AOF重写串行化执行**