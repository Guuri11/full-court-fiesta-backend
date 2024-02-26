package com.fullcourtfiesta.eventservice.domain;

import com.fullcourtfiesta.eventservice.domain.Event.Event;
import com.fullcourtfiesta.eventservice.domain.Player.Player;
import java.time.LocalDateTime;
import java.util.UUID;

public record PostRs(UUID id, Player player, String photo, Integer likes, Event event, LocalDateTime createdAt) { }
