package com.cognizant;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.socialsignin.spring.data.dynamodb.repository.EnableScanCount;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface PagingGameRepository extends CrudRepository {

    @EnableScan
	@EnableScanCount
	Page<Game> findAll(Pageable pageable);
}
