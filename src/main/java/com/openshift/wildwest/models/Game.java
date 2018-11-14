package com.openshift.wildwest.models;

import java.util.Hashtable;

public class Game {

	private Score score;
	private Hashtable<String, PlatformObject> gameObjects;
	// The game mode determines if we are returning Kubernetes only objects or OpenShift
	// objects as well
	
	public enum GameMode {
		OPENSHIFT, KUBERNETES;
	}

	public GameMode mode = GameMode.OPENSHIFT;
	
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

	public void addGameObject(PlatformObject newObject) {
		if (!gameObjects.containsKey(newObject.getObjectID())) {
			gameObjects.put(newObject.getObjectID(), newObject);
		}
	}

	public void removeGameObject(PlatformObject theObject) {
		gameObjects.remove(theObject.getObjectID());
	}

	public GameMode getGameMode() {
		return mode;
	}

	public void setGameMode(GameMode mode) {
		this.mode = mode;
	}

}
