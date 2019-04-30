2019-04-26

## Docker 教程

### 安装
1. https://docs.docker.com/install/linux/docker-ce/centos/

### Hello World
1. docker run centos:latest /bin/echo "Hello world"
    - docker: docker 的二进制文件
    - run: 和前面的 docker 组合来运行一个容器
    - centos:latest: 指定要运行的镜像
    - /bin/echo "Hello world": 在启动给的容器里执行的命令
    

### 运行交互式的容器
1. docker run -it centos:latest /bin/bash
    - -t: 在容器内指定一个终端
    - -i: 允许对容器内的标准输入进行交互
    - exit/ ctrl+d 退出容器

### 启动容器(后台模式)
1. docker run -d centos:latest /bin/sh -c "while true; do echo hello world; sleep 1; down"
    - -d: 后台运行

### docker ps
1. docker ps 
    - 当前运行的容器

### 停止
1. docker stop name/id

### 运行 web 应用
1. Python Flask
    - docker run -d -P training/webapp python app.py 
    
### 检查 WEB 应用程序
1. docker inspect name

### 其他
1. docker ps 
    - -a
    - -l
1. docker rm name
    - close
    
### Image
1. 提交更新镜像
    - docker commit -m="has update" -a="t734070824" e218edb10161 t734070824/centos:none
        - -m: 描述
        - -a: 指定镜像作者
        - 容器id
        - t734070824/centos:none: 指定要创建的目标镜像名
2. 构建镜像
    - Dockerfile 
        - 文件名必须是 Dockerfile
        - docker build -t name 目录
            - -t: 镜像名字
            -  Dockerfile 所在的目录
3. 增加镜像标签
    - docker tag image_id t734070824/centos:dev
    
### 容器连接
1. 网络端口映射
    - -P
        - 是容器内部端口随机映射到主机的高端口。
    - -p
        - 是容器内部端口绑定到指定的主机端口。
    - 指定容器绑定的网络地址，比如绑定 127.0.0.1。
        - 127.0.0.1:5001:5000
    - 默认都是绑定 tcp 端口，如果要绑定 UDP 端口，可以在端口后面加上 /udp。
        - 127.0.0.1:5001:5000/udp
2. Docker容器连接
    - --name 命名容器名字
        
    