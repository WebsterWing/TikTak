package com.cognizant.repo;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.socialsignin.spring.data.dynamodb.repository.EnableScanCount;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.cognizant.model.Game;

@EnableScan
public interface PagingGameRepository extends PagingAndSortingRepository<Game, String>{

	// @EnableScanCount
	Page<Game> findAll(Pageable pageable);
}
