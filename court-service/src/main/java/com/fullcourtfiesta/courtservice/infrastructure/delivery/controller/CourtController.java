package com.fullcourtfiesta.courtservice.infrastructure.delivery.controller;

import com.fullcourtfiesta.courtservice.application.CourtService;
import com.fullcourtfiesta.courtservice.domain.CourtRq;
import com.fullcourtfiesta.courtservice.domain.CourtRs;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "OK"),
      @ApiResponse(responseCode = "500", description = "Internal server error")
  })
  public Flux<CourtRs> all() {
    return courtService.all();
  }

  @GetMapping("/{id}")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "OK"),
      @ApiResponse(responseCode = "404", description = "Item not found"),
      @ApiResponse(responseCode = "500", description = "Internal server error")
  })
  public Mono<CourtRs> one(@PathVariable("id") final Long id) {
    return courtService.one(id);
  }

  @PostMapping
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "OK"),
      @ApiResponse(responseCode = "401", description = "BAD REQUEST"),
      @ApiResponse(responseCode = "500", description = "Internal server error")
  })
  public Mono<CourtRs> create(@RequestBody final CourtRq court) {
    return courtService.create(court);
  }

  @PutMapping("/{id}")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "OK"),
      @ApiResponse(responseCode = "401", description = "BAD REQUEST"),
      @ApiResponse(responseCode = "404", description = "NOT FOUND"),
      @ApiResponse(responseCode = "500", description = "Internal server error")
  })
  public Mono<CourtRs> replace(@RequestBody final CourtRq court, @PathVariable("id") final Long id) {
    return courtService.update(court, id);
  }

  @DeleteMapping("/{id}")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "OK"),
      @ApiResponse(responseCode = "404", description = "NOT FOUND"),
      @ApiResponse(responseCode = "500", description = "Internal server error")
  })
  public Mono<ResponseEntity<Void>> delete(@PathVariable("id") final Long id) {
    return courtService.delete(id)
        .then(Mono.just(ResponseEntity.noContent().build()));
  }
}
