package com.fullcourtfiesta.friendshipservice.application;

import com.fullcourtfiesta.friendshipservice.domain.Friendship;
import com.fullcourtfiesta.friendshipservice.domain.FriendshipRq;
import com.fullcourtfiesta.friendshipservice.domain.FriendshipRs;
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