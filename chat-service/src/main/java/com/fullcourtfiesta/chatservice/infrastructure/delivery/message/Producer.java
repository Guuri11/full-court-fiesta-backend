package com.fullcourtfiesta.chatservice.infrastructure.delivery.message;

import com.fullcourtfiesta.chatservice.domain.Message;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class Producer {
  private final KafkaTemplate<String, String> kafkaTemplate;
  private final KafkaTemplate<String, Message> kafkaTemplateJson;

  public void sendMessageJson(Message message) {

    org.springframework.messaging.Message<Message> messageMessage = MessageBuilder.withPayload(message)
        .setHeader(KafkaHeaders.TOPIC, "message").build();

    kafkaTemplateJson.send(messageMessage);
  }
}
