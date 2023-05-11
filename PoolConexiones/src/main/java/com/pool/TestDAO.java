package com.pool;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class TestDAO {
	private Connection connection = null;;
	
	public TestDAO() {
		// Vacio
	}
	
	public boolean registrar(Articulo a) throws SQLException{
		boolean estado = false;
		Statement stm;

		connection = getConnection();

		String sqlArticulos = "INSERT INTO articulos (nombre,descripcion,precio) VALUES ('" + a.getNombre() + "','" + a.getDescripcion() + "',"
				+ a.getPrecio() + ")";

		try {
			connection.setAutoCommit(false); // le indicamos el inicio de la transacción
			stm = connection.createStatement();
			stm.executeUpdate(sqlArticulos);
			connection.commit(); // si todo va bien hacemos commit y guardamos los datos
			estado = true;
			stm.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			try {
				estado = false;
				connection.rollback(); // si algo pasó en la transacción hacemos roollback y no se guarda
										// ningun registro
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return estado;
	}
	
	// Accede a la conexion de la clase pool
	private Connection getConnection() throws SQLException {
		return Pool.getConexion();
	}
}

