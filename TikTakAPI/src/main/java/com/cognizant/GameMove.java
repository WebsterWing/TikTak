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
}
