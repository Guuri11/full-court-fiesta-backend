package com.fullcourtfiesta.courtservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.config.EnableWebFlux;

@SpringBootApplication
@EnableWebFlux
public class CourtServiceApplication {

  public static void main(String[] args) {

    SpringApplication.run(CourtServiceApplication.class, args);
  }

}
