package com.openshift.wildwest.controllers;

import java.util.HashMap;
import java.util.Map;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.openshift.wildwest.models.*;

@Configuration
@Scope(value = "singleton")
public class GameController {

  private final Map<String, Game> games = new HashMap<String, Game>();

  public Game createGame() {
    Game newGame = new Game();
    games.put(newGame.getGameId(), newGame);
    return newGame;
  }

  public Game createGame(String gameId) {
    Game newGame = new Game(gameId);
    games.put(gameId, newGame);
    return newGame;
  }

  public Game getGame(String gameID) {
    return this.games.get(gameID);
  }

  public void deleteGame(String gameID) {
    this.games.remove(gameID);
  }
}
