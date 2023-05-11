package com.conexion;

import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;

public class Conexion {
	private static BasicDataSource dataSource =null;
	
	public static DataSource getDataSource() {
		if (dataSource == null) {
			dataSource = new BasicDataSource();
			dataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			dataSource.setUsername("borisv");
			dataSource.setPassword("borisv");
			dataSource.setUrl("jdbc:sqlserver://DESKTOP-V3E5ICQ\\MSSQLSERVERDEV;encrypt=true;trustServerCertificate=true;databaseName=Testjava");
			// Definimos el tamaño del pool de conexiones
			dataSource.setInitialSize(20);
			dataSource.setMaxIdle(15);
			dataSource.setMaxIdle(20);
			dataSource.setMaxWaitMillis(5000);
		}
		return dataSource;
	}
	
	public static Connection getConexion() throws SQLException{
		return getDataSource().getConnection();
	}
}
