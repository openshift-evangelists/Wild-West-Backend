package com.openshift.kwww.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.openshift.kwww.helpers.PlatformObjectHelper;
import com.openshift.kwww.models.Game;
import com.openshift.kwww.models.Score;
import com.openshift.kwww.models.PlatformObject;

@CrossOrigin(maxAge = 3600)
@RestController
public class APIController {
	@Autowired
	private GameController gameController;

	@RequestMapping("/score")
	public Score getScore(@RequestParam(value = "gameID") String gameID) {
		return this.gameController.getGame(gameID).getScore();
	}

	@RequestMapping("/createGame")
	public Game getScore() {
		return gameController.createGame();
	}

	@RequestMapping("/egg")
	public String easterEgg() {
		return "Every game needs an easter egg!!";
	}
	
	@RequestMapping("/objects")
	public List<PlatformObject> getPlatformObjects() {
		PlatformObjectHelper helper = new PlatformObjectHelper();
		return helper.getPlatformObjects();
	}
	

}