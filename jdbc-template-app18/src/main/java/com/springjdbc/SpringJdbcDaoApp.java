package com.springjdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springjdbc.dao.OrganizationDao;
import com.springjdbc.daoimpl.OrganizationDaoImpl;
import com.springjdbc.domain.Organization;

public class SpringJdbcDaoApp {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("bean-cp.xml");
		OrganizationDao org = (OrganizationDaoImpl) context.getBean("orgDao");
		List<Organization> orgList = org.getAllOrganization();
		orgList.forEach(organization -> System.out.println(organization));
		((ClassPathXmlApplicationContext) context).close(); 
	}

}
