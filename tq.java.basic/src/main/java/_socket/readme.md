2018-04-26

## ServerSocket.backlog
1. 服务端socket处理客户端socket连接是需要一定时间的。
2. ServerSocket有一个队列，存放还没有来得及处理的客户端Socket，这个队列的容量就是backlog的含义。
3. 如果队列已经被客户端socket占满了，如果还有新的连接过来，那么ServerSocket会拒绝新的连接。
4. 也就是说backlog提供了容量限制功能，避免太多的客户端socket占用太多服务器资源
5. 摘自:https://blog.csdn.net/aitangyong/article/details/49661907