package com.openshift.wildwest.controllers;

import com.openshift.wildwest.models.Game;
import com.openshift.wildwest.models.GameObject;
import com.openshift.wildwest.models.GameType;

import java.util.Map;

/**
 * These is the API, so every change done in this file might impact the Fronentd
 */
public interface GameController {
  Game createGame();

  Game createGame(String username, GameType type);

  Game getGame(String gameId);

  Boolean stopGame(String gameId);

  GameObject getObject(String gameId);

  Boolean deleteObject(String gameId, String objectId);

  Map<String, Game> getTopScores();
}
