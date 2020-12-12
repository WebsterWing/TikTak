package com.cognizant;

import com.cognizant.repo.GameRepository;
import com.cognizant.model.Game;

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
		Game g = new Game();
		g.setUsername1("test1");
		g.setUsername2("test2");
		g.setCreatedTime(new Date());
		g.setCreatedTime(new Date());
		
		repository.save(g);
		
		assert(!g.getId().equals("GAME#null"));
	}

	@Test
	void contextLoads() {
	}

}
