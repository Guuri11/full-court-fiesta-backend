package com.fullcourtfiesta.eventservice.domain;

import com.fullcourtfiesta.eventservice.domain.Event.Event;
import com.fullcourtfiesta.eventservice.domain.Player.Player;

public record PostRq(Player player, String photo, Integer likes, Event event) { }
