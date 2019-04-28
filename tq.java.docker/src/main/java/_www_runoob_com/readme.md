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
     