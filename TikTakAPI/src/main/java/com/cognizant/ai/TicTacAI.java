package com.cognizant.ai;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cognizant.model.GameMove;

@Component
public abstract class TicTacAI {
	// player true for first, false for second (X)
	public Boolean checkWin(Boolean[][] board, boolean player) {
		// check across
		for (int i = 0; i < board.length; i++) {
			boolean win = true;

            for (int j = 0; j < board[0].length && win; j++) {
            	if (board[i][j] != player) {
            		win = false;
            	}
            }
			
			if (win) {
				return true;
			}
		}

		// check down
		for (int j = 0; j < board[0].length; j++) {
			boolean win = true;

            for (int i = 0; i < board.length && win; i++) {
            	if (board[i][j] != player) {
            		win = false;
            	}
            }
			
			if (win) {
				return true;
			}
		}

		// check top left to bottom right diagonal
        boolean win = true;

        for (int i = 0; i < board.length && win; i++) {
                if (board[i][i] != player) {
                        win = false;
                }
        }
        
        if (win) {
        	return true;
        }

        win = true;
		
        // check top right to bottom left
        for (int i = 0; i < board.length && win; i++) {
                if (board[board.length - 1 - i][i] != player) {
                        win = false;
                }
        }
        
        if (win) {
        	return true;
        }
        
        return false;
		
	}
	
	public Boolean[][] getBoard (List<GameMove> gameMoves) {
		Boolean[][] board = new Boolean[3][3];

		boolean currentPlayer = true;

		for (GameMove g: gameMoves) {
			board[g.getRow()][g.getCol()] = currentPlayer;

			currentPlayer = !currentPlayer;
		}
		
		return board;
    }
	
	// return true if next player should be circle
	public boolean getNextPlayer(List<GameMove> gameMoves) {
		return gameMoves.size() % 2 == 0;
	}
	
	public abstract GameMove getNextMove(List<GameMove> gameMoves);
}
