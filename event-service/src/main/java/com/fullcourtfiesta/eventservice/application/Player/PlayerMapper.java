package com.fullcourtfiesta.eventservice.application.Player;

import com.fullcourtfiesta.eventservice.domain.Player.Player;
import com.fullcourtfiesta.eventservice.domain.Player.PlayerRs;
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