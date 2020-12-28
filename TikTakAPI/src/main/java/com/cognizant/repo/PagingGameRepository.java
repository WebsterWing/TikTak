package com.cognizant.repo;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.socialsignin.spring.data.dynamodb.repository.EnableScanCount;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Component;

import com.cognizant.model.Game;

public interface PagingGameRepository extends PagingAndSortingRepository<Game, String>{
//public class PagingGameRepository extends CustomDynamoRepository<Game>{
	// public PagingGameRepository() {
		// super(new Game());
		// TODO Auto-generated constructor stub
	// }
	@EnableScan
	@EnableScanCount
	Page<Game> findAll(Pageable pageable);
}
