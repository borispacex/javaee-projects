package com.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	private String jdbcURL;
	private String jdbcUserName;
	private String jdbcPassword;
	
	private Connection jdbcConnection;

	public Conexion(String jdbcURL, String jdbcUserName, String jdbcPassword) {
		this.jdbcURL = jdbcURL;
		this.jdbcUserName = jdbcUserName;
		this.jdbcPassword = jdbcPassword;
	}
	
	public void connection() throws SQLException {
		// validar si la conexion existe
		if (this.jdbcConnection == null || this.jdbcConnection.isClosed()) {
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); // SQL Server
				/// Class.forName("com.mysql.cj.jdbc.Driver"); // MySQL
			} catch (ClassNotFoundException e) {
				throw new SQLException(e);
			}
			this.jdbcConnection = DriverManager.getConnection(jdbcURL, jdbcUserName, jdbcPassword);
		}
	}
	
	public void disconect() throws SQLException {
		if (this.jdbcConnection != null && !this.jdbcConnection.isClosed()) {
			this.jdbcConnection.close();
		}
	}
	
	public Connection getJdbcConnection() {
		return this.jdbcConnection;
	}
}
