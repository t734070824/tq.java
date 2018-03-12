package _containertype;

import org.apache.thrift.TException;
import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.server.TNonblockingServer;
import org.apache.thrift.server.TServer;
import org.apache.thrift.transport.TNonblockingServerSocket;

import java.util.Map;

/**
 * @author 734070824@qq.com
 * @date 2018/3/10 14:25
 */
public class DemoServiceImpl implements DemoService.Iface{
    @Override
    public int demoMethod(String param1, Parameter param2, Map<String, String> param3) throws TException {
        return 0;
    }

    public static void main(String[] args){
        TNonblockingServerSocket socket;
        try {
            socket = new TNonblockingServerSocket(9090);
            TNonblockingServer.Args options = new TNonblockingServer.Args(socket);
            TProcessor processor = new DemoService.Processor(new DemoServiceImpl());
            options.processor(processor);
            options.protocolFactory(new TCompactProtocol.Factory());
            TServer server = new TNonblockingServer(options);
            server.serve();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
