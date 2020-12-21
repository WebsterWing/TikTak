package com.cognizant.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.model.GameMove;

@RestController
public class TicTacPlayerController {

//	@PostMapping(path = "/tictac", consumes = "application/json", produces = "application/json")
//	public GameMove getGameMove(@RequestBody List<GameMove> gameMoves) {
//		// fill board with true for circle, false for X, null for empty
//		Boolean[][] board = new Boolean[3][3];
//
//		boolean currentPlayer = true;
//
//		for (GameMove g: gameMoves) {
//			board[g.getRow()][g.getCol()] = currentPlayer;
//
//			currentPlayer = !currentPlayer;
//		}
//	}
}
