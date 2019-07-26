2019-07-26

## 镜像如何生成

### 镜像层
1. Dockerfile 中的每个指令执行后都会产生一个新的镜像层
2. 一个新的镜像层
    - 建立在上一层的镜像启动容器
    - 然后执行Dockerfile指令
    - 保存为一个新的镜像
3. **Dockerfile指令执行成功之后, 中间使用使用过的那个容器就会被删除, 除非提供了 --rm=false**
4. **如果需要在启动容器的时候同时运行一个服务或者进程, 必须从 ENTRYPOINT 或者 CMD 指令中启动**
5. 当构建失败的时候, 可以把失败前的那个层启动起来, 利于测试

### 缓存
1. 加快构建速度, 缓存每一层的镜像

### 基础镜像


### Dockerfile 指令
1. add
    - 从构建环境的上下文或者远程URL复制文件到镜像中
    - 最好使用 copy
2. CMD
    - 容器启动时 执行指定的的指令
    - 会被 docker run 命令覆盖
    - **定义多个 CMD, 只有最后一个生效**
3. copy
    - 用于从构建环境的上下文复制文件到 镜像中
4. entrypoint
    - 设置一个在容器启动时运行的可执行文件
    - 通常用于提供 "启动" 脚本
5. env
    - 设置镜像的环境变量
5. expose
    - 向docker 表示该容器将会有一个进程监听所指定的端口
    - -p
6. from
    - 设置 Dockerfile 使用的基础镜像
    - **必须为 Dockerfile 的第一条指令**
7. maintainer
    - 作者
8. onbuild
    - 指定当镜像被用作另一个镜像的基础镜像时将会执行的指令
9. run
    - 在容器内执行指定的指令, 并保存结果
10. User
11. Volume
    - 指定为数据券的文件或目录
12. workdir
    - 对任何后续的 RUN、CMD、ENTRYPOINT、ADD 或 COPY 指令设置工作目录。
    - 这个指令可多次使用。
    - 支持使用相对路径，按上次定义的 WORKDIR 解析。

### 容器与世界相连
1. -p

### 容器互联
1. docker run --link container_name:alias image cmd

### 数据券
1. 一个目录或文件
2. 只是在主机上被绑定挂载 到容器的一个普通目录
3. 三种方式
    - docker run -it --name xxx -h hostname **-v container_dir** image cmd 
    - dockerfile -- volume container_dir
4. 在 Dockerfile 中设置数据券的权限
    - dockerfile 中 volume 指令 **之后** 的所有指令 **不可以** 对该数据券 有任何的修改
    - eg: **不会有预期的后果**
        - from debian:latest
        - run useradd foo
        - volume /data
        - run touch /data/x
        - run chown -R foo:foo /data