2018-02-02


## 概述

### 分层
1. TCP在不可靠的IP层提供一个可靠的运输层
    - 超时重传
    - 发送和接受端到端的确认分组等


### 互联网地址
1. IP地址具有一定的结构, 分为五类
2. 区分各类地址的最简单的方法就是看他第一个十进制整数
3. 计算方法(以A类为例)
    - 0 + 7bit 网络号 + 24 为 主机号
    - 0 000 0000 0000 0000 0000 0000 0000 0000 --- 0 111 1111 1111 1111 1111 1111 1111 1111 
    - 0.0.0.0 --- 127.255.255.255 

![](https://github.com/t734070824/tq.java/blob/master/tq.java.tcp.ip/src/main/java/_book/_tcp_ip_illustrated/_vol_1_the_protocols/_1_summarize/1.png?raw=true)

![](https://github.com/t734070824/tq.java/blob/master/tq.java.tcp.ip/src/main/java/_book/_tcp_ip_illustrated/_vol_1_the_protocols/_1_summarize/2.png?raw=true)

### 封装
1. 由于TCP、UDP、ICMP和IGMP都要向IP传送数据，因此IP必须在
   生成的IP首部中加入某种标识，以表明数据属于哪一层。为此，IP在首部中存入一个长度为
   8bit的数值，称作协议域。**1表示为ICMP协议，2表示为IGMP协议，6表示为TCP协议，17表
   示为UDP协议**