package com.cuongnm.kafka.lab.producer;

import com.cuongnm.kafka.lab.domain.MessageDTO;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import static com.cuongnm.kafka.lab.utils.Constant.DEFAULT_TOPIC;

@Slf4j
@Service
public class Producer {
    private final KafkaTemplate kafkaTemplate;

    public Producer(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(MessageDTO message) {
        log.info(String.format("#### -> Producing message -> %s", message));
        ListenableFuture<SendResult<String, Object>> future = kafkaTemplate.send(DEFAULT_TOPIC, message);

        future.addCallback(new ListenableFutureCallback<>() {

            @Override
            public void onSuccess(SendResult<String, Object> result) {
                log.info("Message [{}] delivered with offset {}", message, result.getRecordMetadata().offset());
            }

            @Override
            public void onFailure(Throwable ex) {
                log.warn("Unable to deliver message [{}]. {}", message, ex.getMessage());
            }
        });
    }

    public void sendMessage(String key, MessageDTO message) {
        ProducerRecord<String, MessageDTO> record = new ProducerRecord<>(DEFAULT_TOPIC, key, message);
        kafkaTemplate.send(record);
    }
}
