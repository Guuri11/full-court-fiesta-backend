package com.fullcourtfiesta.friendshipservice.infrastructure.persistence;

import com.fullcourtfiesta.friendshipservice.domain.Friendship;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface FriendshipRepository extends ReactiveCrudRepository<Friendship, Long> {

}
