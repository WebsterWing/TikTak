package com.cognizant;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;

@DynamoDBDocument
public class GameMove {
	private int row;
	private int col;
	private String player;
	private String username;
	public GameMove(int row, int col, String player, String username) {
		super();
		this.row = row;
		this.col = col;
		this.player = player;
		this.username = username;
	}
	public GameMove() {};

	@DynamoDBAttribute(attributeName = "row")
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}

	@DynamoDBAttribute(attributeName = "col")
	public int getCol() {
		return col;
	}
	public void setCol(int col) {
		this.col = col;
	}

	@DynamoDBAttribute(attributeName = "player")
	public String getPlayer() {
		return player;
	}
	public void setPlayer(String player) {
		this.player = player;
	}

	@DynamoDBAttribute(attributeName = "username")
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + col;
		result = prime * result + ((player == null) ? 0 : player.hashCode());
		result = prime * result + row;
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GameMove other = (GameMove) obj;
		if (col != other.col)
			return false;
		if (player == null) {
			if (other.player != null)
				return false;
		} else if (!player.equals(other.player))
			return false;
		if (row != other.row)
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "GameMove [row=" + row + ", col=" + col + ", player=" + player + ", username=" + username + "]";
	}
	
}
