package com.openshift.wildwest.controllers.dummies;

import com.openshift.wildwest.controllers.GameController;
import com.openshift.wildwest.models.Game;
import com.openshift.wildwest.models.GameObject;
import com.openshift.wildwest.models.GameObjectType;
import com.openshift.wildwest.models.GameType;
import com.openshift.wildwest.models.dummies.DummyGameType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DummyGameControllerImpl implements GameController {

  private static final Map<GameType, Game> topScores = new HashMap<>();
  private static final Game game = new Game("ANONYMOUS", DummyGameType.getInstance());
  private static final List<GameObjectType> objectTypes = new ArrayList<>();
  private static final List<GameObject> objects = new ArrayList<>();

  private static final GameObjectType OBJ1 = new GameObjectType("item1", 10);
  private static final GameObjectType OBJ2 = new GameObjectType("item2", 20);
  private static final GameObjectType OBJ3 = new GameObjectType("item3", 50);
  private static final GameObjectType OBJ4 = new GameObjectType("item4", 100);

  private static final int MAX = 2;
  static {
    objectTypes.add(OBJ1);
    objectTypes.add(OBJ2);
    objectTypes.add(OBJ3);
    objectTypes.add(OBJ4);

    for (int i=1;i<=MAX+4;i++) objects.add(new GameObject("obj1_"+i, OBJ1));
    for (int i=1;i<=MAX+3;i++) objects.add(new GameObject("obj2_"+i, OBJ2));
    for (int i=1;i<=MAX+2;i++) objects.add(new GameObject("obj3_"+i, OBJ3));
    for (int i=1;i<=MAX+1;i++) objects.add(new GameObject("obj4_"+i, OBJ4));

    game.setObjects(objects);

  }
  private static final GameType gameType = new GameType("BeerGame", objectTypes);

  @Override
  public Game createGame() {
    return game;
  }

  @Override
  public Game createGame(String username, GameType type) {
    return game;
  }

  @Override
  public Game getGame(String gameId) {
    return game;
  }

  @Override
  public Boolean stopGame(String gameId) {
    return Boolean.TRUE;
  }

  @Override
  public GameObject getObject(String gameId) {
    return game.getRandomObject();
  }

  @Override
  public Boolean deleteObject(String gameId, String objectId) {
    game.removeObject(objectId);
    return Boolean.TRUE;
  }

  @Override
  public Map<String, Game> getTopScores() {
    Map<String, Game> result = new HashMap<>();
    result.put(game.getType().getName(), game);
    return result;
  }
}
