package com.cognizant;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.socialsignin.spring.data.dynamodb.repository.EnableScanCount;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PagingGameRepository extends PagingAndSortingRepository<Game, String>{

    @EnableScan
	@EnableScanCount
	Page<Game> findAll(Pageable pageable);
}
