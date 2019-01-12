2019-01-12

## RabbitMQ 集群搭建中的问题
1. 修改主机名
    - 一定要修改
    - 添加 hosts
    - 添加节点的时候需要 rabbit@hostname
    - reboot
2. Erlang Cookie
    - 地址 /var/lib/rabbitmq/.erlang.cookies
    - 所有的节点需要同一份
    - 记得修改为原来的权限 400
3. 用户
    - 添加集群完成后, 主节点的用户名需要重新设置
4. rabbitmq-server -detached
    - 使用此命令运行节点
5. 从节点步骤
    - rabbitmqctl stop_app
    - rabbitmqctl reset
    - rabbitmqctl join_cluster rabbit@rabbitmq_node3
    - rabbitmqctl start_app
