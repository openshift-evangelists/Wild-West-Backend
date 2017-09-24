package com.openshift.kwww.models;

import java.util.Hashtable;

public class Game {

	private Score score;
	private Hashtable<String, OpenShiftObject> gameObjects;
	
	public Game() {
		score = new Score();
		gameObjects = new Hashtable<>();
	}

	public Score getScore() {
		return score;
	}

	public void setScore(Score score) {
		this.score = score;
	}
	
	public void addGameObject(OpenShiftObject newObject) {
		if(!gameObjects.containsKey(newObject.getObjectID())) {
			gameObjects.put(newObject.getObjectID(), newObject);
		}
	}
	
	public void removeGameObject(OpenShiftObject theObject) {
		gameObjects.remove(theObject.getObjectID());
	}

}
