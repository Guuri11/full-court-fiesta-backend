package com.fullcourtfiesta.chatservice.infrastructure.persistence;

import com.fullcourtfiesta.chatservice.domain.Message;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface MessageRepository extends ReactiveCrudRepository<Message, Long> {

}
