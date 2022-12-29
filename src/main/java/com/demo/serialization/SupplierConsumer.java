package com.demo.serialization;

import java.util.*;

import com.demo.common.PropertiesUtil;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.ConsumerRecord;

public class SupplierConsumer {

    public static void main(String[] args) throws Exception {

        String topicName = "SupplierTopic";
        String groupName = "SupplierTopicGroup";

        Properties props = PropertiesUtil.getProperties();
        props.put("group.id", groupName);
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "com.demo.serialization.SupplierDeserializer");


        KafkaConsumer<String, Supplier> consumer = new KafkaConsumer<>(props);
        consumer.subscribe(Arrays.asList(topicName));

        System.out.println("Suppplier Consumer Started");
        try {
            while (true) {
                ConsumerRecords<String, Supplier> records = consumer.poll(100);
                for (ConsumerRecord<String, Supplier> record : records) {
                    System.out.println("Consume message: id= " + String.valueOf(record.value().getID())
                            + " Name = " + record.value().getName()
                            + " StartDate = " + record.value().getStartDate().toString());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
