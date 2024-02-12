package com.fullcourtfiesta.courtservice.infrastructure.delivery.controller;

import com.fullcourtfiesta.courtservice.application.CourtService;
import com.fullcourtfiesta.courtservice.domain.CourtRq;
import com.fullcourtfiesta.courtservice.domain.CourtRs;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/courts")
@RequiredArgsConstructor
public class CourtController {

  private final CourtService courtService;

  @GetMapping
  public Flux<CourtRs> all() {
    return courtService.all();
  }

  @GetMapping("/{id}")
  public Mono<CourtRs> one(@PathVariable("id") final Long id) {
    return courtService.one(id);
  }

  @PostMapping
  public Mono<CourtRs> create(@RequestBody final CourtRq court) {
    return courtService.create(court);
  }

  @PutMapping("/{id}")
  public Mono<CourtRs> replace(@RequestBody final CourtRq court, @PathVariable("id") final Long id) {
    return courtService.update(court, id);
  }

  @DeleteMapping("/{id}")
  public Mono<ResponseEntity<Void>> delete(@PathVariable("id") final Long id) {
    return courtService.delete(id)
        .then(Mono.just(ResponseEntity.noContent().<Void>build()));
  }
}
