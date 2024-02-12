package com.fullcourtfiesta.chatservice.application;

import com.fullcourtfiesta.chatservice.application.exception.NotFoundException;
import com.fullcourtfiesta.chatservice.domain.Friendship;
import com.fullcourtfiesta.chatservice.domain.FriendshipRq;
import com.fullcourtfiesta.chatservice.domain.FriendshipRs;
import com.fullcourtfiesta.chatservice.infrastructure.persistence.FriendshipRepository;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class FriendshipService {

  private final FriendshipRepository friendshipRepository;
  private final FriendshipMapper friendshipMapper;

  public Flux<FriendshipRs> all() {
    return friendshipRepository.findAll()
        .map(friendshipMapper::toDto);
  }

  public Mono<FriendshipRs> one(final Long id) {
    return friendshipRepository.findById(id)
        .map(friendshipMapper::toDto)
        .switchIfEmpty(Mono.error(() -> new NotFoundException(id)));
  }

  public Mono<FriendshipRs> create(final FriendshipRq request) {
    final Friendship friendship = friendshipMapper.toEntity(request);
    friendship.setCreatedAt(LocalDateTime.now());
    friendship.setUpdatedAt(LocalDateTime.now());

    return friendshipRepository.save(friendship)
        .map(friendshipMapper::toDto);
  }

  public Mono<FriendshipRs> update(final FriendshipRq request, final Long id) {
    return friendshipRepository.findById(id)
        .flatMap(existing -> {
          existing.setUpdatedAt(LocalDateTime.now());
          existing.setFollower(request.follower());
          existing.setPlayer(request.player());
          return friendshipRepository.save(existing);
        })
        .map(friendshipMapper::toDto)
        .onErrorMap(e -> new NotFoundException(id));
  }

  public Mono<Void> delete(final Long id) {
    return friendshipRepository.findById(id)
        .flatMap(friendshipRepository::delete)
        .onErrorMap(e -> new NotFoundException(id));
  }
}