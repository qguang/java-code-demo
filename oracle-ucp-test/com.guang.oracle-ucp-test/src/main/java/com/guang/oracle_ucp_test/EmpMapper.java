package com.guang.oracle_ucp_test;

import java.sql.ResultSet;
import java.sql.SQLException;


import org.springframework.jdbc.core.RowMapper;

public class EmpMapper implements RowMapper<EmployeeDAO>{
	public EmployeeDAO mapRow (ResultSet rs, int rowNo) throws SQLException{
		EmployeeDAO emp = new EmployeeDAO();
		emp.setEmpId(rs.getInt("emp_id"));
		emp.setCreateBatchId(rs.getInt("create_batch_id"));
		emp.setName(rs.getString("name"));
		emp.setInstanceName(rs.getString("instance_name"));
		emp.setSessionId(rs.getString("session_id"));
		emp.setSid(rs.getString("sid"));
		return emp;
	}

}
