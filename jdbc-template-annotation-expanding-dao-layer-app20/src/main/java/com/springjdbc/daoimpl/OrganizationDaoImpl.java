package com.springjdbc.daoimpl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springjdbc.dao.OrganizationDao;
import com.springjdbc.domain.Organization;

@Repository("orgDao")
public class OrganizationDaoImpl implements OrganizationDao {
	
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public boolean addOrganization(Organization org) {
		String sqlQuery = "INSERT INTO EMPLOYEE.ORGANIZATION (COMPANY_NAME, YEAR_OF_INCORPORATION, POSTAL_CODE, EMPLOYEE_COUNT, SLOGAN) " +
							"VALUES(?, ?, ?, ?, ?)";
		Object args[] = new Object[]{org.getCompanyName(), org.getYearOfIncorporation(), org.getPostalCode(), 
						org.getEmployeeCount(), org.getSlogan()};
		return jdbcTemplate.update(sqlQuery, args) == 1;
	}

	public Organization findOrganization(Integer id) {
		String sqlQuery = "SELECT ID, COMPANY_NAME, YEAR_OF_INCORPORATION, POSTAL_CODE, EMPLOYEE_COUNT, SLOGAN FROM EMPLOYEE.ORGANIZATION	WHERE ID = ?";
		Object[] args = new Object[]{id};
		Organization org = jdbcTemplate.queryForObject(sqlQuery, args, new OrganizationRowMapper());
		return org;
	}

	public List<Organization> findAllOrganization() {
		String sqlQuery = "SELECT * FROM EMPLOYEE.ORGANIZATION";
		List<Organization> orgList = jdbcTemplate.query(sqlQuery, new OrganizationRowMapper());
		return orgList;
	}

	public boolean deleteOrganization(Organization org) {
		String sqlQuery = "DELETE FROM EMPLOYEE.ORGANIZATION WHERE ID = ?";
		Object args[] = new Object[]{org.getId()};
		return jdbcTemplate.update(sqlQuery, args) == 1;
	}

	public boolean updateOrganization(Organization org) {
		String sqlQuery = "UPDATE EMPLOYEE.ORGANIZATION SET SLOGAN = ? WHERE ID = ?";
		Object args[] = new Object[]{ org.getSlogan(), org.getId() };
		return jdbcTemplate.update(sqlQuery, args) == 1;
	}

	public void cleanUp() {
		String sqlQuery = "TRUNCATE TABLE EMPLOYEE.ORGANIZATION";
		jdbcTemplate.execute(sqlQuery);
	}

}
