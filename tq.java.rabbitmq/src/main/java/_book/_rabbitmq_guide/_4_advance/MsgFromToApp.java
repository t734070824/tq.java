package _book._rabbitmq_guide._4_advance;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * 消息何去何从
 * @author 734070824@qq.com
 * @date 2018/8/29 16:39
 */
public class MsgFromToApp {
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
        channel.addReturnListener(new ReturnListener() {
            @Override
            public void handleReturn(int replyCode, String replyText, String exchange, String routingKey,
                                     AMQP.BasicProperties properties, byte[] body) throws IOException {
                String msg = new String(body);
                System.err.println("return : " + msg);
            }
        });
        channel.basicPublish(EXCHANGE_NAME, "", true,
                MessageProperties.PERSISTENT_TEXT_PLAIN,
                "mandatory test".getBytes());

        TimeUnit.SECONDS.sleep(5);
        channel.close();
        connection.close();
    }
}
