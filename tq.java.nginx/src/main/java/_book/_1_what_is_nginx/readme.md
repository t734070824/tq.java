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
    - net.ipv4.tcp_tw_reuse = 1
    - net.ipv4.tcp_keeplive_time = 60
    - net.ipv4.tcp_fin_timeout = 30
    - net.ipv4.tcp_max_tw_buckets = 5000
    
    