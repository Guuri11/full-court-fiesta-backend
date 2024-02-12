package com.fullcourtfiesta.chatservice.infrastructure.delivery.controller;

import com.fullcourtfiesta.chatservice.application.MessageService;
import com.fullcourtfiesta.chatservice.domain.MessageRq;
import com.fullcourtfiesta.chatservice.domain.MessageRs;
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
@RequestMapping("/api/v1/messages")
@RequiredArgsConstructor
public class MessageController {

  private final MessageService messageService;

  @GetMapping
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "OK"),
      @ApiResponse(responseCode = "500", description = "Internal server error")
  })
  public Flux<MessageRs> all() {
    return messageService.all();
  }

  @GetMapping("/{id}")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "OK"),
      @ApiResponse(responseCode = "404", description = "Item not found"),
      @ApiResponse(responseCode = "500", description = "Internal server error")
  })
  public Mono<MessageRs> one(@PathVariable("id") final Long id) {
    return messageService.one(id);
  }

  @PostMapping
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "OK"),
      @ApiResponse(responseCode = "401", description = "BAD REQUEST"),
      @ApiResponse(responseCode = "500", description = "Internal server error")
  })
  public Mono<MessageRs> create(@RequestBody final MessageRq messageRq) {
    return messageService.create(messageRq);
  }

  @PutMapping("/{id}")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "OK"),
      @ApiResponse(responseCode = "401", description = "BAD REQUEST"),
      @ApiResponse(responseCode = "404", description = "NOT FOUND"),
      @ApiResponse(responseCode = "500", description = "Internal server error")
  })
  public Mono<MessageRs> replace(@RequestBody final MessageRq  messageRq, @PathVariable("id") final Long id) {
    return messageService.update(messageRq, id);
  }

  @DeleteMapping("/{id}")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "OK"),
      @ApiResponse(responseCode = "404", description = "NOT FOUND"),
      @ApiResponse(responseCode = "500", description = "Internal server error")
  })
  public Mono<ResponseEntity<Void>> delete(@PathVariable("id") final Long id) {
    return messageService.delete(id)
        .then(Mono.just(ResponseEntity.noContent().<Void>build()));
  }
}
