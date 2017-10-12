package com.openshift.kwww.controllers;

import java.util.Hashtable;
import java.util.Random;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.openshift.kwww.models.*;

@Configuration
@Scope(value = "singleton")
public class GameController {
	private Hashtable<String, Game> games = new Hashtable<>();

	public Game createGame() {
		Game newGame = new Game();
		Score gameScore = new Score();
		gameScore.setGameID(this.generateGameID());
		gameScore.setScore(0);
		newGame.setScore(gameScore);
		newGame.setGameMode(this.determineGameMode());

		games.put(newGame.getScore().getGameID(), newGame);

		return newGame;
	}

	public Game getGame(String gameID) {
		return this.games.get(gameID);
	}

	public void deleteGame(String gameID) {
		this.games.remove(gameID);
	}

	private String generateGameID() {
		String randomChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		StringBuilder gameID = new StringBuilder();
		Random rnd = new Random();
		while (gameID.length() < 18) {
			int index = (int) (rnd.nextFloat() * randomChars.length());
			gameID.append(randomChars.charAt(index));
		}

		return gameID.toString();
	}

	private int determineGameMode() {
		// gameMode = 0 = Kubenernetes
		// gameMode = 1 = OpenShift

		int gameMode = 1;
		if (System.getenv().containsKey("GAME_MODE")) {
			// possible game mode options are kube, k, kubernetes, openshift
			String gameEnvironmentVariable = System.getenv("GAME_MODE");
			switch (gameEnvironmentVariable) {
			case "kube":
			case "kubernetes":
			case "k":
				gameMode = 0;
				break;
			case "openshift":
			case "OpenShift":
				gameMode = 1;
				break;
			default:
				gameMode = 1;
			}
		}
		return gameMode;
	}
	/*
	private PlatformObject getRandomObject() {
		PlatformObject randomObject = new PlatformObject();
		
		return randomObject;
	}
	*/

}
