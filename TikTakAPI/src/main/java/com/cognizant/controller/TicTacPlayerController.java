package com.cognizant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.ai.TicTacRandomAI;
import com.cognizant.model.GameMove;

@RestController
public class TicTacPlayerController {
	@Autowired
	private TicTacRandomAI randomAI;

    @PostMapping(path = "/tictac/random", consumes = "application/json", produces = "application/json")
    public GameMove getGameMove(@RequestBody List<GameMove> gameMoves) {
    	return randomAI.getNextMove(gameMoves);
    }
}
