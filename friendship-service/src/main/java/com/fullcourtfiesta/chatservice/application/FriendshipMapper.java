package com.fullcourtfiesta.chatservice.application;

import com.fullcourtfiesta.chatservice.domain.Friendship;
import com.fullcourtfiesta.chatservice.domain.FriendshipRq;
import com.fullcourtfiesta.chatservice.domain.FriendshipRs;
import java.time.LocalDateTime;
import org.springframework.stereotype.Component;

@Component
public class FriendshipMapper {

  public FriendshipRs toDto(final Friendship entity) {

    if (entity == null) {
      return null;
    }
    return new FriendshipRs(entity.getId(), entity.getPlayer(), entity.getFollower());
  }

  public Friendship toEntity(final FriendshipRq dto) {

    if (dto == null) {
      return null;
    }
    return Friendship.builder()
        .player(dto.player())
        .follower(dto.follower())
        .createdAt(LocalDateTime.now())
        .updatedAt(LocalDateTime.now())
        .build();
  }
}