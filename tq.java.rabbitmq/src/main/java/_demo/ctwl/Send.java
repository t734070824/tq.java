package _demo.ctwl;

import java.util.concurrent.atomic.AtomicInteger;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import ct.dc.libinfrastructure.EncryptUtils;

public class Send {
	
	public static void main(String[] args) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("192.168.1.17");
        factory.setUsername("wangzs");
        factory.setPassword(EncryptUtils.aesDecrypt("fhFfcdh2S0SJF3Die6fSYQ==", "Y3231oU_8#k3429="));
        

		AtomicInteger num = new AtomicInteger(0); 
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
				Connection connection = factory.newConnection();
				Channel channel = connection.createChannel();
				channel.queueDeclare("test_queue_01", true, false, false, null);
				while (true) {
					String message = "Hello World!" + (num.getAndIncrement());
					byte[] bytes;
					
						bytes = message.getBytes("UTF-8");
						channel.basicPublish("kongxg.topic", "test_queue_01", null, bytes);
					
						System.err.println(num.get());
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}}).start();
		
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
				Connection connection = factory.newConnection();
				Channel channel = connection.createChannel();
				channel.queueDeclare("test_queue_01", true, false, false, null);
				while (true) {
					String message = "Hello World!" + (num.getAndIncrement());
					byte[] bytes;
					
						bytes = message.getBytes("UTF-8");
						channel.basicPublish("kongxg.topic", "test_queue_01", null, bytes);
					
					System.err.println(num.get());
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}}).start();
		
    }

}
