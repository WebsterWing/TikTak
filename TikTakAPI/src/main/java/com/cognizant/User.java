package com.cognizant;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName="TikTak")
public class User {
	private String username;
	private String passwordHash;

	public User() {}

	public User(String username, String passwordHash) {
		super();
		this.username = username;
		this.passwordHash = passwordHash;
	}

	@DynamoDBHashKey(attributeName = "PK")
	public String getId() {
		return "USER#" + username;
	}
	// public void setId(String username) {
	// 	this.username = username;
	// }

	@DynamoDBAttribute(attributeName = "username")
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	@DynamoDBAttribute(attributeName = "passwordHash")
	public String getPasswordHash() {
		return passwordHash;
	}
	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

}
