package com.fullcourtfiesta.playerservice.infrastructure.delivery.message;

import com.fullcourtfiesta.playerservice.domain.Player;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class Consumer {

  @KafkaListener(topics = "player", groupId = "playerGroup")
  public void consumeMessageJson(Player player) {
    log.info(String.format("Consuming the message from player Topic:: %s", player));
  }
}
