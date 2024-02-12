package com.fullcourtfiesta.chatservice.domain;

import com.fullcourtfiesta.chatservice.domain.Player.Player;
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
public class Message {

  @Id
  private UUID id;
  @Column("sender_id")
  private Player sender;
  @Column("receiver_id")
  private Player receiver;
  private String content;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;

}