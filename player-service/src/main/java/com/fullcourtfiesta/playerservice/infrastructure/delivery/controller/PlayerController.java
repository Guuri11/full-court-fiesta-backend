package com.fullcourtfiesta.playerservice.infrastructure.delivery.controller;

import com.fullcourtfiesta.playerservice.application.PlayerService;
import com.fullcourtfiesta.playerservice.domain.PlayerRq;
import com.fullcourtfiesta.playerservice.domain.PlayerRs;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/players")
@RequiredArgsConstructor
public class PlayerController {

  private final PlayerService playerService;

  @GetMapping
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "OK"),
      @ApiResponse(responseCode = "500", description = "Internal server error")
  })
  public Flux<PlayerRs> all() {
    return playerService.all();
  }

  @GetMapping("/{id}")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "OK"),
      @ApiResponse(responseCode = "404", description = "Item not found"),
      @ApiResponse(responseCode = "500", description = "Internal server error")
  })
  public Mono<PlayerRs> one(@PathVariable("id") final Long id) {
    return playerService.one(id);
  }

  @PostMapping
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "OK"),
      @ApiResponse(responseCode = "401", description = "BAD REQUEST"),
      @ApiResponse(responseCode = "500", description = "Internal server error")
  })
  public Mono<PlayerRs> create(@RequestBody final PlayerRq playerRq) {
    return playerService.create(playerRq);
  }

  @PutMapping("/{id}")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "OK"),
      @ApiResponse(responseCode = "401", description = "BAD REQUEST"),
      @ApiResponse(responseCode = "404", description = "NOT FOUND"),
      @ApiResponse(responseCode = "500", description = "Internal server error")
  })
  public Mono<PlayerRs> replace(@RequestBody final PlayerRq  playerRq, @PathVariable("id") final Long id) {
    return playerService.update(playerRq, id);
  }

  @DeleteMapping("/{id}")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "OK"),
      @ApiResponse(responseCode = "404", description = "NOT FOUND"),
      @ApiResponse(responseCode = "500", description = "Internal server error")
  })
  public Mono<ResponseEntity<Void>> delete(@PathVariable("id") final Long id) {
    return playerService.delete(id)
        .then(Mono.just(ResponseEntity.noContent().<Void>build()));
  }
}
