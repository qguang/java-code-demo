package com.guang.oracle_ucp_test;

import javax.sql.DataSource;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.springframework.jdbc.core.JdbcTemplate;

public class EmpJDBCTemplateSlowSql {

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	
	public void setDataSource(DataSource dataSource){
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	
	public void displayEmpList(){
		String SQL = "select emp_id, name, instance_name, session_id, sid from emp where emp_id = ? and rownum < 2";
		//wait for 5 seconds * 2 level = 10 seconds
		String insertSQL = "insert into emp (emp_id, name) select  ?, ? from dual  connect by level <= zz_delay(5,2) order by level";
		List<EmployeeDAO> employees ;
		int j = 0;
		
		jdbcTemplateObject.update("delete from emp");
		
		long start;
		long end;
		
		//loop counter below
		
		for (int i=0; i<100; i++){
			System.out.println("==================================== "+  Integer.toString(i) +  " ====================================");
			System.out.print("Start inserting  ... Elasped (millis) = ");

			start = System.currentTimeMillis();
			jdbcTemplateObject.update(insertSQL, i, "Test Employee " + i );
			end = System.currentTimeMillis();
			System.out.println(end-start);
			
			start = System.currentTimeMillis();
			System.out.print("Start getting    ... Elasped (millis) = ");
			employees = jdbcTemplateObject.query(SQL,  new EmpMapper(), i);
			end = System.currentTimeMillis();
			System.out.print(end-start);
			System.out.println("     ... total records returned:  "+employees.size() );
			
			j = 0;
			
			for (EmployeeDAO employee: employees){
				j++;
				System.out.println("---------------------------------------------------------");
				System.out.println("Item         : " + Integer.toString(i) + "." + Integer.toString(j) );
				System.out.println("Current Time : " + new Date());
				System.out.println("EMP_ID       : " + employee.getEmpId());
				System.out.println("NAME         : " + employee.getName());
				System.out.println("INSTANCE     : " + employee.getInstanceName());
				System.out.println("SESSIONID    : " + employee.getSessionId());
				System.out.println("SID          : " + employee.getSid());
				
				if (j > 20){
					System.out.println("Don't want to print all out. let's exit this loop");	
					break;
				}
			}
			

			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
