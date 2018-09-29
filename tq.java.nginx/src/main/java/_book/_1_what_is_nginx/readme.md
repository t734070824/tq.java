2018-09-28

## 什么是 Nginx

### Web服务器的基本特征
1. 基于Rest架构风格
2. 以统一资源描述符(URL) 或 统一资源定位符(URL) 作为沟通依据
3. 通过HTTP 为浏览器等客户端提供各种网络服务

### 选择 Nginx
1. 更快
2. 高扩展性
    - 低耦合
    - 分模块
    - 插件
3. 高可靠
    - Master-Worker
4. 低内存消耗
5. 单机支持10W以上的并发
6. 热部署

### 为什么那么快
1. 事件驱动设计
2. 全异步的网络I/O处理机制
3. 极少的进程间切换

### 必备软件
1. GCC编译器
    - yum install -y gcc
    - yum install -y gcc-c++
2. pcre
    - Perl Compatible Regular Expressions Perl兼容正则表达式
    - nginx.conf 使用正则表达式
    - yum install -y pcre pcre-devel
3. zlib库
    - HTTP-gzip
    - yum install -y zlib zlib-devel
4. Openssl
    - HTTPS, MD5, SHA1
    - yum install -y openssl openssl-devel

### 存放目录
1. /usr/local/nginx

### Linux 内核参数优化
1. 最通用, 使Nginx支持更多并发请求的TCP网络参数
    - fs.file-max = 999999
        - 表示进程可以同时打开的最大句柄数
        - 直接限制最大并发连接数
    - net.ipv4.tcp_tw_reuse = 1
        - 1: 表示允许将 TIME_WAIT 状态的Socket 重新用于新连接
        - 服务器上总是有大量的连接处于 TIME_WAIT
    - net.ipv4.tcp_keepalive_time = 60
        - 秒
        - 表示当keepalive起用的时候，TCP发送keepalive消息的频度
        - 设置的小, 可以更快的清理无效的连接
    - net.ipv4.tcp_fin_timeout = 30
        - 秒
        - 表示如果套接字由本端要求关闭，这个参数决定了它保持在FIN-WAIT-2状态的时间。
        - 四次挥手
    - net.ipv4.tcp_max_tw_buckets = 5000
        - 允许 TIME_WAIT 套接字数量的最大值, 
        - TIME_WAIT 套接字数量超出这个数字会立刻被清除, 打印告警信息
        - 默认 180000, 过多会导致 Web服务器变慢
    - net.ipv4.ip_local_port_range = 1024 61000
        - UDP, TCP 连接的本地的端口范围
    - net.ipv4.tcp_rmem = 4096 32768 262142
        - TCP接收缓存(用于TCP接收滑动窗口)的 最小 默认 最大
    - net.ipv4.tcp_wmem = 4096 32768 262142
        - TCP发送缓存(用于TCP发送滑动窗口)的 最小 默认 最大
    - net.core.netdev_max_backlog = 8096
        - 当 网卡的接收数据包的速度大于内核处理的熟读是, 会有一个队列保存这些数据包, 
        - 该队列的最大值
    - net.core.rmem_default = 262142
        - 内核 socket 接收缓冲区默认的大小
    - net.core.wmem_default = 262142
        - 内核 socket 发送缓冲区默认的大小
    - net.core.rmem_max = 2097152
        - 内核 socket 接收缓冲区最大的大小
    - net.core.wmem_max = 2097152
        - 内核 socket 发送缓冲区最大的大小
    - net.ipv4.tcp_syncookies = 1
        - 性能无关
        - 当出现SYN等待队列溢出时，启用cookies来处理，可防范少量SYN攻击，默认为0，表示关闭
    - net.ipv4.tcp_max_syn_backlog = 1024
        - 表示TCP三次握手建立阶段接受 SYN 请求队列的最大长度
        - 默认 1024
        - 设置大一些, 防止 Nginx 来不及接收新连接时, 不至于丢失客户端的连接请求
    
### nginx 命令行控制
1. nginx -c /tmp/nginx.conf
    - 指定配置文件启动
2. nginx -t
    - 测试配置文件是否错误
3. nginx -s stop
    - 快速关闭
    - 向 master 发送信号量
    - worker进程与master进程收到信号, 立刻跳出循环
4. nginx -s quit
    - 优雅的关闭 nginx
    - 正常处理完所有请求在停止服务
5. nginx -s reload
    - 检查配置是否有错
    - 优雅的关闭
    - 重新启动
6. nginx -s reopen
    - 日志文件回滚
    - 重新打开日志文件
    - 备份原日志文件, 防止文件过大