package com.demo.simple;

import java.util.*;

import com.demo.common.PropertiesUtil;
import org.apache.kafka.clients.producer.*;

public class SimpleProducer {

    public static void main(String[] args) throws Exception {

        String topicName = "SimpleProducerTopic";
        String key = "Key-1";
        String value = "Value-1";

        Properties props = PropertiesUtil.getProperties();
        Producer<String, String> producer = new KafkaProducer<>(props);

        ProducerRecord<String, String> record = new ProducerRecord<>(topicName, key, value);
        producer.send(record);
        System.out.println("produce message:" + record.value());
        producer.close();
        System.out.println("com.demo.simple.SimpleProducer Completed.");
    }
}