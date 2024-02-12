package com.fullcourtfiesta.eventservice.application.Chat;

import com.fullcourtfiesta.eventservice.application.exception.NotFoundException;
import com.fullcourtfiesta.eventservice.domain.Court.Court;
import com.fullcourtfiesta.eventservice.domain.Court.CourtRq;
import com.fullcourtfiesta.eventservice.domain.Court.CourtRs;
import com.fullcourtfiesta.eventservice.infrastructure.persistence.CourtRepository;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class CourtService {

  private final CourtRepository courtRepository;
  private final CourtMapper courtMapper;
  // private final Producer producer;

  public Flux<CourtRs> all() {
    return courtRepository.findAll()
        .map(courtMapper::toDto);
  }

  public Mono<CourtRs> one(final Long id) {
    return courtRepository.findById(id)
        .map(courtMapper::toDto)
        .onErrorMap(e -> new NotFoundException(id));
  }

  public Mono<CourtRs> create(final CourtRq request) {
    final Court court = courtMapper.toEntity(request);
    court.setCreatedAt(LocalDateTime.now());
    court.setUpdatedAt(LocalDateTime.now());

    return courtRepository.save(court)
        // .doOnNext(producer::sendMessageJson)
        .map(courtMapper::toDto);
  }

  public Mono<CourtRs> update(final CourtRq request, final Long id) {
    return courtRepository.findById(id)
        .flatMap(existing -> {
          existing.setUpdatedAt(LocalDateTime.now());
          existing.setDirection(request.direction());
          existing.setName(request.name());
          existing.setLatitude(request.latitude());
          existing.setLongitude(request.longitude());

          return courtRepository.save(existing);
        })
        .map(courtMapper::toDto)
        .onErrorMap(e -> new NotFoundException(id));
  }

  public Mono<Void> delete(final Long id) {
    return courtRepository.findById(id)
        .flatMap(courtRepository::delete)
        .onErrorMap(e -> new NotFoundException(id));
  }
}