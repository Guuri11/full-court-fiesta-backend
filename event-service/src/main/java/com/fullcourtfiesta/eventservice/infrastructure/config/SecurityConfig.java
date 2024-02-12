package com.fullcourtfiesta.eventservice.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity.CsrfSpec;
import org.springframework.security.web.server.SecurityWebFilterChain;

@EnableWebFluxSecurity
@Configuration
public class SecurityConfig {

  @Bean
  public SecurityWebFilterChain securityWebFilterChain(
      ServerHttpSecurity http) {

    return http.authorizeExchange(exchanges -> exchanges
            .anyExchange()
            .permitAll())
        .csrf(CsrfSpec::disable)
        .build();
  }
}
