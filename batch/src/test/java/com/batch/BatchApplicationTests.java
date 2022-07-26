package com.batch;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.batch.repository.BatchRepository;
import com.batch.repository.BatchRepositoryImpl;
import com.zaxxer.hikari.HikariDataSource;

import lombok.extern.slf4j.Slf4j;

import static com.batch.constants.ConnectionConst.*;

@Slf4j
@SpringBootTest
class BatchApplicationTests {

	BatchRepositoryImpl repository;
	
	@Test
	void contextLoads() {
	}

	@BeforeEach
	void beforeEach() {
		HikariDataSource dataSource = new HikariDataSource();
		dataSource.setJdbcUrl(URL);
		dataSource.setUsername(USERNAME);
		dataSource.setPassword(PASSWORD);
		
		repository = new BatchRepositoryImpl(dataSource);
	}
	
	@Test
	void test() {
		String findById = repository.findById(2L);
		log.info(findById);
	}
}
