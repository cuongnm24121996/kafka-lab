package com.cuongnm.kafka.lab.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

import static com.cuongnm.kafka.lab.utils.Constant.DEFAULT_TOPIC;

@Configuration
public class KafkaTopicConfiguration {
    @Bean
    public NewTopic topic1() {
        return TopicBuilder.name(DEFAULT_TOPIC)
                .partitions(1)
                .replicas(1)
                .build();
    }
}
