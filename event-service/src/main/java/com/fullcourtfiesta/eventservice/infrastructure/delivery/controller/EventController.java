package com.fullcourtfiesta.eventservice.infrastructure.delivery.controller;

import com.fullcourtfiesta.eventservice.application.EventService;
import com.fullcourtfiesta.eventservice.domain.EventRq;
import com.fullcourtfiesta.eventservice.domain.EventRs;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/events")
@RequiredArgsConstructor
public class EventController {

  private final EventService eventService;

  @GetMapping
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "OK"),
      @ApiResponse(responseCode = "500", description = "Internal server error")
  })
  public Flux<EventRs> all() {
    return eventService.all();
  }

  @GetMapping("/{id}")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "OK"),
      @ApiResponse(responseCode = "404", description = "Item not found"),
      @ApiResponse(responseCode = "500", description = "Internal server error")
  })
  public Mono<EventRs> one(@PathVariable("id") final Long id) {
    return eventService.one(id);
  }

  @PostMapping
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "OK"),
      @ApiResponse(responseCode = "401", description = "BAD REQUEST"),
      @ApiResponse(responseCode = "500", description = "Internal server error")
  })
  public Mono<EventRs> create(@RequestBody final EventRq eventRq) {
    return eventService.create(eventRq);
  }

  @PutMapping("/{id}")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "OK"),
      @ApiResponse(responseCode = "401", description = "BAD REQUEST"),
      @ApiResponse(responseCode = "404", description = "NOT FOUND"),
      @ApiResponse(responseCode = "500", description = "Internal server error")
  })
  public Mono<EventRs> replace(@RequestBody final EventRq  eventRq, @PathVariable("id") final Long id) {
    return eventService.update(eventRq, id);
  }

  @DeleteMapping("/{id}")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "OK"),
      @ApiResponse(responseCode = "404", description = "NOT FOUND"),
      @ApiResponse(responseCode = "500", description = "Internal server error")
  })
  public Mono<ResponseEntity<Void>> delete(@PathVariable("id") final Long id) {
    return eventService.delete(id)
        .then(Mono.just(ResponseEntity.noContent().<Void>build()));
  }
}
