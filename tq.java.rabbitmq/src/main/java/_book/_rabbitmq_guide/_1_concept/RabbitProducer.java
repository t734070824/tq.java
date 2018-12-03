package _book._rabbitmq_guide._1_concept;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * 生产者客户端
 * @author 734070824@qq.com
 * @date 2018/8/29 10:11
 */
public class RabbitProducer {

//    private static final String EXCHANGE_NAME = "exchange_demo";
//    private static final String ROUTING_KEY = " routingkey_demo";
//    private static final String QUEUE_NAME = "queue_demo";
//    private static final String IP_ADDRESS = "192.168.101.167";
//    private static final String USER = "datacenter";
//    private static final String PASS = "123";
//    private static final int PORT = 5672;//RabbitMQ 服务端默认端口号为 5672

//    private static final String EXCHANGE_NAME = "demo.tq";
//    private static final String ROUTING_KEY = " tangqing";
//    private static final String QUEUE_NAME = "demo.tangqing";
//    private static final String IP_ADDRESS = "192.168.7.190";
//    private static final String USER = "admin";
//    private static final String PASS = "admin";
//    private static final int PORT = 5672;//RabbitMQ 服务端默认端口号为 5672

/*    private static final String EXCHANGE_NAME = "ctcombinsys.topic";
    private static final String ROUTING_KEY = "exchangesys.userticketslog.#";
    private static final String QUEUE_NAME = "demo.tangqing";
    private static final String IP_ADDRESS = "192.168.1.17";
    private static final String USER = "tangq";
    private static final String PASS = "tangq";
    private static final int PORT = 5672;//RabbitMQ 服务端默认端口号为 5672*/

    private static final String EXCHANGE_NAME = "ctbi.consumersvr.optimize";
    private static final String ROUTING_KEY = "123";
    private static final String QUEUE_NAME = "demo.tangqing";
    private static final String IP_ADDRESS = "192.168.1.17";
    private static final String USER = "tangq";
    private static final String PASS = "tangq";
    private static final int PORT = 5672;//RabbitMQ 服务端默认端口号为 5672

    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(IP_ADDRESS);
        factory.setPort(PORT);
        factory.setUsername(USER);
        factory.setPassword(PASS);
        //创建连接
        Connection connection = factory.newConnection();
        //创建信道
        Channel channel = connection.createChannel();
        //type="direct" 持久化的, 非自动删除的交换器
//        channel.exchangeDeclare(EXCHANGE_NAME, "direct", true, false, null);
        //持久 非排他性 非自动删除
//        channel.queueDeclare(QUEUE_NAME, true, false, false, null);
//        channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, ROUTING_KEY);
//        String msg = "hello world";
        String msg = "{\"LogId\":0,\"UserID\":42678911,\"Number\":2,\"SourceType\":1,\"SourceId\":879,\"SourceSerialNumber\":\"1543559952954000042678920181130_tq\",\"CreateTime\":\"2018-11-30T14:40:54.6621094+08:00\",\"CreateUnixTime\":1543560054662,\"Descript\":\"活动【六安麻将房卡任务】奖励\",\"TicketsLeftNumber\":24,\"ExpiredTime\":20190201,\"GsClientLinkID\":\"160_84e2cd56-5277-4974-8fe4-f55aaa887afa_1543559952751\",\"GsClientData\":{\"GameId\":392,\"GameCode\":\"limk\",\"GameVers\":\"3.7.20181128\",\"RecomGameId\":234,\"RecomGameCode\":\"lagt\",\"RecomGameVers\":\"0.0.0\",\"GroupId\":6,\"Channel\":1000000714,\"HardId\":\"ec6a43a3cd5c0089000000000000000\",\"MobileHardInfo\":{\"ImeiId\":\"869033023527360\",\"WifiId\":\"ec6a43a3cd5c0089\",\"ImsiId\":\"460017126616605\",\"SimSerialNo\":\"89860117836051811683\",\"SystemId\":\"ec6a43a3cd5c0089\"},\"PkgType\":110}}\n";

        for (int i = 0; i < 1000000; i++) {
            channel.basicPublish(EXCHANGE_NAME, ROUTING_KEY,
                    MessageProperties.PERSISTENT_TEXT_PLAIN,
                    msg.getBytes());
        }



        TimeUnit.SECONDS.sleep(10);
        channel.close();
        connection.close();



    }
}
