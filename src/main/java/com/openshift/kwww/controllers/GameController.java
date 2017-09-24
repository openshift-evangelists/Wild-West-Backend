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

}
