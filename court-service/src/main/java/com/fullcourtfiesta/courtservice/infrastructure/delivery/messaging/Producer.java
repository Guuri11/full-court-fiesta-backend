package com.fullcourtfiesta.courtservice.infrastructure.delivery.messaging;

import com.fullcourtfiesta.courtservice.domain.Court;
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
  private final KafkaTemplate<String, Court> kafkaTemplateJson;

  public void sendMessage(String message) {
    log.info(String.format("Sending message to court topic:: %s", message));
    kafkaTemplate.send("court", message);
  }

  public void sendMessageJson(Court court) {

    Message<Court> message = MessageBuilder.withPayload(court)
        .setHeader(KafkaHeaders.TOPIC, "court").build();

    kafkaTemplateJson.send(message);
  }
}
