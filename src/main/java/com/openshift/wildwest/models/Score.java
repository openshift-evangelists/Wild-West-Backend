package com.openshift.wildwest.models;

public class Score {

  private int score;
  private String gameId;

  public Score(String gameId) {
    this.gameId = gameId;
    this.score = 0;
  }

  public Score(String gameId, int score) {
    this.gameId = gameId;
    this.score = score;
  }

  public String getGameId() {
    return gameId;
  }

  public void setGameId(String gameId) {
    this.gameId = gameId;
  }

  public void setScore(int score) {
    this.score = score;
  }

  public int getScore() {
    return this.score;
  }

  @Override
  public String toString() {
    return "Game[" + gameId + "] : " + String.valueOf(score);
  }
}
