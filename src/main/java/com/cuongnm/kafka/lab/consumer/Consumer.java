package com.cuongnm.kafka.lab.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import static com.cuongnm.kafka.lab.utils.Constant.DEFAULT_TOPIC;

@Slf4j
@Service
public class Consumer {
    @KafkaListener(topics = DEFAULT_TOPIC, groupId = "group_id")
    public void consume(String message) {
        log.info(String.format("#### -> Consumed message -> %s", message));
    }
}
