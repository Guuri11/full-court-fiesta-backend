package com.fullcourtfiesta.chatservice.domain.Player;

import java.time.LocalDateTime;

public record PlayerRs(Long id, String username, String fullName, String email, LocalDateTime createdAt, LocalDateTime updateAt) {

}
