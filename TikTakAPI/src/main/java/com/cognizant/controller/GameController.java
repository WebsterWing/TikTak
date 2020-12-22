package com.cognizant.controller;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.cognizant.model.Game;
import com.cognizant.repo.PagingGameRepository;


@RestController
public class GameController {
	@Autowired
	private PagingGameRepository gameRepository;

    private static final Logger logger = LoggerFactory.getLogger(GameController.class);
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/games")
	public List<Game> games(
			@RequestParam(value = "page", defaultValue = "1")
			String pageParam,
			@RequestParam(value = "limit", defaultValue = "20")
			String limitParam
			) {
		int pageNo = Integer.parseInt(pageParam);
		int limitNo = Integer.parseInt(limitParam);

        Pageable pageable = PageRequest.of(pageNo - 1, limitNo);
        Page<Game> page = gameRepository.findAll(pageable);
		List<Game> list = page.getContent();
		
		// Logger.log(Level.INFO, list.toString());
		return list;
	}
	
	@PostMapping(path = "/games", consumes = "application/json", produces = "application/json")
	public Game addGame(@RequestBody Game game) {
		game.clearKeys();
		logger.info("START POST game");
		logger.info(game.toString());
		logger.info("END POST game");
		gameRepository.save(game);
		logger.info("AFTER SAVE game");
		logger.info(game.toString());
		logger.info("END SAVE game");
		return game;
	}
		
}