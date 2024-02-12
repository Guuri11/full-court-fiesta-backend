package com.fullcourtfiesta.courtservice.infrastructure.persistence;

import com.fullcourtfiesta.courtservice.domain.Court;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface CourtRepository extends ReactiveCrudRepository<Court, Long> {

}
