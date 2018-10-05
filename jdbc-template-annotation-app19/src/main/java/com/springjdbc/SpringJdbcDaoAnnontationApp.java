package com.springjdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.springjdbc.config.BeanConfig;
import com.springjdbc.dao.OrganizationDao;
import com.springjdbc.daoimpl.OrganizationDaoImpl;
import com.springjdbc.domain.Organization;

public class SpringJdbcDaoAnnontationApp {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
		OrganizationDao org = (OrganizationDaoImpl) context.getBean("orgDao");
		List<Organization> orgList = org.getAllOrganization();
		orgList.forEach(organization -> System.out.println(organization));
		((AnnotationConfigApplicationContext) context).close();
	}
}
