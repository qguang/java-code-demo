package com.guang.oracle_ucp_test;

import javax.sql.DataSource;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

public class UcpNoJdbcConfAcTestSql {

	private DataSource dataSource;
	private PlatformTransactionManager transactionManager;
	private JdbcTemplate jdbcTemplateObject;
	
	public void setDataSource(DataSource dataSource){
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	
	public void setTransactionManager (PlatformTransactionManager transactionManager){
		this.transactionManager = transactionManager;
		
	}
	//@Transactional doesn't work with simpleJdbc
	public void displayEmpList() {
		int empId = 0;
		int insertWaitSecond = 5;
		
		// Transaction manager
		//TransactionDefinition td = new DefaultTransactionDefinition();
		//TransactionStatus txnStatus = transactionManager.getTransaction(td);
		
		String SQL = "select emp_id, name, instance_name, session_id, sid , create_batch_id from emp  where emp_id = ?";
		//
		String insertSQL = "insert into emp (emp_id, create_batch_id,  name) select ?, wait_for_second(?, ?), ? from dual";
		List<EmployeeDAO> employees ;
		int j = 0;
		

		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!  Test Application (JDBC: not configured)(DB: configured) !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		try 
		{
			
				jdbcTemplateObject.update("delete from emp");
				
				long start;
				long end;
				
				//loop counter below
				
				for (int i=0; i<100; i++){
					System.out.println("==================================== "+  Integer.toString(i) +  " ====================================");
					System.out.print("Start inserting  ... Elasped (millis) = ");
		
					empId ++;
					start = System.currentTimeMillis();
					jdbcTemplateObject.update(insertSQL, empId, insertWaitSecond, i, "Test Employee " + empId ); // empId, $wait_second, i is create_batch_id
					end = System.currentTimeMillis();
					System.out.println(end-start);
					
					start = System.currentTimeMillis();
					
					System.out.print("Start getting    ... Elasped (millis) = ");
					employees = jdbcTemplateObject.query(SQL,  new EmpMapper(), empId);
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
						System.out.println("INSTANCE     : " + employee.getInstanceName() + "   ------------------      <<<<<<<<<<<<<<<< keep an eye on this ");
						System.out.println("SESSIONID    : " + employee.getSessionId());
						System.out.println("SID          : " + employee.getSid());
						
						if (j > 20){
							System.out.println("Don't want to print all out. let's exit this loop");	
							break;
						}
					}
					
						
					//try {
					//	TimeUnit.SECONDS.sleep(1);
					//} catch (InterruptedException e) {
						// TODO Auto-generated catch block
					//	e.printStackTrace();
					//}
				}
				
		} catch (Exception  e){
			//transactionManager.rollback(txnStatus);
			e.printStackTrace();
		}
		
		//transactionManager.commit(txnStatus);
		
		
	}
	
	public static void main(String[] args) {
		ApplicationContext  context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		final UcpNoJdbcConfAcTestSql empJDBCTemplate = (UcpNoJdbcConfAcTestSql) context.getBean("UcpNoJdbcConfAcTestSql");
		empJDBCTemplate.displayEmpList();

	}
}
