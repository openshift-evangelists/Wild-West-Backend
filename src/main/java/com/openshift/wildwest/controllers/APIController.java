package com.openshift.wildwest.controllers;

import java.util.Collection;
import java.util.Map;

import com.openshift.wildwest.models.GameType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.openshift.wildwest.models.Game;
import com.openshift.wildwest.models.GameObject;

// oc policy add-role-to-user view system:serviceaccount:wildwest:default where wildwest
// is the project name

// To enable destructrive mode, a different permission needs to be added 
// oc policy add-role-to-user edit system:serviceaccount:wildwest:default

@RestController
public class APIController {
  @Autowired
  private GameController gameServer;

  @RequestMapping("/createGame")
  public Game createGame(@RequestParam(value = "username", required = false) String username,
                         @RequestParam(value = "gameType", required = false) GameType gameType) {
    // TODO: From the webUI these parameters need to be provided or else fail
    if ((username != null) && (gameType != null)) {
      return gameServer.createGame(username, gameType);
    }
    return gameServer.createGame();
  }

  @RequestMapping("/egg")
  public String easterEgg() {
    return "Every game needs an easter egg!!";
  }

  // TODO: This one is never called from the webUI. But here for conveniend
  @RequestMapping("/objects")
  public Collection<GameObject> getObjects(@RequestParam(value = "gameId") String gameID) {
    return gameServer.getGame(gameID).getObjects();
  }

  @RequestMapping("/game")
  public Game getGame(@RequestParam(value = "gameId") String gameID) {
    return gameServer.getGame(gameID);
  }

  @RequestMapping("/getRandomObject")
  public GameObject getRandomGameObject(@RequestParam(value = "gameId") String gameID) {
    GameObject obj = gameServer.getObject(gameID);
    System.out.println("Get random object: " + obj.getId());
    return obj;
  }

  @RequestMapping("/deleteObject")
  public void deleteGameObject(@RequestParam(value = "gameId") String gameID,
                               @RequestParam(value = "id") String objectID) {
    System.out.println("Deleting object: " + objectID);
    this.gameServer.deleteObject(gameID, objectID);
  }

  @RequestMapping("/topScores")
  public Map<String, Game> topScores() {
    System.out.println("Getting topScores");
    return gameServer.getTopScores();
  }
}