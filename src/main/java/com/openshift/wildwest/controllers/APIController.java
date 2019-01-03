package com.openshift.wildwest.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.openshift.wildwest.models.Game;
import com.openshift.wildwest.models.Score;
import com.openshift.wildwest.models.GameObject;

// oc policy add-role-to-user view system:serviceaccount:wildwest:default where wildwest
// is the project name

// To enable destructrive mode, a different permission needs to be added 
// oc policy add-role-to-user edit system:serviceaccount:wildwest:default

@RestController
public class APIController {
  @Autowired
  private GameController gameController;

  @RequestMapping("/score")
  public Score getScore(@RequestParam(value = "gameId") String gameID) {
    return this.gameController.getGame(gameID).getScore();
  }

  @RequestMapping("/createGame")
  public Game createGame() {
    return gameController.createGame();
  }

  @RequestMapping("/egg")
  public String easterEgg() {
    return "Every game needs an easter egg!!";
  }

  // TODO: This one is never called from the webUI
  @RequestMapping("/objects")
  public Collection<GameObject> getGameObjects(@RequestParam(value = "gameId") String gameID) {
    return gameController.getGame(gameID).getObjects();
  }

  @RequestMapping("/getRandomObject")
  public GameObject getRandomGameObject(@RequestParam(value = "gameId") String gameID) {
    GameObject obj = gameController.getGame(gameID).getRandomObject();
    System.out.println("Get random object: " + obj.getId());
    return obj;
  }

  @RequestMapping("/deleteObject")
  public void deleteGameObject(@RequestParam(value = "gameId") String gameID,
      @RequestParam(value = "id") String objectID) {
    System.out.println("Deleting object: " + objectID);
    this.gameController.getGame(gameID).removeObject(objectID);
  }

}