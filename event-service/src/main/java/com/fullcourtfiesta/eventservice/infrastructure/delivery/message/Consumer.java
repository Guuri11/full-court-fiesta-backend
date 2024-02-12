package com.fullcourtfiesta.eventservice.infrastructure.delivery.message;

import com.fullcourtfiesta.eventservice.domain.Event;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class Consumer {

  @KafkaListener(topics = "event", groupId = "eventGroup")
  public void consumeMessageJson(Event event) {
    log.info(String.format("Consuming the message from event Topic:: %s", event));
  }
}
