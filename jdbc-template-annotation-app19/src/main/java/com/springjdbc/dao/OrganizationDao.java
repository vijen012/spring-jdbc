package com.springjdbc.dao;

import java.util.List;

import javax.sql.DataSource;

import com.springjdbc.domain.Organization;

public interface OrganizationDao {
	
	//Set the data-source that will be required to create a connection to the database
	public void setDataSource(DataSource dataSource);
	
	//Create a record in organization table
	public boolean create(Organization org);
	
	//Retrieve a single organization
	public Organization getOrganization(Integer id);
	
	//Retrieve all the organization from the table
	public List<Organization> getAllOrganization();
	
	//Delete a specific organization from the table
	public boolean delete(Organization org);
	
	//Update a existing organization
	public boolean update(Organization org);
	
	public void cleanUp();
}
