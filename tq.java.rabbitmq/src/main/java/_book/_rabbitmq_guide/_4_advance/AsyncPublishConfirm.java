package _book._rabbitmq_guide._4_advance;

import com.rabbitmq.client.*;
import com.rabbitmq.client.impl.DefaultExceptionHandler;

import java.io.IOException;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * 异步生产者确认机制
 * @author 734070824@qq.com
 * @date 2018/11/29 14:04
 */
public class AsyncPublishConfirm {


    private static final String EXCHANGE_NAME = "exchange_demo";
    private static final String ROUTING_KEY = " routingkey_demo";
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
        factory.setExceptionHandler(new DefaultExceptionHandler(){
            @Override
            public void handleConfirmListenerException(Channel channel, Throwable exception) {
                System.out.println("=====消息确认发生异常=======");
                exception.printStackTrace();
            }
        });

        //创建连接
        Connection connection = factory.newConnection(addresses);
        //创建信道
        Channel channel = connection.createChannel();
        //客户端最多接受未被ack的消息的个数
        channel.basicQos(64);
        channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, ROUTING_KEY);
        String msg = "tangqing";
        channel.confirmSelect();
        // 并发场景
        ConcurrentSkipListSet confirmSet = new ConcurrentSkipListSet();
        channel.addConfirmListener(new ConfirmListener() {
            @Override
            public void handleAck(long deliveryTag, boolean multiple) throws IOException {
                System.err.println("Ack, SeqNo: " + deliveryTag + ", + multiple: " + multiple);
                if(multiple){
                    confirmSet.headSet(deliveryTag-1).clear();
                }else{
                    confirmSet.remove(deliveryTag);
                }
            }

            @Override
            public void handleNack(long deliveryTag, boolean multiple) throws IOException {
                if(multiple){
                    confirmSet.headSet(deliveryTag-1).clear();
                }else{
                    confirmSet.remove(deliveryTag);
                }

                //TODO 处理消息重发的场景
            }
        });

        //一直发消息
        while (true){
            long nextPublishSeqNo = channel.getNextPublishSeqNo();
            channel.basicPublish(EXCHANGE_NAME, ROUTING_KEY,
                    MessageProperties.PERSISTENT_TEXT_PLAIN,
                    msg.getBytes());
            confirmSet.add(nextPublishSeqNo);
//            TimeUnit.SECONDS.sleep(1);
        }
    }
}
