package com.fullcourtfiesta.friendshipservice.domain;

import com.fullcourtfiesta.friendshipservice.domain.Player.Player;
import java.time.LocalDateTime;
import java.util.UUID;
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
public class Friendship {

  @Id
  private UUID id;
  @Column("player_id")
  private Player player;
  @Column("follower_id")
  private Player follower;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;

}