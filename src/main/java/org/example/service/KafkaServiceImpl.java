package org.example.service;

import org.example.model.Statement;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.example.service.serializers.StatementDeserializer;

import java.util.Collections;
import java.util.Properties;

public class KafkaServiceImpl implements KafkaService {

    Properties kafkaProps;

    public KafkaServiceImpl(){
        kafkaProps = new Properties();
        kafkaProps.put("bootstrap.servers", "kafka:9092");
    }

    @Override
    public void consumeStatement() {
        Properties kafkaProps = new Properties();
        kafkaProps.put("group.id", "groupx");

        kafkaProps.put("bootstrap.servers", "kafka:9092");
        kafkaProps.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        kafkaProps.put("value.deserializer", StatementDeserializer.class);

        KafkaConsumer<String, Statement> kafkaConsumer = new KafkaConsumer<String, Statement>(kafkaProps);

        kafkaConsumer.subscribe(Collections.singletonList("statement"));

        while(true) {

                ConsumerRecords<String, Statement> consumerRecords = kafkaConsumer.poll(100);
                for (ConsumerRecord<String, Statement> record : consumerRecords) {
                    Statement statement = record.value();
//                    if (statement!=null)
//                        mongoDBService.insertStatement(statement);
                }
        }
    }
}
