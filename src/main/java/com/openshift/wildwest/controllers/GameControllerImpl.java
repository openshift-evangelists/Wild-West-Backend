package com.openshift.wildwest.controllers;

import java.util.*;

import com.openshift.wildwest.models.dummies.DummyGameType;
import org.springframework.context.annotation.Scope;

import com.openshift.wildwest.models.*;

@Scope(value = "singleton")
public class GameControllerImpl implements GameController {

  private List<Game> activeGames = new ArrayList<>();
  private Map<String, Game> topScores = new HashMap<>();

  @Override
  public Game createGame() {
    Game game = new Game("ANONYMOUS", DummyGameType.getInstance());
    startGame(game);
    return game;
  }

  @Override
  public Game createGame(String username, GameType type) {
    Game game = new Game(username, type);
    startGame(game);
    return game;
  }

  @Override
  public Game getGame(String gameId){
    return findGame(gameId);
  }

  @Override
  public Boolean stopGame(String gameId){
    Game game = findGame(gameId);
    stopGame(game);
    return Boolean.TRUE;
  }

  @Override
  public GameObject getObject(String gameId){
    Game game = findGame(gameId);
    List<GameObject> objects = game.getObjects();
    Random generator = new Random();
    return objects.get(generator.nextInt(objects.size()));
  }

  @Override
  public Boolean deleteObject(String gameId, String objectId){
    Game game = findGame(gameId);
    List<GameObject> objects = game.getObjects();
    for(GameObject obj: objects) {
      if (obj.getId().equals(objectId)){
        objects.remove(obj);
        game.setObjects(objects);
        return Boolean.TRUE;
      }
    }
    return Boolean.FALSE;
  }

  @Override
  public Map<String, Game> getTopScores() {
    return topScores;
  }

  private void startGame(Game game){
    activeGames.add(game);
  }

  private void stopGame(Game game){
    activeGames.remove(game);
    if (topScores.get(game.getType()).getScore() < game.getScore()) {
      topScores.put(game.getType().getName(), game);
    }
  }

  private Game findGame(String gameId) throws GameNotFoundException {
    for(Game game: activeGames){
      if (game.getId().equals(gameId)) return game;
    }
    throw new GameNotFoundException();
  }


}
