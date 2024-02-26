package com.fullcourtfiesta.eventservice.domain.Event;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Event {

  @Id
  private Long id;
  @Column("player_id")
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;

}