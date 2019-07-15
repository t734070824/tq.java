2019-07-09

## 思考
1. 资源分割
    - TODO
2. 资源调度
    - TODO
    
1. run /bin/bash??
    - TODO
    - 中的/bin/bash的作用是因为docker后台必须运行一个进程，否则容器就会退出，在这里表示启动容器后启动bash。 ??
        - TODO
    - 为了方便后续与容器进行交互操作， 统一设定启动命令为 /bin/bash
2. --link
    - 就算我去link, 容器中的进程如何知道我怎么连接? 比如 连接DB
        - TODO
3. redis 
    - bind
    - protected-mode