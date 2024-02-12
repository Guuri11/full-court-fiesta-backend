package com.fullcourtfiesta.eventservice.domain;

import com.fullcourtfiesta.eventservice.domain.Court.Court;
import com.fullcourtfiesta.eventservice.domain.Player.Player;
import java.time.LocalDateTime;

public record EventRs(Long id, Player player, String title, String description, Court court, EventState eventState, LocalDateTime dateTime) {

}
