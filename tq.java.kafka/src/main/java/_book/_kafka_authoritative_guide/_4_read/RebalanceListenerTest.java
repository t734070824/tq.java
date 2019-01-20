package _book._kafka_authoritative_guide._4_read;

import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.junit.Test;

import java.util.Collections;
import java.util.Properties;

/**
 * @author 734070824@qq.com
 * @date 2019/1/20 13:45
 */
public class RebalanceListenerTest {


    public static void main(String[] args) {
        Properties kafkaProps = new Properties();
        kafkaProps.put("bootstrap.servers", "192.168.7.204:9092");
        kafkaProps.put("group.id", "Test_3");
        kafkaProps.put("key.deserializer","org.apache.kafka.common.serialization.StringDeserializer");
        kafkaProps.put("value.deserializer","org.apache.kafka.common.serialization.StringDeserializer");

        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(kafkaProps);
        consumer.subscribe(Collections.singletonList("Tangqing"));
        RebalanceListenerDemo demo = new RebalanceListenerDemo(consumer);
        demo.consumer();
    }
}
