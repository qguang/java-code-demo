package com.guang.oracle_ucp_test;

import java.sql.ResultSet;
import java.sql.SQLException;


import org.springframework.jdbc.core.RowMapper;

public class EmpMapper implements RowMapper<EmployeeDAO>{
	public EmployeeDAO mapRow (ResultSet rs, int rowNo) throws SQLException{
		EmployeeDAO student = new EmployeeDAO();
		student.setName(rs.getString("name"));
		return student;
	}

}
