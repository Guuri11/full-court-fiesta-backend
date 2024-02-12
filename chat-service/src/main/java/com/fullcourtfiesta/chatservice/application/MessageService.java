package com.fullcourtfiesta.chatservice.application;

import com.fullcourtfiesta.chatservice.application.exception.NotFoundException;
import com.fullcourtfiesta.chatservice.domain.Message;
import com.fullcourtfiesta.chatservice.domain.MessageRq;
import com.fullcourtfiesta.chatservice.domain.MessageRs;
import com.fullcourtfiesta.chatservice.infrastructure.persistence.MessageRepository;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class MessageService {

  private final MessageRepository messageRepository;
  private final MessageMapper messageMapper;

  public Flux<MessageRs> all() {
    return messageRepository.findAll()
        .map(messageMapper::toDto);
  }

  public Mono<MessageRs> one(final Long id) {
    return messageRepository.findById(id)
        .map(messageMapper::toDto)
        .switchIfEmpty(Mono.error(() -> new NotFoundException(id)));
  }

  public Mono<MessageRs> create(final MessageRq request) {
    final Message message = messageMapper.toEntity(request);
    message.setCreatedAt(LocalDateTime.now());
    message.setUpdatedAt(LocalDateTime.now());

    return messageRepository.save(message)
        .map(messageMapper::toDto);
  }

  public Mono<MessageRs> update(final MessageRq request, final Long id) {
    return messageRepository.findById(id)
        .flatMap(existing -> {
          existing.setUpdatedAt(LocalDateTime.now());
          existing.setContent(request.content());
          return messageRepository.save(existing);
        })
        .map(messageMapper::toDto)
        .onErrorMap(e -> new NotFoundException(id));
  }

  public Mono<Void> delete(final Long id) {
    return messageRepository.findById(id)
        .flatMap(messageRepository::delete)
        .onErrorMap(e -> new NotFoundException(id));
  }
}