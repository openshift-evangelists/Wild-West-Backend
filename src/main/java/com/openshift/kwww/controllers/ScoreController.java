package com.openshift.kwww.controllers;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.openshift.kwww.models.Score;

@RestController
public class ScoreController {
    private Score score;

    public ScoreController() {
        this.score = new Score();
    }
    @RequestMapping("/score")
    public Score getScore() {
        return this.score;
    }
}