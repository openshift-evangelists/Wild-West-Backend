package com.openshift.wildwest.models.dummies;

import com.openshift.wildwest.models.GameObjectType;

public class DummyGameObjectType extends GameObjectType {
  private static GameObjectType ourInstance = new DummyGameObjectType();

  public static GameObjectType getInstance() {
    return ourInstance;
  }

  private DummyGameObjectType() {
    this.setName("Dummy");
    this.setValue(0);
  }
}
