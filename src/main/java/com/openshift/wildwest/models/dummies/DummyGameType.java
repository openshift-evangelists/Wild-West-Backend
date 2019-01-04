package com.openshift.wildwest.models.dummies;

import com.openshift.wildwest.models.GameObjectType;
import com.openshift.wildwest.models.GameType;

import java.util.ArrayList;
import java.util.List;

public class DummyGameType extends GameType {
  private static GameType ourInstance = new DummyGameType();

  public static GameType getInstance() {
    return ourInstance;
  }

  private DummyGameType() {
    super("DUMMY", null);
    List<GameObjectType> objTypes = new ArrayList<>();
    objTypes.add(DummyGameObjectType.getInstance());
    this.setObjects(objTypes);
  }
}
