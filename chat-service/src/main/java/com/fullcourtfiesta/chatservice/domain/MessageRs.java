package com.fullcourtfiesta.chatservice.domain;

import com.fullcourtfiesta.chatservice.domain.Player.Player;
import java.time.LocalDateTime;
import java.util.UUID;

public record MessageRs(UUID id, Player sender, Player receiver, String content, LocalDateTime updatedAt) {

}
