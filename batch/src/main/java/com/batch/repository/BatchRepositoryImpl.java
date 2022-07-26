package com.batch.repository;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class BatchRepositoryImpl implements BatchRepository {

	private final JdbcTemplate template;
	
	public BatchRepositoryImpl(DataSource dataSource) {
		this.template = new JdbcTemplate(dataSource);
	}

	@Override
	public String findById(Long id) {
		String sql = "select name from test where id = ?";
		return template.queryForObject(sql, testRowMapper(), id);
	}
	
	private RowMapper<String> testRowMapper()  {
		return (rs, rowNum) -> {
			return rs.getString("name");
		};
	}
}
