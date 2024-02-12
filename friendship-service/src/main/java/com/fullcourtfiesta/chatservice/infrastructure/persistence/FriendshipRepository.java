package com.fullcourtfiesta.chatservice.infrastructure.persistence;

import com.fullcourtfiesta.chatservice.domain.Friendship;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface FriendshipRepository extends ReactiveCrudRepository<Friendship, Long> {

}
