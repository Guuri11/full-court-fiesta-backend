package com.fullcourtfiesta.friendshipservice.infrastructure.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

  @Bean
  public NewTopic friendshipTopic() {
    return TopicBuilder
        .name("friendship")
        .build();
  }
}
