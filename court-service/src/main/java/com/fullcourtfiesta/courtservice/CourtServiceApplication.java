package com.fullcourtfiesta.courtservice;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.config.EnableWebFlux;

@SpringBootApplication
@EnableWebFlux
@OpenAPIDefinition(info = @Info(title = "Court Service Backend", version = "1.0", description = "Documentation Court Service v1.0"))
public class CourtServiceApplication {

  public static void main(String[] args) {

    SpringApplication.run(CourtServiceApplication.class, args);
  }

}
