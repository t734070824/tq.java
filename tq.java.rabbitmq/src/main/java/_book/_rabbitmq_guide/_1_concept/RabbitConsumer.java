package _book._rabbitmq_guide._1_concept;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * 消费者客户端
 * @author 734070824@qq.com
 * @date 2018/8/29 10:11
 */
public class RabbitConsumer {

    private static final String QUEUE_NAME = "demo.tangqing";
    private static final String IP_ADDRESS = "192.168.7.190";
    private static final int PORT = 5672;//RabbitMQ 服务端默认端口号为 5672
    private static final String USER = "admin";
    private static final String PASS = "admin";

    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {
        Address[] addresses = new Address[]{new Address(IP_ADDRESS, PORT)};
        ConnectionFactory factory = new ConnectionFactory();
        factory.setUsername(USER);
        factory.setPassword(PASS);
        //创建连接
        Connection connection = factory.newConnection(addresses);
        //创建信道
        Channel channel = connection.createChannel();
        //客户端最多接受未被ack的消息的个数
        channel.basicQos(64);
        DefaultConsumer consumer = new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.err.println(envelope.getDeliveryTag() + "--msg: " + new String(body));
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                channel.basicAck(envelope.getDeliveryTag(), false);
            }
        };
        channel.basicConsume(QUEUE_NAME, consumer);
        channel.basicCancel(consumer.getConsumerTag());
        TimeUnit.SECONDS.sleep(20);
        channel.close();
        connection.close();



    }
}
