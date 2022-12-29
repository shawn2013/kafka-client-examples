package com.demo.asynchronous;

import java.util.*;

import com.demo.common.PropertiesUtil;
import org.apache.kafka.clients.producer.*;

public class AsynchronousProducer {

    public static void main(String[] args) throws Exception {
        String topicName = "AsynchronousProducerTopic";
        String key = "Key1";
        String value = "Value-1";

        Properties props = PropertiesUtil.getProperties();

        Producer<String, String> producer = new KafkaProducer<>(props);

        ProducerRecord<String, String> record = new ProducerRecord<>(topicName, key, value);

        System.out.println("Send message:" + record.value());
        producer.send(record, new MyProducerCallback());
        System.out.println("com.demo.asynchronous.AsynchronousProducer call completed");
        producer.close();

    }

}

class MyProducerCallback implements Callback {

    @Override
    public void onCompletion(RecordMetadata recordMetadata, Exception e) {
        if (e != null)
            System.out.println("com.demo.asynchronous.AsynchronousProducer failed with an exception");
        else
            System.out.println("com.demo.asynchronous.AsynchronousProducer call Success:");
    }
}
