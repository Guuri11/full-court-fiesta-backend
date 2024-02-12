package com.fullcourtfiesta.eventservice.infrastructure.persistence;


import com.fullcourtfiesta.eventservice.domain.Court.Court;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface CourtRepository extends ReactiveCrudRepository<Court, Long> {

}
