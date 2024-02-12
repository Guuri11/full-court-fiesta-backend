package com.fullcourtfiesta.friendshipservice.application.Player;

import com.fullcourtfiesta.friendshipservice.domain.Player.Player;
import com.fullcourtfiesta.friendshipservice.domain.Player.PlayerRs;
import org.springframework.stereotype.Component;

@Component
public class PlayerMapper {

  public PlayerRs toDto(final Player entity) {

    if (entity == null) {
      return null;
    }
    return new PlayerRs(entity.getId(), entity.getUsername(), entity.getFullName(), entity.getEmail(), entity.getCreatedAt(), entity.getUpdatedAt());
  }
}