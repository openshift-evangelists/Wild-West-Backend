package com.openshift.wildwest.models;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Game {

  private String gameId;
  private Score score;
  private Map<String, GameObject> gameObjects = new HashMap<String, GameObject>();

  public Game() {
    this(Game.generateGameID());
  }

  public Game(String gameId) {
    this.gameId = gameId;
    score = new Score(gameId);
    initializeObjects(gameObjects);
  }

  public Collection<GameObject> getObjects() {
    return gameObjects.values();
  }

  public GameObject getRandomObject() {
    Random generator = new Random();
    Object[] values = gameObjects.values().toArray();
    GameObject randomValue = (GameObject) values[generator.nextInt(values.length)];
    return randomValue;
  }

  public String getGameId() {
    return gameId;
  }

  public void setGameId(String gameId) {
    this.gameId = gameId;
  }

  public Score getScore() {
    return score;
  }

  public void setScore(Score score) {
    this.score = score;
  }

  public void removeObject(String objectId) {
    gameObjects.remove(objectId);
  }

  public static final int NUM_OBJECTS = 2;

  public static void initializeObjects(Map<String, GameObject> map) {
    for (int i = 1; i <= NUM_OBJECTS; i++) {
      map.put("item1-" + i, new GameObject("item1-" + i, "item1-" + i, "item1", "Item 1",
          "You've killed an object with value of 10", 10));
      map.put("item2-" + i, new GameObject("item2-" + i, "item2-" + i, "item2", "Item 2",
          "You've killed an object with value of 20", 20));
      map.put("item3-" + i, new GameObject("item3-" + i, "item3-" + i, "item3", "Item 3",
          "You've killed an object with value of 50", 50));
      map.put("item4-" + i, new GameObject("item4-" + i, "item4-" + i, "item4", "Item 4",
          "You've killed an object with value of 100", 100));
    }
  }

  private static String generateGameID() {
    String randomChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
    StringBuilder gameID = new StringBuilder();
    Random rnd = new Random();
    while (gameID.length() < 18) {
      int index = (int) (rnd.nextFloat() * randomChars.length());
      gameID.append(randomChars.charAt(index));
    }

    return gameID.toString();
  }
}
