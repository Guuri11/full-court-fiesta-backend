package com.fullcourtfiesta.chatservice.domain;

import com.fullcourtfiesta.chatservice.domain.Player.Player;
import java.time.LocalDateTime;

public record MessageRs(Long id, Player sender, Player receiver, String content, LocalDateTime updatedAt) {

}
