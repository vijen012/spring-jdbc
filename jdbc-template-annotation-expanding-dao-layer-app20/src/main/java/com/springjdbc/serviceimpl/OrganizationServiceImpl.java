package com.springjdbc.serviceimpl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springjdbc.dao.OrganizationDao;
import com.springjdbc.domain.Organization;
import com.springjdbc.service.OrganizationService;

@Service("orgService")
public class OrganizationServiceImpl implements OrganizationService {
	
	@Autowired
	private OrganizationDao orgDao;

	@Override
	public boolean addOrganization(Organization org) {
		return orgDao.addOrganization(org);
	}

	@Override
	public Organization findOrganization(Integer id) {	
		return orgDao.findOrganization(id);
	}

	@Override
	public List<Organization> findAllOrganization() {
		return orgDao.findAllOrganization();
	}

	@Override
	public boolean deleteOrganization(Organization org) {
		return orgDao.deleteOrganization(org);
	}

	@Override
	public boolean updateOrganization(Organization org) {
		return orgDao.updateOrganization(org);
	}

	@Override
	public void cleanUp() {
		orgDao.cleanUp();
	}

}
