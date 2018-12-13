package _scene._stock;

import org.apache.thrift.TMultiplexedProcessor;
import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.server.TNonblockingServer;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TNonblockingServerSocket;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TTransportException;
import org.slf4j.LoggerFactory;

import java.util.logging.Logger;

/**
 * @author 734070824@qq.com
 * @date 2018/12/13 16:59
 */
public class MainServer {
    public static void main(String[] args) throws TTransportException {
        int port= 9000 ;
        // *) 传输层(Transport), 设置监听端口为9000
        TServerSocket serverTransport = new TServerSocket(port);

        // *) 协议层
        TBinaryProtocol.Factory protocolFactory = new TBinaryProtocol.Factory(true, true);
        // *) 处理层(Processor)
        StockServiceImpl handler = new StockServiceImpl();
        StockService.Processor<StockServiceImpl> processor = new StockService.Processor<StockServiceImpl>(handler);

        // *) 服务层(Server)
        TServer server = new TThreadPoolServer(
                new TThreadPoolServer.Args(serverTransport)
                        .protocolFactory(protocolFactory)
                        .processor(processor));

        // *) 启动监听服务
        server.serve();
    }
}
