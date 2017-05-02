package com.guang.oracle_ucp_test;

public class EmployeeDAO {
	private int empId;
	private String name;
	private String instanceName;
	private String sessionId;
	private String sid;

	public String getName() {
		return name;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getInstanceName() {
		return instanceName;
	}

	public void setInstanceName(String instanceName) {
		this.instanceName = instanceName;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public void setName(String name) {
		this.name = name;
	}

	
}
