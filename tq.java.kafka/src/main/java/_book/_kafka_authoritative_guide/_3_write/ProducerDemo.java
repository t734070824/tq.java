package _book._kafka_authoritative_guide._3_write;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.Properties;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * kafka demo
 * @author 734070824@qq.com
 * @date 2019/1/15 17:01
 */
public class ProducerDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Properties kafkaProps = new Properties();
        kafkaProps.put("bootstrap.servers", "192.168.7.204:9092");
        kafkaProps.put("key.serializer","org.apache.kafka.common.serialization.StringSerializer");
        kafkaProps.put("value.serializer","org.apache.kafka.common.serialization.StringSerializer");
        KafkaProducer<String, String> kafkaProducer = new KafkaProducer<>(kafkaProps);

        //发送
//        ProducerRecord<String, String> record1 = new ProducerRecord<>("Tangqing", "name", "123");
//        kafkaProducer.send(record1);

        //同步发送
//        ProducerRecord<String, String> record2 = new ProducerRecord<>("Tangqing", "uuu", "12312");
//        try {
//            RecordMetadata recordMetadata = kafkaProducer.send(record2).get();
//            System.err.println(recordMetadata);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }
//
//        //异步发送
        ProducerRecord<String, String> record3 = new ProducerRecord<>("Tangqing", "age", "456");
        kafkaProducer.send(record3, new Callback() {
            @Override
            public void onCompletion(RecordMetadata metadata, Exception exception) {
                if (exception != null) {
                    exception.printStackTrace();
                }
                System.err.println(metadata);
            }
        });
        kafkaProducer.close();

        TimeUnit.SECONDS.sleep(5);
    }
}
