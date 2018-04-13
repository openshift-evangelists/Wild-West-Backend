package com.openshift.wildwest.models;

import java.util.Hashtable;

public class Game {

	private Score score;
	private Hashtable<String, PlatformObject> gameObjects;
	// The game mode determines if we are returning Kube only objects or OpenShift
	// objects as well
	// gameMode = 0 = Kubenernetes
	// gameMode = 1 = OpenShift
	private int gameMode = 0;

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

	public int getGameMode() {
		return gameMode;
	}

	public void setGameMode(int gameMode) {
		this.gameMode = gameMode;
	}

}
