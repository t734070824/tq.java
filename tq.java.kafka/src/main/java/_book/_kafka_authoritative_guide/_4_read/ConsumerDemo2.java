package _book._kafka_authoritative_guide._4_read;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Collections;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * 消费者 demo
 * @author 734070824@qq.com
 * @date 2019/1/16 14:54
 */
public class ConsumerDemo2 {
    public static void main(String[] args) throws InterruptedException {
        Properties kafkaProps = new Properties();
        kafkaProps.put("bootstrap.servers", "192.168.7.204:9092");
        kafkaProps.put("group.id", "Test_3");
        kafkaProps.put("key.deserializer","org.apache.kafka.common.serialization.StringDeserializer");
        kafkaProps.put("value.deserializer","org.apache.kafka.common.serialization.StringDeserializer");
        kafkaProps.put("auto.offset.reset","latest");

        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(kafkaProps);
        consumer.subscribe(Collections.singletonList("Tangqing"));

        try{

            int num = 0;
            while (true){
                ConsumerRecords<String, String> poll = consumer.poll(10);
                for (ConsumerRecord<String, String> record : poll) {
                    System.err.println(record.topic()+"--" +record.partition()
                            +"--"+record.offset()+"--"+record.key()+"--"+record.value());
                    num++;
                }
                System.err.println(num);
                TimeUnit.SECONDS.sleep(1);
            }


        }finally {
            consumer.close();
        }

    }
}
