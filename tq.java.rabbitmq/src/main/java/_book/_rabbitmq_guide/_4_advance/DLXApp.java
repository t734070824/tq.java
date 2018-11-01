package _book._rabbitmq_guide._4_advance;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * 消息何去何从
 * @author 734070824@qq.com
 * @date 2018/8/29 16:39
 */
public class DLXApp {
    private static final String EXCHANGE_NAME = "exchange_demo";
    private static final String ROUTING_KEY = " routingkey_demo";
    private static final String QUEUE_NAME = "queue_demo";
    private static final String IP_ADDRESS = "192.168.101.167";
    private static final int PORT = 5672;//RabbitMQ 服务端默认端口号为 5672

    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(IP_ADDRESS);
        factory.setPort(PORT);
        factory.setUsername("datacenter");
        factory.setPassword("123");
        //创建连接
        Connection connection = factory.newConnection();
        //创建信道

        Channel channel = connection.createChannel();
        channel.exchangeDeclare("exchange.dlx", "direct");
        channel.exchangeDeclare("exchange.normal", "fanout", true);
        Map<String, Object> arg = new HashMap<>();
        arg.put("x-message-ttl", 10000);
        arg.put("x-dead-letter-exchange", "exchange.dlx");
        arg.put("x-dead-letter-routing-key", "routingkey");
        channel.queueDeclare("queue.normal", true, false, false, arg);
        channel.queueBind("queue.normal", "exchange.normal", "");
        channel.queueDeclare("queue.dlx", true, false, false, null);
        channel.queueBind("queue.dlx", "exchange.dlx", "routingkey");

        channel.basicPublish("exchange.normal", "rk", MessageProperties.PERSISTENT_TEXT_PLAIN, "dlx".getBytes());

        channel.close();
        connection.close();

    }
}
