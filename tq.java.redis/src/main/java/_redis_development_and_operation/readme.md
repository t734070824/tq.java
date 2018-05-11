2018-05-11

##其他

### 问题
1. 分布式锁
    - setnx + expire: 加一个过期时间防止锁忘记了释放
    - setnx之后执行expire之前进程意外crash或者要重启维护了
        - SET key value [EX seconds] [PX milliseconds] [NX|XX]
            - EX second ：设置键的过期时间为 second 秒。 SET key value EX second 效果等同于 SETEX key second value 。
            - PX millisecond ：设置键的过期时间为 millisecond 毫秒。 SET key value PX millisecond 效果等同于 PSETEX key millisecond value 。
            - NX ：只在键不存在时，才对键进行设置操作。 SET key value NX 效果等同于 SETNX key value 。
            - XX ：只在键已经存在时，才对键进行设置操作。