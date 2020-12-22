package com.cognizant.ai;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Component;

import com.cognizant.model.GameMove;

@Component
public class TicTacRandomAI extends TicTacAI {
    private static final Logger logger = LoggerFactory.getLogger(TicTacRandomAI.class);

    // list of (row, col) tuple
	private List<int[]> getEmptySpaces(Boolean[][] board) {
		List<int[]> emptySpaces = new ArrayList<>();
		
		for (int i=0; i < board.length; i++) {
			for (int j=0; j < board[0].length; j++) {
				if (board[i][j] == null) {
					int[] tup = {i, j};
					emptySpaces.add(tup);
				}
			}
		}
		
		return emptySpaces;
	}

	public GameMove getNextMove(List<GameMove> gameMoves) {
		boolean currentPlayer = getNextPlayer(gameMoves);
		
		Boolean[][] board = getBoard(gameMoves);
		
		// row, col tuple
		List<int[]> emptySpaces = getEmptySpaces(board);
		
		int[] tup = emptySpaces.get((new Random()).nextInt(emptySpaces.size() - 1));
		
		logger.info("current player:" + currentPlayer);
		
		return new GameMove(tup[0], tup[1], currentPlayer ? "O" : "X", "BOT");
	}
}
