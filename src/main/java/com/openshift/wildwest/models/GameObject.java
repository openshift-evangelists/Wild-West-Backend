package com.openshift.wildwest.models;

import java.util.Objects;

public class GameObject {

  private String id;
  private GameObjectType type;

  public GameObject(String objectID, GameObjectType objectType) {
    this.id = objectID;
    this.type = objectType;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public GameObjectType getType() {
    return type;
  }

  public void setType(GameObjectType type) {
    this.type = type;
  }

  @Override
  public String toString() {
    return "GameObject{" +
        "id='" + id + '\'' +
        ", type=" + type +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    GameObject that = (GameObject) o;
    return Objects.equals(id, that.id) &&
        Objects.equals(type, that.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, type);
  }
}
