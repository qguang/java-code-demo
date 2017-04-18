package com.guang.oracle_ucp_test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class HelloApplication {

	public static void main(String[] args) {
		ApplicationContext  context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		final EmpJDBCTemplate empJDBCTemplate = (EmpJDBCTemplate) context.getBean("EmpJDBCTemplate");
		empJDBCTemplate.displayEmpList();

	}

}
