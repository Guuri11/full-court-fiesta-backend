package com.fullcourtfiesta.playerservice.application;

import com.fullcourtfiesta.playerservice.domain.Player;
import com.fullcourtfiesta.playerservice.domain.PlayerRq;
import com.fullcourtfiesta.playerservice.domain.PlayerRs;
import java.time.LocalDateTime;
import org.springframework.stereotype.Component;

@Component
public class PlayerMapper {

  public PlayerRs toDto(final Player entity) {

    if (entity == null) {
      return null;
    }
    return new PlayerRs(entity.getId(), entity.getUsername(), entity.getFullName(), entity.getEmail(), entity.getCreatedAt(), entity.getUpdatedAt());
  }

  public Player toEntity(final PlayerRq dto) {

    if (dto == null) {
      return null;
    }
    return Player.builder()
        .fullName(dto.fullName())
        .username(dto.username())
        .email(dto.email())
        .createdAt(LocalDateTime.now())
        .updatedAt(LocalDateTime.now())
        .build();
  }
}