package com.guang.oracle_ucp_test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class TestEmpJDBCTemplateSlowSql {

	public static void main(String[] args) {
		ApplicationContext  context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		final EmpJDBCTemplateSlowSql empJDBCTemplate = (EmpJDBCTemplateSlowSql) context.getBean("EmpJDBCTemplateSlowSql");
		empJDBCTemplate.displayEmpList();

	}

}
