package com.guang.oracle_ucp_test;

import javax.sql.DataSource;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

public class EmpJDBCTemplate {

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	
	public void setDataSource(DataSource dataSource){
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	
	public void displayEmpList(){
		String SQL = "select name from ucp_owner.emp";
		jdbcTemplateObject.execute("insert into ucp_owner.emp values('test1111')");
		
		List<EmployeeDAO> employees = jdbcTemplateObject.query(SQL,  new EmpMapper());
		
		for (EmployeeDAO employee: employees){
			System.out.println(employee.getName());
		}
	}
	
}
