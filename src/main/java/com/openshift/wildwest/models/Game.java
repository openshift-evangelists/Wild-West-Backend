package com.openshift.wildwest.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * These is Game object. Every change done in this file might impact the Fronentd
 */
public class Game {

  private String id;
  private String username;
  private int score;
  private int level;
  private GameType type;
  @JsonIgnore
  private transient List<GameObject> objects;

  public Game(String username, GameType type) {
    this.id = generateGameID();
    this.username = username;
    this.score = 0;
    this.level = 1;
    this.type = type;
    this.objects = new ArrayList<GameObject>();
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public int getScore() {
    return score;
  }

  public void setScore(int score) {
    this.score = score;
  }

  public int getLevel() {
    return level;
  }

  public void setLevel(int level) {
    this.level = level;
  }

  public GameType getType() {
    return type;
  }

  public void setType(GameType type) {
    this.type = type;
  }

  public List<GameObject> getObjects() {
    return objects;
  }

  public void setObjects(List<GameObject> objects) {
    this.objects = objects;
  }

  @JsonIgnore
  public GameObject getRandomObject(){
    Random rand = new Random();
    return objects.get(rand.nextInt(objects.size()));
  }

  public Boolean removeObject(String objectId){
    for (GameObject o: objects){
      if (o.getId().equals(objectId)){
        objects.remove(o);
        return Boolean.TRUE;
      }
    }
    return Boolean.FALSE;
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

  @Override
  public String toString() {
    return "Game{" +
        "id='" + id + '\'' +
        ", username='" + username + '\'' +
        ", score=" + score +
        ", level=" + level +
        ", type=" + type +
        ", objects=" + objects +
        '}';
  }
}
