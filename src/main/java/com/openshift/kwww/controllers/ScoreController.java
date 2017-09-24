package com.openshift.kwww.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.openshift.kwww.models.Game;
import com.openshift.kwww.models.Score;

@RestController
public class ScoreController {
	@Autowired
	private GameController gameController;

    
    @RequestMapping("/score")
    public Score getScore(@RequestParam(value="gameID") String gameID) {
        return this.gameController.getGame(gameID).getScore();
    }
    
    @RequestMapping("/createGame")
    public Game getScore() {
        return gameController.createGame();
    }
}