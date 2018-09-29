2018-09-29

## 用Http 核心模块配置一个静态Web服务器
````
http {
    gzip on;
    upstream{
        ...
    }
    
    ...
    
    server{
        listen localhost:80;
        ...
        location /webstatic{
            if ...{
                ...
            }
            root /opt/webresource;
            ...
        }
        
        location ~* .(jpg|jpeg|png|jpe|gif)${
            ...
        }
    }
    
    server {
        ...
    }
}
````

1. 虚拟主机与请求转发
1. 文件路径的定义
1. 内存与磁盘资源的分配
1. 网络连接的设置
1. MIME 类型的设置
1. 对客户端请求的限制
1. 文件操作的优化
1. 对客户端请求的特殊处理

### 虚拟主机与请求转发
1. 