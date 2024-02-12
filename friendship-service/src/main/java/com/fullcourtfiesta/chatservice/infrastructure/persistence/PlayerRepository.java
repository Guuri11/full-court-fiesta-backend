package com.fullcourtfiesta.chatservice.infrastructure.persistence;

import com.fullcourtfiesta.chatservice.domain.Player.Player;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface PlayerRepository extends ReactiveCrudRepository<Player, Long> {

}
