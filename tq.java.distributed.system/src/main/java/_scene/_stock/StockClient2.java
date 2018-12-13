package _scene._stock;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author 734070824@qq.com
 * @date 2018/12/13 17:03
 */
public class StockClient2 {

    public static void main(String[] args) throws TException {
        // *) 传输层
        TTransport transport = new TSocket("localhost", 9000);
        transport.open();
        // *) 协议层, 与服务端对应
        TProtocol protocol = new TBinaryProtocol(transport);
        // *) 创建RPC客户端
        StockService.Client client = new StockService.Client(protocol);
        int stock = client.getStock(1);
        System.err.println(stock);
//        client.setStock(1, 1000);

        // *) 关闭句柄
        transport.close();

    }
}
