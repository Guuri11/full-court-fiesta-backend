package com.fullcourtfiesta.friendshipservice.infrastructure.delivery.message;

import com.fullcourtfiesta.friendshipservice.domain.Friendship;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class Consumer {

  @KafkaListener(topics = "friendship", groupId = "friendshipGroup")
  public void consumeMessageJson(Friendship player) {
    log.info(String.format("Consuming the message from friendship Topic:: %s", player));
  }
}
