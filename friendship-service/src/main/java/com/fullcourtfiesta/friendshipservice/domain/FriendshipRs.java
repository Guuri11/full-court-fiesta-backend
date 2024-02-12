package com.fullcourtfiesta.friendshipservice.domain;

import com.fullcourtfiesta.friendshipservice.domain.Player.Player;
import java.util.UUID;

public record FriendshipRs(UUID id, Player player, Player follower) {

}
