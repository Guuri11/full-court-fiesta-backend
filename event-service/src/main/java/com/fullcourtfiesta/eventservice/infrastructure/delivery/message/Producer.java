package com.fullcourtfiesta.eventservice.infrastructure.delivery.message;

import com.fullcourtfiesta.eventservice.domain.Event;
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
  private final KafkaTemplate<String, Event> kafkaTemplateJson;

  public void sendMessageJson(Event event) {

    Message<Event> message = MessageBuilder.withPayload(event)
        .setHeader(KafkaHeaders.TOPIC, "event").build();

    kafkaTemplateJson.send(message);
  }
}
