package com.fullcourtfiesta.chatservice.infrastructure.delivery.message;

import com.fullcourtfiesta.chatservice.domain.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class Consumer {

  @KafkaListener(topics = "chat", groupId = "chatGroup")
  public void consumeMessageJson(Message message) {
    log.info(String.format("Consuming the message from chat Topic:: %s", message));
  }
}
