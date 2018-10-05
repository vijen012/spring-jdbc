package com.springjdbc.daoimpl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.springjdbc.dao.OrganizationDao;
import com.springjdbc.domain.Organization;

@Repository
public class OrganizationDaoImpl implements OrganizationDao {
	
	
	private NamedParameterJdbcTemplate namedParamJdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
//		jdbcTemplate = new JdbcTemplate(dataSource);
		namedParamJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	public boolean addOrganization(Organization org) {
		SqlParameterSource beanParams = new BeanPropertySqlParameterSource(org);
		String sqlQuery = "INSERT INTO EMPLOYEE.ORGANIZATION (COMPANY_NAME, YEAR_OF_INCORPORATION, POSTAL_CODE, EMPLOYEE_COUNT, SLOGAN) " +
							"VALUES(:companyName, :yearOfIncorporation, :postalCode, :employeeCount, :slogan)";
		return namedParamJdbcTemplate.update(sqlQuery, beanParams) == 1;
		
/*		Object args[] = new Object[]{org.getCompanyName(), org.getYearOfIncorporation(), org.getPostalCode(), 
						org.getEmployeeCount(), org.getSlogan()};
		return jdbcTemplate.update(sqlQuery, args) == 1; */
	}

	public Organization findOrganization(Integer id) {
		SqlParameterSource paramMap = new MapSqlParameterSource("ID", id);
		String sqlQuery = "SELECT ID, COMPANY_NAME, YEAR_OF_INCORPORATION, POSTAL_CODE, EMPLOYEE_COUNT, SLOGAN FROM EMPLOYEE.ORGANIZATION	WHERE ID = :ID";
		Organization org = namedParamJdbcTemplate.queryForObject(sqlQuery, paramMap, new OrganizationRowMapper());
/*		Object[] args = new Object[]{id};
		Organization org = jdbcTemplate.queryForObject(sqlQuery, args, new OrganizationRowMapper());*/
		return org;
	}

	public List<Organization> findAllOrganization() {
		String sqlQuery = "SELECT * FROM EMPLOYEE.ORGANIZATION";
		List<Organization> orgList = namedParamJdbcTemplate.query(sqlQuery, new OrganizationRowMapper());
		return orgList;
	}

	public boolean deleteOrganization(Organization org) {
		SqlParameterSource beanParams = new BeanPropertySqlParameterSource(org);
		String sqlQuery = "DELETE FROM EMPLOYEE.ORGANIZATION WHERE ID = :id";
		return namedParamJdbcTemplate.update(sqlQuery, beanParams) == 1;
/*		Object args[] = new Object[]{org.getId()};
		return jdbcTemplate.update(sqlQuery, args) == 1;*/
	}

	public boolean updateOrganization(Organization org) {
		SqlParameterSource beanParams = new BeanPropertySqlParameterSource(org);
		String sqlQuery = "UPDATE EMPLOYEE.ORGANIZATION SET SLOGAN = :slogan WHERE ID = :id";
		return namedParamJdbcTemplate.update(sqlQuery, beanParams) == 1;
/*		Object args[] = new Object[]{ org.getSlogan(), org.getId() };
		return jdbcTemplate.update(sqlQuery, args) == 1;*/
	}

	public void cleanUp() {
		String sqlQuery = "TRUNCATE TABLE EMPLOYEE.ORGANIZATION";
		namedParamJdbcTemplate.getJdbcOperations().execute(sqlQuery);
	}

}
