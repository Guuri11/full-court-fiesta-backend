package com.fullcourtfiesta.chatservice.domain;

import com.fullcourtfiesta.chatservice.domain.Player.Player;

public record MessageRq(Player sender, Player receiver, String content) {

}
