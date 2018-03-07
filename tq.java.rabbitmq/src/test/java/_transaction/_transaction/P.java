package _transaction._transaction;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.TimeoutException;

public class P {

    private final static String QUEUE_NAME = "hello";

    public static void main(String[] args) throws IOException, TimeoutException, NoSuchAlgorithmException, KeyManagementException, URISyntaxException, InterruptedException {
        ConnectionFactory factory = new ConnectionFactory();
//        factory.setHost("127.0.0.1");
//        factory.setPort(9026);
//
//        factory.setUsername("admin");
//        factory.setPassword("123456");

        factory.setHost("192.168.1.19");
        factory.setPort(5672);
        factory.setUsername("tangq");
        factory.setPassword("tangq");

//      创建一个新的连接
        Connection connection = factory.newConnection();
//      创建一个频道
        Channel channel = connection.createChannel();
//      声明一个队列 -- 在RabbitMQ中，队列声明是幂等性的（一个幂等操作的特点是其任意多次执行所产生的影响均与一次执行的影响相同），
//      也就是说，如果不存在，就创建，如果存在，不会对已经存在的队列产生任何影响。
//        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
//        channel.
        channel.txSelect();
        channel.basicPublish("tangq.topic", "tangq.test.1", null, "tangqing".getBytes("UTF-8"));
        channel.txCommit();
//      关闭频道和连接
        channel.close();
        connection.close();
    }
}
