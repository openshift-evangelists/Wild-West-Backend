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
      map.put("pacman-blue-" + i, new GameObject("pacman-blue-" + i, "pacman-blue-" + i, "pacman-blue", "Blue pacman",
          "You've killed a blue pacman. It's value is 10", 10));
      map.put("pacman-red-" + i, new GameObject("pacman-red-" + i, "pacman-red-" + i, "pacman-red", "Red pacman",
          "You've killed a Red pacman. It's value is 20", 20));
      map.put("pacman-pink-" + i, new GameObject("pacman-pink-" + i, "pacman-pink-" + i, "pacman-pink", "Pink pacman",
          "You've killed a pink pacman. It's value is 50", 50));
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
