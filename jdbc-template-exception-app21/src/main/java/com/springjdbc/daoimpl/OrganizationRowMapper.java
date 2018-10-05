package com.springjdbc.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.springjdbc.domain.Organization;

public class OrganizationRowMapper implements RowMapper<Organization> {

	//this is the abstract method in RowMapper interface,it will map one row of organization table to Organization class obj
	public Organization mapRow(ResultSet rs, int rowNum) throws SQLException {
		Organization org = new Organization();
		org.setId(rs.getInt("ID"));
		org.setCompanyName(rs.getString("COMPANY_NAME"));
		org.setYearOfIncorporation(rs.getInt("YEAR_OF_INCORPORATION"));
		org.setPostalCode(rs.getString("POSTAL_CODE"));
		org.setEmployeeCount(rs.getInt("EMPLOYEE_COUNT"));
		org.setSlogan(rs.getString("SLOGAN"));
		
		return org;
	}
}
