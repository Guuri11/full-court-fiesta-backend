package com.fullcourtfiesta.chatservice.application;

import com.fullcourtfiesta.chatservice.domain.Message;
import com.fullcourtfiesta.chatservice.domain.MessageRq;
import com.fullcourtfiesta.chatservice.domain.MessageRs;
import java.time.LocalDateTime;
import org.springframework.stereotype.Component;

@Component
public class MessageMapper {

  public MessageRs toDto(final Message entity) {

    if (entity == null) {
      return null;
    }
    return new MessageRs(entity.getId(), entity.getSender(), entity.getReceiver(), entity.getContent(), entity.getUpdatedAt());
  }

  public Message toEntity(final MessageRq dto) {

    if (dto == null) {
      return null;
    }
    return Message.builder()
        .sender(dto.sender())
        .receiver(dto.receiver())
        .content(dto.content())
        .createdAt(LocalDateTime.now())
        .updatedAt(LocalDateTime.now())
        .build();
  }
}