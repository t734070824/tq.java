2017-11-28
### 安装
    1)必须要python2的pip
    2)pip install supervisor
    3)输出配置文件  echo_supervisord_conf  > /etc/supervisord.conf
    4)更改配置文件    vi   /etc/supervisord.conf
    5)--包含  files =  /etc/supervisor.conf.d/*.conf
    6)启动进程 supervisord -c /etc/supervisord.conf
    7)cd /etc
    8)mkdir supervisor.conf.d
    9)cd   supervisor.conf.d/
    10)touch etl.conf
    11)vi etl.conf
### sudo
	1)sudo pip install supervisor
    2)sudo sh -c "echo_supervisord_conf  > /etc/supervisord.conf"


### 2017-12-28 问题总结
1. /tmp/supervisor.sock文件不存在(可能重启了服务器)
2. supervisord(造成启动了两个supervisor)
3. jps(4个 应该是2个)
4. kill(结果kill掉之后,用重新生成了)
5. 修改etl.conf(删除 ``autostart=true autorestart=true``)
6. ps aux|grep super (ps -ef|grep super)
7. kill(2个)
8. kill java
9. supervisord -c /etc/supervisord.conf	


### 2017-12-28 Q
1. 修改 supervisor.conf文件，修改到/var/run/及/var/log/目录
2. **但是 supervisorctl start all 提示 找不到/tmp/supervisor.sock???**
3. http://www.cashqian.net/blog/001472975510127673ea63db9234c4e8293cf43cefcafde000(修复2)
	