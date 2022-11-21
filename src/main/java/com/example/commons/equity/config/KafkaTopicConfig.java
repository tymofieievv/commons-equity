package com.example.commons.equity.config;


import com.example.commons.equity.constants.KafkaConstants;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic kafkaTopicIndexIn() {
        return TopicBuilder.name(KafkaConstants.KAFKA_TOPIC_INDEX_IN).build();
    }
    @Bean
    public NewTopic kafkaTopicFutureIn() {
        return TopicBuilder.name(KafkaConstants.KAFKA_TOPIC_FUTURE_IN).build();
    }
}
