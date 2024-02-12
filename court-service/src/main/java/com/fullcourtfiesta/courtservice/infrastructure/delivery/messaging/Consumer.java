package com.fullcourtfiesta.courtservice.infrastructure.delivery.messaging;

import com.fullcourtfiesta.courtservice.domain.Court;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class Consumer {

  // @KafkaListener(topics = "court", groupId = "courtGroup")
  public void consumeMessage(String message) {
    log.info(String.format("Consuming the message from court Topic:: %s", message));
  }

  @KafkaListener(topics = "court", groupId = "courtGroup")
  public void consumeMessageJson(Court court) {
    log.info(String.format("Consuming the message from court Topic:: %s", court));
  }
}
