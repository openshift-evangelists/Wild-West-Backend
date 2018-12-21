package com.openshift.wildwest.models;

public class GameObject {

  private String id;
  private String name;
  private String type;
  private String description;
  private String killHelp;
  private int value;

  public GameObject(String objectID, String objectName, String objectType) {
    this.id = objectID;
    this.name = objectName;
    this.type = objectType;
  }

  public GameObject(String objectID, String objectName, String objectType, String description, String killHelp,
      int value) {
    this(objectID, objectName, objectType);
    this.description = description;
    this.killHelp = killHelp;
    this.value = value;
  }

  public String getId() {
    return id;
  }

  public void setId(String objectID) {
    this.id = objectID;
  }

  public String getType() {
    return type;
  }

  public void setType(String objectType) {
    this.type = objectType;
  }

  public String getName() {
    return name;
  }

  public void setName(String objectName) {
    this.name = objectName;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String param) {
    this.description = param;
  }

  public String getKillHelp() {
    return killHelp;
  }

  public void setKillHelp(String param) {
    this.killHelp = param;
  }

  public int getValue() {
    return value;
  }

  public void setValue(int param) {
    this.value = param;
  }

}
