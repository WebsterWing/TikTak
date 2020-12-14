package com.cognizant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.model.Game;
import com.cognizant.repo.PagingGameRepository;

@RestController
public class GameController {
	@Autowired
	private PagingGameRepository gameRepository;
	
	@GetMapping("/games")
	// public Game games(@RequestParam(value = "name", defaultValue ="World") String name) {
	public List<Game> games() {
		return (List<Game>) gameRepository.findAll();
	}
}

