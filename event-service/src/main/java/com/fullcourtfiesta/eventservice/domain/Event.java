package com.fullcourtfiesta.eventservice.domain;

import com.fullcourtfiesta.eventservice.domain.Court.Court;
import com.fullcourtfiesta.eventservice.domain.Player.Player;
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
  private Player player;
  private String title;
  private String description;
  private LocalDateTime dateTime;
  @Column("court_id")
  private Court court;
  private EventState eventState;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;

}