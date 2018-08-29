package _book._rabbitmq_guide._3_client_develop;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * 消费
 * @author 734070824@qq.com
 * @date 2018/8/29 16:06
 */
public class ConsumerMsg {
    private static final String EXCHANGE_NAME = "exchange_demo";
    private static final String ROUTING_KEY = " routingkey_demo";
    private static final String QUEUE_NAME = "queue_demo";
    private static final String IP_ADDRESS = "192.168.101.167";
    private static final int PORT = 5672;//RabbitMQ 服务端默认端口号为 5672

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(IP_ADDRESS);
        factory.setPort(PORT);
        factory.setUsername("datacenter");
        factory.setPassword("123");
        //创建连接
        Connection connection = factory.newConnection();
        //创建信道
        Channel channel = connection.createChannel();
        boolean autoAck = false;
        channel.basicConsume(QUEUE_NAME, autoAck, "myTag", new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                envelope.getRoutingKey();
                channel.basicAck(envelope.getDeliveryTag(), false);
            }
        });

    }
}
