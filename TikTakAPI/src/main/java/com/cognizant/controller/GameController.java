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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.model.Game;
import com.cognizant.repo.PagingGameRepository;


@RestController
public class GameController {
	@Autowired
	private PagingGameRepository gameRepository;

    private static final Logger logger = LoggerFactory.getLogger(GameController.class);
	
	private final int PAGE_SIZE = 10;
	
	@GetMapping("/games")
	public List<Game> games(
			@RequestParam(value = "page", defaultValue = "1")
			String pageParam
			) {
		logger.info("/games/ param" + pageParam);
		int pageNo = Integer.parseInt(pageParam);
		logger.info("pageNo" + pageNo);
        Pageable pageable = PageRequest.of(pageNo - 1, PAGE_SIZE);
		logger.info("after pagerequest");
        Page<Game> page = gameRepository.findAll(pageable);
		logger.info("page result " + page.toString());
		List<Game> list = page.getContent();
		
		// Logger.log(Level.INFO, list.toString());
		return list;
	}
}

