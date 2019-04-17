package _me;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * @author 734070824@qq.com
 * @date 2019/4/16 10:17
 */
public class P {



    static {
        String fsPath=System.getProperty("user.dir");
        System.setProperty("java.security.auth.login.config", fsPath+"/target/classes/kafka_client_jaas.conf");
    }

    public static void main(String[] args) throws InterruptedException {
        Properties kafkaProps = new Properties();
        kafkaProps.put("bootstrap.servers", "192.168.101.130:9092,192.168.101.131:9092,192.168.101.132:9092");
        kafkaProps.put("key.serializer","org.apache.kafka.common.serialization.StringSerializer");
        kafkaProps.put("value.serializer","org.apache.kafka.common.serialization.StringSerializer");
        kafkaProps.put("sasl.mechanism","PLAIN");
        kafkaProps.put("security.protocol","SASL_PLAINTEXT");
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

        int num = 0;
        while (true){
            num++;
            String value ="{'num':"+num+",\"UserID\":681289,\"GameID\":0,\"OperationID\":300701,\"Deposit\":-3569,\"Balance\":8104,\"IP\":\"192.168.9.24\",\"CreateDate\":20190111,\"CreateTime\":183822,\"Description\":\"0\",\"GuId\":\"e2f87b66-1151-48d2-bb6f-1ff5d3e77f49\",\"OperationTypeId\":7,\"GameDiff\":0,\"TblType\":1,\"SmallGameID\":0,\"GsClientLinkID\":null,\"ThroughGameID\":0,\"UniqueID\":\"C1D26E7FC1EC0F0E9AE46FA59530D95F\"}";
            ProducerRecord<String, String> record3 = new ProducerRecord<>("Tangqing-SilverLog-safeboxlog", value);

            kafkaProducer.send(record3, new Callback() {
                @Override
                public void onCompletion(RecordMetadata metadata, Exception exception) {
                    if (exception != null) {
                        exception.printStackTrace();
                    }
                    System.err.println(metadata);
                }
            });
            TimeUnit.MILLISECONDS.sleep(10);
        }


    }
}
