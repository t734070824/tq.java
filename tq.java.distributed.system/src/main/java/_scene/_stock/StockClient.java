package _scene._stock;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TMultiplexedProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author 734070824@qq.com
 * @date 2018/12/13 17:03
 */
public class StockClient {

    public  static AtomicInteger falseNum = new AtomicInteger();

    public static void main(String[] args) {
        ExecutorService service = new ThreadPoolExecutor(10, 10,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>());

        for (int i = 0; i < 100; i++) {
            service.execute(new Runnable() {
                @Override
                public void run() {

                    try {
                        // *) 传输层
                        TTransport transport = new TSocket("localhost", 9000);
                        transport.open();
                        // *) 协议层, 与服务端对应
                        TProtocol protocol = new TBinaryProtocol(transport);
                        // *) 创建RPC客户端
                        StockService.Client client = new StockService.Client(protocol);
                        for (int i = 0; i < 10; i++) {
                            // *) 调用服务
                            int stock = client.getStock(1);
                            if(stock > 1){
                                boolean b = client.setStockWithOld(1, stock - 1, stock);
                                if(!b)falseNum.getAndIncrement();
                            }
                        }

                        // *) 关闭句柄
                        transport.close();
                    } catch (TException e) {
                        e.printStackTrace();
                    }
                }
            });
        }

        service.shutdown();


    }
}
