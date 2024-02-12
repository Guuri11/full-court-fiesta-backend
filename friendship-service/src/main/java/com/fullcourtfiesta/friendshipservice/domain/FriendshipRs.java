package com.fullcourtfiesta.friendshipservice.domain;

import com.fullcourtfiesta.friendshipservice.domain.Player.Player;

public record FriendshipRs(Long id, Player player, Player follower) {

}
