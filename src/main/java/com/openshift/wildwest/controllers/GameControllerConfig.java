package com.openshift.wildwest.controllers;

import com.openshift.wildwest.controllers.dummies.DummyGameControllerImpl;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GameControllerConfig {

  @Bean
  @ConditionalOnProperty(name = "controller", havingValue = "game", matchIfMissing = true)
  public GameController dummyGameControler() {
    return new GameControllerImpl();
  }

  @Bean
  @ConditionalOnProperty(name = "controller", havingValue = "dummy")
  public GameController frenchGreetingService() {
    return new DummyGameControllerImpl();
  }
}
