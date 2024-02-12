package com.fullcourtfiesta.eventservice.application.Chat;

import com.fullcourtfiesta.eventservice.domain.Court.Court;
import com.fullcourtfiesta.eventservice.domain.Court.CourtRq;
import com.fullcourtfiesta.eventservice.domain.Court.CourtRs;
import java.time.LocalDateTime;
import org.springframework.stereotype.Component;

@Component
public class CourtMapper {

  public CourtRs toDto(final Court entity) {

    if (entity == null) {
      return null;
    }
    return new CourtRs(entity.getId(), entity.getName(), entity.getDirection(), entity.getLongitude(), entity.getLatitude());
  }

  public Court toEntity(final CourtRq request) {

    if (request == null) {
      return null;
    }
    return Court.builder()
        .name(request.name())
        .latitude(request.latitude())
        .longitude(request.longitude())
        .direction(request.direction())
        .createdAt(LocalDateTime.now())
        .updatedAt(LocalDateTime.now())
        .build();
  }
}