package com.springjdbc.daoimpl;

import java.util.List;

import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import com.springjdbc.dao.OrganizationDao;
import com.springjdbc.domain.Organization;

public class OrganizationDaoImpl implements OrganizationDao {
	
	private JdbcTemplate jdbcTemplate;
		
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public boolean create(Organization org) {
		// TODO Auto-generated method stub
		return false;
	}

	public Organization getOrganization(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Organization> getAllOrganization() {
		String sqlQuery = "SELECT * FROM EMPLOYEE.ORGANIZATION";
		List<Organization> orgList = jdbcTemplate.query(sqlQuery, new OrganizationRowMapper());
		return orgList;
	}

	public boolean delete(Organization org) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean update(Organization org) {
		// TODO Auto-generated method stub
		return false;
	}

	public void cleanUp() {
		// TODO Auto-generated method stub

	}

}
