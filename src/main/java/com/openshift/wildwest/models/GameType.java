package com.openshift.wildwest.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;
import java.util.Objects;

public class GameType {
  private String name;
  @JsonIgnore
  private transient List<GameObjectType> objects;

  public GameType(){
  }

  public GameType(String name, List<GameObjectType> objectTypes) {
    this.name = name;
    this.objects = objectTypes;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<GameObjectType> getObjects() {
    return objects;
  }

  public void setObjects(List<GameObjectType> objects) {
    this.objects = objects;
  }

  @Override
  public String toString() {
    return "GameType{" +
        "name='" + name + '\'' +
        ", objects=" + objects +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    GameType gameType = (GameType) o;
    return Objects.equals(name, gameType.name) &&
        Objects.equals(objects, gameType.objects);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, objects);
  }
}
