package com.openshift.kwww.models;

public class Game {

	private Score score;
	
	public Game() {
		score = new Score();
	}

	public Score getScore() {
		return score;
	}

	public void setScore(Score score) {
		this.score = score;
	}

}
