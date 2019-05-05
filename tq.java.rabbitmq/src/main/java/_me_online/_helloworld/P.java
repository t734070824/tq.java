package _me_online._helloworld;

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
        factory.setHost("192.168.1.17");
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
        int baseNo = 1000;
        int[] num = {12,500,300,40,20,56,455,326,124,12,56,89,45};
        for (int i2 = 0; i2 < 1; i2++) {
            for (int i : num){
                for (int j = 0; j < i; j++) {
                    baseNo++;
                    String base = "{'UserID':156992664,'OrderNo':'59e562a686a25e3d50bc380e'," +
                            "'CouponNo':'1110512346202184788" + baseNo +  "','CouponBatchID':82," +
                            "'CouponBatchName':'六安麻将-2个欢乐币券','CouponClassID':11," +
                            "'CouponTypeID':10,'Price':20.0000,'PriceUnit':2,'MinConsume':0.0000,'OwnUnixTime':1508205225861,'StartUnixTime':1508205225767,'EndUnixTime':1508774399001,'OperationTypeID':10,'OperationInfoID':1351001,'ActivityName':'六安麻将分享任务【房卡】','AppID':153,'OperationAppID':135,'GameCode':''}";
                    //      发送消息到队列中
                    channel.basicPublish("ctcoupon.sendgrantcoupondatatodc.topic", "sendgrantcoupondatatodc.#", null, base.getBytes("UTF-8"));
                }

            }

        }

        System.err.println(baseNo - 1000);
//      关闭频道和连接
        channel.close();
        connection.close();
    }
}
