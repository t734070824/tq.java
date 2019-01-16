package _book._kafka_authoritative_guide._4_read;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.Properties;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * kafka 分区
 * @author 734070824@qq.com
 * @date 2019/1/15 17:01
 */
public class ProducerPartition {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Properties kafkaProps = new Properties();
        kafkaProps.put("bootstrap.servers", "192.168.7.204:9092");
        kafkaProps.put("key.serializer","org.apache.kafka.common.serialization.StringSerializer");
        kafkaProps.put("value.serializer","org.apache.kafka.common.serialization.StringSerializer");
        KafkaProducer<String, String> kafkaProducer = new KafkaProducer<>(kafkaProps);
        //异步发送
        for (int i = 10001; i < 20000; i++) {
            ProducerRecord<String, String> record3 = new ProducerRecord<>("Tangqing",3, null, i+"");
            kafkaProducer.send(record3, new Callback() {
                @Override
                public void onCompletion(RecordMetadata metadata, Exception exception) {
                    if (exception != null) {
                        exception.printStackTrace();
                    }
                    System.err.println(metadata);
                }
            });
        }

        kafkaProducer.close();

        TimeUnit.SECONDS.sleep(5);
    }
}
