package com.fullcourtfiesta.courtservice.application;

import com.fullcourtfiesta.courtservice.domain.Court;
import com.fullcourtfiesta.courtservice.domain.CourtRq;
import com.fullcourtfiesta.courtservice.domain.CourtRs;
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