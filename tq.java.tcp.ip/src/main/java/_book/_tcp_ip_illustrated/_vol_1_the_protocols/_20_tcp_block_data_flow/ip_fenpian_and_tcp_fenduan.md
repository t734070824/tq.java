2018-12-10

## IP分片 和 TCP 分段

### MTU
1. 最大传输单元（Maximum Transmission Unit，MTU）是指一种通信协议的某一层上面所能通过的最大数据包大小（以字节为单位）。 
   - 例如：以太网MTU值为1500字节，802.3的MTU值为1492字节。

### MSS
1. 最大分段长度（Maximum Segment Size）**是TCP协议头部的一个选项**，MSS是指TCP报文能够携带的最大数据长度，单位为字节

### IP分片实例
1. ping xxx.xxx.xxx.xxx(ip) -l 5000 -n 1

### MSS与TCP分片
1. **TCP可以避免被发送方分片，它主动把数据分成小段再交给网络层**
2. **最大的分段大小（MSS）相当于MTU刨去IP头和TCP头之后的代销，所以一个MSS恰好装进MTU中。**

### UDP
1. UDP没有MSS的概念
2. **其数据包全部交给网络层，所以可能被分片**