2018-09-29

## 基本配置

### 用于调试进程和定位问题的配置项
1. 是否已守护进程的方式运行 nginx
    - 语法: daemon on|off;
    - 默认: daemon on;
    - 关闭守护进程模式
        - 方便跟踪调试 Nginx
2. 是否以 master/worker 方式工作
    - 语法: master_process on|off;
    - 默认: master_process on;
    - 关闭master/worker模式
            - 方便跟踪调试 Nginx
3. error 日志的设置
    - 语法: error_log /path/file level;
    - 默认: error_log logs/error.log error;
    - 关闭日志的唯一手段
        - error_log /dev/null;
    - level
        - debug info notice warn error crit alert emery
        - 从左到右依次增大
        - 大于等于该级别的日志都会输出
    - debug
        - configure --with-debug
4. 仅对指定的客户端输出debug级别的日志
    - 语法: debug_connection [IP|CIDR]
    - 事件类配置 
    - ``events{debug_connection 10.xxx.xx.xx; debug_connection 10.xxx.xx.xx/xx;}``
    - debug
        - configure --with-debug
5. 限制 coredump 核心转储文件的大小
    - 语法: worker_rlimit_core size;
    - TODO
6. 指定 coredump 文件生产目录
    - 语法: working_directory path;
    
### 正常运行的配置项
1. TODO

### 优化配置
1. TODO