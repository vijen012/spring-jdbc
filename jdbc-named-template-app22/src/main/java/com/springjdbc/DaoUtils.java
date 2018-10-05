package com.springjdbc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.springjdbc.dao.OrganizationDao;
import com.springjdbc.domain.Organization;
import com.springjdbc.service.OrganizationService;

@Service
public class DaoUtils {

	public final String createOperation = "CREATE";
	public final String readOperation = "READ";
	public final String updateOperation = "UPDATE";
	public final String deleteOperation = "DELETE";
	public final String cleanupOperation = "TRUNCATE";

	public void printOrganizations(List<Organization> orgs, String operation){
	    System.out.println("\n********* printing organizations after " + operation + " operation *********");
	    //Method references
	    orgs.forEach(System.out::println);
	    orgs.forEach(org -> System.out.println(org));
	}
	
	public void printOrganization(Organization org, String operation){
	    System.out.println("\n********* printing organization after " + operation + " operation ****"+ org +"*********");
	}

	public void printSuccessFailure(String operation, boolean param){
	    if(param)
	        System.out.println("\nOperation " + operation + " successful");
	    else
	        System.out.println("\nOperation " + operation + " failed");
	}
	
	public void createSeedData(OrganizationService service){
	    Organization org1 = new Organization("Amazon", 1994, "65656", 8765, "Work hard, have fun, make history");
	    Organization org2 = new Organization("BMW", 1929, "45454", 5501, "We build ultimate Driving machines");;
	    Organization org3 = new Organization("Google", 1996, "57575", 4567, "Don't be evil");
	     
	    List<Organization> orgs = new ArrayList<Organization>();
	    orgs.add(0, org1); orgs.add(1, org2); orgs.add(2, org3);
	    //int orgCount = orgs.size();
	    int createCount = 0;
	    for(Organization org : orgs){
	        boolean isCreated  = service.addOrganization(org);
	        if(isCreated)
	            createCount += 1;
	    }
	             
	    System.out.println("Created "+ createCount + " organizations");
	}
	
	public void printOrganizationCount(List<Organization> orgs, String operation){
	    System.out.println("\n*********Currently we have " + orgs.size()+ " organizations after " + operation + " operation" + "   *********");
	     
	}
}

