package com.fullcourtfiesta.friendshipservice.domain;


import com.fullcourtfiesta.friendshipservice.domain.Player.Player;

public record FriendshipRq(Player player, Player follower) {

}
