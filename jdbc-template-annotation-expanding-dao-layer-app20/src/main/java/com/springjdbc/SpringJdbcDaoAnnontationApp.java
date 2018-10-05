package com.springjdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.springjdbc.config.BeanConfig;
import com.springjdbc.domain.Organization;
import com.springjdbc.service.OrganizationService;
import com.springjdbc.serviceimpl.OrganizationServiceImpl;

public class SpringJdbcDaoAnnontationApp {

	public static void main(String[] args) {
		//Create application context
		ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
		
		//Create bean object
		OrganizationService service = (OrganizationServiceImpl) context.getBean("orgService");
		
/*		//Create seed data
		DaoUtils.createSeedData(service);
		
		//get all the organization
		List<Organization> orgList = service.findAllOrganization();
		DaoUtils.printOrganizations(orgList, DaoUtils.readOperation);
		
		//Create a new organization record
		Organization org = new Organization("General Electric", 1989, "12345", 7000, "Imagination at Work");
		boolean isCreated = service.addOrganization(org);
		DaoUtils.printSuccessFailure(DaoUtils.createOperation, isCreated);
		DaoUtils.printOrganizations(service.findAllOrganization(), DaoUtils.readOperation);*/
		
		
		//Get single Organization
		Organization org1 = service.findOrganization(28);
		DaoUtils.printOrganization(org1, DaoUtils.readOperation);
		
/*		//Update Organization 
		Organization org2 = service.findOrganization(26);
		org2.setSlogan("We build awesome automatic cars");
		boolean isUpdated = service.updateOrganization(org2);
		DaoUtils.printSuccessFailure(DaoUtils.updateOperation, isUpdated);
		DaoUtils.printOrganization(service.findOrganization(26), DaoUtils.updateOperation);*/
		
/*		//Delete Single Organization 
		Organization org3 = service.findOrganization(25);
		boolean isDeleted = service.deleteOrganization(org3);
		DaoUtils.printSuccessFailure(DaoUtils.deleteOperation, isDeleted);
		DaoUtils.printOrganizations(service.findAllOrganization(), DaoUtils.deleteOperation);*/
		
		//Cleanup
//		service.cleanUp();
//		DaoUtils.printOrganizationCount(service.findAllOrganization(), DaoUtils.cleanupOperation);		
		((AnnotationConfigApplicationContext) context).close();
	}
}
