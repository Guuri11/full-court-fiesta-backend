package com.fullcourtfiesta.chatservice.domain;

import com.fullcourtfiesta.chatservice.domain.Player.Player;
import java.util.UUID;

public record FriendshipRs(UUID id, Player player, Player follower) {

}
