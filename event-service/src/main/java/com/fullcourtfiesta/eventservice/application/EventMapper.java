package com.fullcourtfiesta.eventservice.application;

import com.fullcourtfiesta.eventservice.domain.Event;
import com.fullcourtfiesta.eventservice.domain.EventRq;
import com.fullcourtfiesta.eventservice.domain.EventRs;
import java.time.LocalDateTime;
import org.springframework.stereotype.Component;

@Component
public class EventMapper {

  public EventRs toDto(final Event entity) {

    if (entity == null) {
      return null;
    }
    return new EventRs(entity.getId(), entity.getPlayer(), entity.getTitle(), entity.getDescription(), entity.getCourt(), entity.getEventState(), entity.getDateTime());
  }

  public Event toEntity(final EventRq request) {

    if (request == null) {
      return null;
    }

    final Event event = new Event();
    event.setEventState(request.eventState());
    event.setCourt(request.court());
    event.setPlayer(request.player());
    event.setDescription(request.description());
    event.setTitle(request.title());
    event.setDateTime(request.dateTime());
    event.setUpdatedAt(LocalDateTime.now());
    event.setCreatedAt(LocalDateTime.now());
    return event;
  }
}