package _book._rabbitmq_guide._3_client_develop;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.TimeoutException;

/**
 * 连接mQ
 * @author 734070824@qq.com
 * @date 2018/8/29 15:20
 */
public class ConnectRabbitMQ {

    private static final String EXCHANGE_NAME = "exchange_demo";
    private static final String ROUTING_KEY = " routingkey_demo";
    private static final String QUEUE_NAME = "queue_demo";
    private static final String IP_ADDRESS = "192.168.101.167";
    private static final int PORT = 5672;//RabbitMQ 服务端默认端口号为 5672
    private static final String USERNAME = "datacenter";
    private static final String PASSWORD = "123";





    public static void main1(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setUsername(USERNAME);
        factory.setPassword(PASSWORD);
//        factory.setVirtualHost(virtualHost) ;
        factory.setHost(IP_ADDRESS);
        factory.setPort(PORT) ;
        Connection conn = factory.newConnection();
    }

    public static void main2(String[] args) throws IOException, TimeoutException, NoSuchAlgorithmException, KeyManagementException, URISyntaxException {
        ConnectionFactory factory =new ConnectionFactory();
        factory.setUri("amqp://userName:password@ipAddress:portNumber/virtualHost");
        Connection conn = factory.newConnection();
//        Connection 接口被用来创建一个 Channel:
        Channel channel = conn.createChannel();
    }
}
