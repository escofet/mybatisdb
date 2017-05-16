package com.itformacion;

import javax.sql.DataSource;

import org.apache.derby.jdbc.BasicClientDataSource40;

public class SampleDataSourceFactory {
	public static DataSource getSampleDataSource() {
		BasicClientDataSource40 ds = new BasicClientDataSource40();
		ds.setDatabaseName("sample");
		ds.setServerName("localhost");
		ds.setPortNumber(1527);
		ds.setUser("app");
		ds.setPassword("app");
		return ds;
	}
}
