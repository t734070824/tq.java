package _book._kafka_authoritative_guide._4_read;

import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.errors.WakeupException;
import org.junit.Test;

import java.util.*;

/**
 * 再均衡监听器
 * @author 734070824@qq.com
 * @date 2019/1/20 13:19
 */
public class RebalanceListenerDemo {





    private KafkaConsumer<String, String> consumer = null;

    public RebalanceListenerDemo(KafkaConsumer<String, String> consumer) {
        this.consumer = consumer;
    }

    // TopicPartition 的 hashcode 和 equal 已重写
    private Map<TopicPartition, OffsetAndMetadata> currentOffsets = new HashMap<>();


    public void consumer(){
        try{
            consumer.subscribe(Collections.singletonList("Tangqing"), new HandlerRebalance());
            while (true){
                ConsumerRecords<String, String> poll = consumer.poll(100);
                for (ConsumerRecord<String, String> record : poll) {
                    System.err.println(record.topic()+"--" +record.partition()
                            +"--"+record.offset()+"--"+record.key()+"--"+record.value());
                    currentOffsets.put(new TopicPartition(record.topic(), record.partition()),
                            new OffsetAndMetadata(record.offset() + 1, "no metedata"));

                }
                consumer.commitAsync(currentOffsets, null);
            }
        } catch (WakeupException e){
            //忽略异常, 正在关闭消费者
        } catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                consumer.commitSync(currentOffsets);
            }finally {
                consumer.close();
            }
        }

    }

    private class HandlerRebalance implements ConsumerRebalanceListener{

        @Override
        public void onPartitionsRevoked(Collection<TopicPartition> partitions) {
            System.err.println("Lost partitions in rebalance, committing current offset:" + currentOffsets);
            consumer.commitSync(currentOffsets);
        }

        @Override
        public void onPartitionsAssigned(Collection<TopicPartition> partitions) {
            System.err.println(partitions);
        }
    }


}
