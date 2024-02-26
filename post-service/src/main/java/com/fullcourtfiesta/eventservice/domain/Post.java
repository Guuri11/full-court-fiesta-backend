package com.fullcourtfiesta.eventservice.domain;

import com.fullcourtfiesta.eventservice.domain.Event.Event;
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
public class Post {

  @Id
  private Long id;
  @Column("player_id")
  private Player player;
  private String photo;
  private Integer likes;
  @Column("event_id")
  private Event event;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;

}