package _book._rabbitmq_guide._4_advance;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Basic.Qos 的使用对于拉模式的消费方式无效.
 * @author 734070824@qq.com
 * @date 2018/11/29 14:48
 */
public class Qos {

    private static final String QUEUE_NAME = "queue_demo";
    private static final String IP_ADDRESS = "192.168.101.167";
    private static final int PORT = 5672;//RabbitMQ 服务端默认端口号为 5672
    private static final String USER = "datacenter";
    private static final String PASS = "123";

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
        channel.basicQos(10);
        for (int i = 0; i < 100; i++) {
            GetResponse getResponse = channel.basicGet(QUEUE_NAME, false);
            System.err.println(new String(getResponse.getBody()));
        }

        TimeUnit.SECONDS.sleep(20);
        channel.close();
        connection.close();



    }
}
