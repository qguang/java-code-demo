package com.guang.oracle_ucp_test;

import java.sql.SQLException;

import javax.sql.DataSource;

import oracle.jdbc.pool.OracleDataSource;
import oracle.ucp.jdbc.PoolDataSource;
import oracle.ucp.jdbc.PoolDataSourceFactory;
import oracle.ucp.jdbc.PoolDataSourceImpl;

public class UcpDataSource {
	public DataSource dataSource() throws SQLException {
		PoolDataSourceFactory factory = new oracle.ucp.jdbc.PoolDataSourceFactory();
		PoolDataSource dataSource = factory.getPoolDataSource();
		dataSource.setConnectionFactoryClassName("oracle.jdbc.replay.OracleDataSourceImpl");
		dataSource.setONSConfiguration("ZZ");
		dataSource.setURL("jdbc:oracle:thin:@//127.0.0.1:1530/ggbw_vm_pdb.cba.com.au" );
		dataSource.setUser("ucp_user");
		dataSource.setPassword("ucp_user");
		dataSource.setInitialPoolSize(2);
		dataSource.setMaxPoolSize(5);
		dataSource.setFastConnectionFailoverEnabled(true);
		
		//dataSource.setTimeoutCheckInterval(30); // default is 30
		//dataSource.setConnectionWaitTimeout(3) ; // 3 is default
		//in a hope that this is equivalent to CONNECT_TIMEOUT in tnsnames entry
		//dataSource.setLoginTimeout(120);
		//RETRY_COUNT?? and RETRY_DELAY??
		
		return dataSource;
	}
}
