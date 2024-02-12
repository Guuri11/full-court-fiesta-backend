package com.fullcourtfiesta.playerservice.application;

import com.fullcourtfiesta.playerservice.application.exception.NotFoundException;
import com.fullcourtfiesta.playerservice.domain.Player;
import com.fullcourtfiesta.playerservice.domain.PlayerRq;
import com.fullcourtfiesta.playerservice.domain.PlayerRs;
import com.fullcourtfiesta.playerservice.infrastructure.persistence.PlayerRepository;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class PlayerService {

  private final PlayerRepository playerRepository;
  private final PlayerMapper playerMapper;

  public Flux<PlayerRs> all() {
    return playerRepository.findAll()
        .map(playerMapper::toDto);
  }

  public Mono<PlayerRs> one(final Long id) {
    return playerRepository.findById(id)
        .map(playerMapper::toDto)
        .switchIfEmpty(Mono.error(() -> new NotFoundException(id)));
  }

  public Mono<PlayerRs> create(final PlayerRq request) {
    final Player player = playerMapper.toEntity(request);
    player.setCreatedAt(LocalDateTime.now());
    player.setUpdatedAt(LocalDateTime.now());

    return playerRepository.save(player)
        .map(playerMapper::toDto);
  }

  public Mono<PlayerRs> update(final PlayerRq request, final Long id) {
    return playerRepository.findById(id)
        .flatMap(existing -> {
          existing.setUpdatedAt(LocalDateTime.now());
            existing.setEmail(request.email());
          existing.setFullName(request.fullName());
          existing.setUsername(request.username());
          return playerRepository.save(existing);
        })
        .map(playerMapper::toDto)
        .onErrorMap(e -> new NotFoundException(id));
  }

  public Mono<Void> delete(final Long id) {
    return playerRepository.findById(id)
        .flatMap(playerRepository::delete)
        .onErrorMap(e -> new NotFoundException(id));
  }
}