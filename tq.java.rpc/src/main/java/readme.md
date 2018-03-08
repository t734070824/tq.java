2018-03-08

## RPC

### 远程过程调用带来的问题
1. Call id 映射: 用于明确需要调用的函数
2. 序列化与反序列化: 参数与结果的序列化与反序列化
3. 网络传输: 


### RPC 实现理论模型概念结构
![](https://github.com/t734070824/tq.java/blob/master/tq.java.rpc/src/main/java/1.png?raw=true)
1. RPC 服务端通过 RpcServer 去导出（export）远程接口方法，而客户端通过 RpcClient 去导入（import）远程接口方法。
客户端像调用本地方法一样去调用远程接口方法，RPC 框架提供接口的代理实现，实际的调用将委托给代理 RpcProxy。代理封装调用信息并将调
用转交给 RpcInvoker 去实际执行。在客户端的 RpcInvoker 通过连接器 RpcConnector 去维持与服务端的通道 RpcChannel，并使用 RpcProtocol 
执行协议编码（encode）并将编码后的请求消息通过通道发送给服务端。
2. RPC 服务端接收器 RpcAcceptor 接收客户端的调用请求，同样使用 RpcProtocol执行协议解码（decode）。
3. 解码后的调用信息传递给 RpcProcessor 去控制处理调用过程，最后再委托调用给 RpcInvoker 去实际执行并返回调用结果。