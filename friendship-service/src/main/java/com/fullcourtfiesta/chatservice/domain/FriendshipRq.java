package com.fullcourtfiesta.chatservice.domain;


import com.fullcourtfiesta.chatservice.domain.Player.Player;

public record FriendshipRq(Player player, Player follower) {

}
