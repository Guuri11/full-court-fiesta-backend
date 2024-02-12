package com.fullcourtfiesta.friendshipservice.infrastructure.persistence;

import com.fullcourtfiesta.friendshipservice.domain.Player.Player;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface PlayerRepository extends ReactiveCrudRepository<Player, Long> {

}
