package com.cognizant;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import jdk.internal.org.jline.utils.Log;

@SpringBootTest
class TikTakApiApplicationTests {
	
	@Autowired
	private GameRepository repository;

	@Test
	public void sampleTestCase() {
		Game g = new Game("id", "username1", "usernhme2", new Date(),
		new Date(), new ArrayList<GameMove>());
		
		repository.save(g);
	}

	@Test
	void contextLoads() {
	}

}
