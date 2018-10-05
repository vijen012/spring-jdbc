package com.springjdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import com.springjdbc.config.BeanConfig;
import com.springjdbc.domain.Organization;
import com.springjdbc.service.OrganizationService;

@Component
public class SpringJdbcDaoAnnontationApp {	
	//Spring Injects objects into the beans which are managed by spring itself that's why we annotated this class with @Component
	@Autowired
	private OrganizationService service;

	@Autowired
	private DaoUtils daoUtils;
	
	public void actionMethod()  {		
		//Create seed data
/*		daoUtils.createSeedData(service);*/
		
		//get all the organization
/*		List<Organization> orgList = service.findAllOrganization();
		daoUtils.printOrganizations(orgList, daoUtils.readOperation);*/
		
		//Create a new organization record
/*		Organization org = new Organization("General Electric", 1989, "12345", 7000, "Imagination at Work");
		boolean isCreated = service.addOrganization(org);
		daoUtils.printSuccessFailure(daoUtils.createOperation, isCreated);
		daoUtils.printOrganizations(service.findAllOrganization(), daoUtils.readOperation);*/
		
		//Get single Organization
		Organization org1 = service.findOrganization(28);
		daoUtils.printOrganization(org1, daoUtils.readOperation);
		
		//Update Organization 
/*		Organization org2 = service.findOrganization(26);
		org2.setSlogan("We build awesome automatic cars");
		boolean isUpdated = service.updateOrganization(org2);
		daoUtils.printSuccessFailure(daoUtils.updateOperation, isUpdated);
		daoUtils.printOrganization(service.findOrganization(26), daoUtils.updateOperation);*/
		
		//Delete Single Organization 
/*		Organization org3 = service.findOrganization(25);
		boolean isDeleted = service.deleteOrganization(org3);
		daoUtils.printSuccessFailure(daoUtils.deleteOperation, isDeleted);
		daoUtils.printOrganizations(service.findAllOrganization(), daoUtils.deleteOperation);*/
		
		//Cleanup
/*		service.cleanUp();
		daoUtils.printOrganizationCount(service.findAllOrganization(), daoUtils.cleanupOperation);				*/
	}
	
	public static void main(String[] args) {
		//Create application context
		ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
		SpringJdbcDaoAnnontationApp app = context.getBean(SpringJdbcDaoAnnontationApp.class);
		app.actionMethod();
		((AnnotationConfigApplicationContext) context).close();
	}
}
