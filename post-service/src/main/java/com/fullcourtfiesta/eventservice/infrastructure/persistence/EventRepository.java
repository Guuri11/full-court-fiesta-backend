package com.fullcourtfiesta.eventservice.infrastructure.persistence;


import com.fullcourtfiesta.eventservice.domain.Event.Event;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface EventRepository extends ReactiveCrudRepository<Event, Long> {

}
