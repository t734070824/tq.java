2018-09-28

## 问题
1. Nginx安装完成后, 宿主机网页无法访问
    - 防火墙的问题
    - Centos7
        - systemctl stop firewalld
        - 解决
    - TODO
    
2. Nginx相当于把中间的网线掐断, 然后自己连接两方
    - 那么 Nginx 是如何将返回的消息准确的送给Client
        - Map?
        - 唯一识别码?