package com.springjdbc.service;

import java.util.List;

import javax.sql.DataSource;

import com.springjdbc.domain.Organization;

public interface OrganizationService {
	
	//Create a record in organization table
	public boolean addOrganization(Organization org);
	
	//Retrieve a single organization
	public Organization findOrganization(Integer id);
	
	//Retrieve all the organization from the table
	public List<Organization> findAllOrganization();
	
	//Delete a specific organization from the table
	public boolean deleteOrganization(Organization org);
	
	//Update a existing organization
	public boolean updateOrganization(Organization org);
	
	public void cleanUp();
}
