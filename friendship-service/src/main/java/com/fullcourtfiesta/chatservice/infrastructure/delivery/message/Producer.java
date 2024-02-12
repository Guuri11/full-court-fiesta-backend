package com.fullcourtfiesta.chatservice.infrastructure.delivery.message;

import com.fullcourtfiesta.chatservice.domain.Friendship;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class Producer {
  private final KafkaTemplate<String, String> kafkaTemplate;
  private final KafkaTemplate<String, Friendship> kafkaTemplateJson;

  public void sendMessageJson(Friendship friendship) {

    Message<Friendship> message = MessageBuilder.withPayload(friendship)
        .setHeader(KafkaHeaders.TOPIC, "friendship").build();

    kafkaTemplateJson.send(message);
  }
}
