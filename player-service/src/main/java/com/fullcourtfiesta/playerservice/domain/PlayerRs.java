package com.fullcourtfiesta.playerservice.domain;

import java.time.LocalDateTime;

public record PlayerRs(Long id, String username, String fullName, String email, LocalDateTime createdAt, LocalDateTime updateAt) {

}
