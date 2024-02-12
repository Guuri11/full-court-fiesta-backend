package com.fullcourtfiesta.playerservice.infrastructure.persistence;

import com.fullcourtfiesta.playerservice.domain.Player;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface PlayerRepository extends ReactiveCrudRepository<Player, Long> {

}
