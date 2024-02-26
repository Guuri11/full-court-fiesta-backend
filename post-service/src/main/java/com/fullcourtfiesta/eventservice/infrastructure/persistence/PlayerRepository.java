package com.fullcourtfiesta.eventservice.infrastructure.persistence;

import com.fullcourtfiesta.eventservice.domain.Player.Player;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface PlayerRepository extends ReactiveCrudRepository<Player, Long> {

}
