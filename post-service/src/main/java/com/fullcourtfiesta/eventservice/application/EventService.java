package com.fullcourtfiesta.eventservice.application;

import com.fullcourtfiesta.eventservice.application.exception.NotFoundException;
import com.fullcourtfiesta.eventservice.domain.Event.Event;
import com.fullcourtfiesta.eventservice.domain.Event.EventRq;
import com.fullcourtfiesta.eventservice.domain.Event.EventRs;
import com.fullcourtfiesta.eventservice.infrastructure.persistence.EventRepository;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class EventService {

  private final EventRepository eventRepository;
  private final EventMapper eventMapper;

  public Flux<EventRs> all() {
    return eventRepository.findAll()
        .map(eventMapper::toDto);
  }

  public Mono<EventRs> one(final Long id) {
    return eventRepository.findById(id)
        .map(eventMapper::toDto)
        .switchIfEmpty(Mono.error(() -> new NotFoundException(id)));
  }

  public Mono<EventRs> create(final EventRq request) {
    final Event event = eventMapper.toEntity(request);
    event.setCreatedAt(LocalDateTime.now());
    event.setUpdatedAt(LocalDateTime.now());

    return eventRepository.save(event)
        .map(eventMapper::toDto);
  }

  public Mono<EventRs> update(final EventRq request, final Long id) {
    return eventRepository.findById(id)
        .flatMap(existing -> {
          existing.setUpdatedAt(LocalDateTime.now());
          existing.setDescription(request.description());
          existing.setEventState(request.eventState());
          existing.setCourt(request.court());
          existing.setTitle(request.title());
          return eventRepository.save(existing);
        })
        .map(eventMapper::toDto)
        .onErrorMap(e -> new NotFoundException(id));
  }

  public Mono<Void> delete(final Long id) {
    return eventRepository.findById(id)
        .flatMap(eventRepository::delete)
        .onErrorMap(e -> new NotFoundException(id));
  }
}