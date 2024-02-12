package com.fullcourtfiesta.friendshipservice.infrastructure.delivery.message.Player;

import com.fullcourtfiesta.friendshipservice.domain.Player.Player;
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
  private final KafkaTemplate<String, Player> kafkaTemplateJson;

  public void sendMessageJson(Player player) {

    Message<Player> message = MessageBuilder.withPayload(player)
        .setHeader(KafkaHeaders.TOPIC, "player").build();

    kafkaTemplateJson.send(message);
  }
}
