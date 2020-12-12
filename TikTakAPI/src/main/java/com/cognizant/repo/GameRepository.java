package com.cognizant.repo;

import java.util.List;
import java.util.List;
import java.util.List;
import java.util.Optional;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import com.cognizant.model.Game;

@EnableScan
public interface GameRepository extends CrudRepository<Game, String> {
	Optional<Game> findById(String id);
}
