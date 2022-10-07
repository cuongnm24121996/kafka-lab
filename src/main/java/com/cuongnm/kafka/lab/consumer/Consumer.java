package com.cuongnm.kafka.lab.consumer;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import static com.cuongnm.kafka.lab.utils.Constant.DEFAULT_TOPIC;

@Slf4j
@Service
public class Consumer {
    @KafkaListener(topics = DEFAULT_TOPIC, groupId = "group_id")
    public void consume(ConsumerRecord<String, Object> consumerRecord) {
        log.info(String.format("#### -> Consumed message with key %s -> %s", consumerRecord.key(), consumerRecord.value()));
    }
}
