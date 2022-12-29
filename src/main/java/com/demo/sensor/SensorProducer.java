package com.demo.sensor;

import java.util.*;

import com.demo.common.PropertiesUtil;
import org.apache.kafka.clients.producer.*;

public class SensorProducer {

    public static void main(String[] args) throws Exception {

        String topicName = "SensorTopic";

        Properties props = PropertiesUtil.getProperties();
        props.put("partitioner.class", "com.demo.sensor.SensorPartitioner");
        props.put("speed.sensor.name", "TSS");

        Producer<String, String> producer = new KafkaProducer<>(props);

        for (int i = 0; i < 10; i++)
            producer.send(new ProducerRecord<>(topicName, "SSP" + i, "500" + i));

        for (int i = 0; i < 10; i++)
            producer.send(new ProducerRecord<>(topicName, "TSS", "500" + i));

        producer.close();

        System.out.println("com.demo.sensor.SensorProducer Completed.");
    }
}
