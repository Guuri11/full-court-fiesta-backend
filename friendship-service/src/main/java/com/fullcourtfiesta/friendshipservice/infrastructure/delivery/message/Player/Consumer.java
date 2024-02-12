package com.fullcourtfiesta.friendshipservice.infrastructure.delivery.message.Player;

import com.fullcourtfiesta.friendshipservice.domain.Player.Player;
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
