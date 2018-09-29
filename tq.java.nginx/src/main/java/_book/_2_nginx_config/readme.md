2018-09-29

## Nginx 的配置

### 运行中的 Nginx
1. 一个master管理多个 Worker 进程
    - master 进程不对外提供服务
    - 纯管理的工作
        - 启动服务
        - 重载配置
        - 平滑升级
2. worker 进程的数量和服务器上CPU核心数相等
    - 多核并发
    
### 配置的通用语法
````
user noboby;
worker_processes 8;
error_log /var/log/nginx/error.log error
#pid  logs/nginx.pid
events {
    use epoll;
    worker_connections 50000;
}
http {
    include mime.type;
    default_type application/octet-stream;
    log_format main '$remote_addr [$time_local] "#request" '
                    '$status $byte_sent "$http_referer" '
                    '"$http_user_agent" "$http_x_forwarder_for"';
    access_log  logs/access.log main    buffer=32K;
}

````

### 块配置项
````
events{
    ...
}

http{
    upstream backend{
        server 127.0.0.1:8080;
    }
    gzip on;
    server{
        ...
        location /webstatic{
            gzip off;
        }
    }
}
````
1. events http server location upstream
2. 冲突如何解决

### 配置项的语法格式
1. 配置项名 配置项值1 配置项值2
    - 空格作为分割符
    - 有多少个配置值 取决于 对应的配置项
    - 如果配置值中包含空格 需要用单引号或者是双引号
    
### 配置项的单位
1. K k M m
2. ms s m h d w M y

### 在配置中使用变量
1. 取决于对应配置项


### 用Http 核心模块配置一个静态Web服务器
1. [](http_web_server.md)
1. TODO
