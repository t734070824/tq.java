2019-07-26

## 滑动窗口 zero

### 通信过程 : 事件触发(event trigger) ET, 定时器触发(timer trigger) TT
1. ET
    - A 主动发起 TCP 连接 SYN, 
2. TT
    - SYN 丢失
    - TCP 缓存用户的连接指令, 启动重传定时器, 定时器超时, 无需A的干预, TCP自动重传连接指令
3. ET
    - B 接收到 A 的连接请求
    - 发 SYN + ACK
4. TT
    - B 启动重传定时器 超时触发 重发 SYN + ACK
    - 收到 ACK, 关闭定时器
5. ET
    - A 收到 B 的 SYN + ACK
    - 动作
        - 关闭定时器
        - 发送 ACK
        - TCP -- established
        - 不需要启动重传定时器, 防止 无限循环下去
        
### 重传机制
1. 应用层提交给 TCP 数据 ET, 触发
    - 发送数据, 并缓冲数据
    - 为数据启动 重传定时器
2. 如果接收到ACK
    - 关闭定时器
    - 释放缓存
3. 定时器超时没有接收到ACK, 定时器触发
    - 重传数据
    - 记录重传次数
4. 如果重传次数满, 事件触发
    - reset 或者 关闭TCP 连接
    - 通知 应用层出错


### zero window
1. B --> A, window size = 0, A触发动作
    - 启动探测定时器(persistent timer)
2. PT超时之前 接收到 B.window size > 0, ET
    - 关闭PT
    - 有数据则继续发送数据
    - 更新自己的滑动窗口右侧
3. PT超时之前没有收到 B 的window size 更新, TT
    - 发送一个 byte 合法数据(滑动窗口内)或者 非法数据(滑动窗口外)
    - 刷新定时器, 
    - 记录超时次数
4. 超时次数达到上限, ET
    - reset 或者 关闭 TCP 连接
    - 通知应用层错误以及描述

    
