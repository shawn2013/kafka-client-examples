package com.demo.simple;

import com.demo.common.PropertiesUtil;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Arrays;
import java.util.Properties;

public class SimpleConsumer {

    public static void main(String[] args) throws Exception{

        String topicName = "SimpleProducerTopic";
        String groupName = "SimpleTopicGroup";

        Properties props = PropertiesUtil.getProperties();
        props.put("group.id", groupName);
        props.put("enable.auto.commit", "false");

        KafkaConsumer<String, String> consumer = null;
        try {
            consumer = new KafkaConsumer<>(props);
            consumer.subscribe(Arrays.asList(topicName));

            while (true){
                ConsumerRecords<String, String> records = consumer.poll(100);
                for (ConsumerRecord<String, String> record : records){
                    System.out.println(record.value());
                }
                consumer.commitAsync();
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            consumer.commitSync();
            consumer.close();
        }
    }
}
