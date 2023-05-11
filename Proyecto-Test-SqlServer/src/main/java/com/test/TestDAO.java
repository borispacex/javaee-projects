package com.test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.test.modelos.Articulo;

public class TestDAO {
	private Conexion con;
	
	public TestDAO(String jdbcURL, String jdbcUserName, String jdbcPassword) throws SQLException {
		this.con = new Conexion(jdbcURL,jdbcUserName,jdbcPassword);
		this.con.connection();
		System.out.println("CONEXION: " + this.con.getJdbcConnection());
	}
	
	public boolean registrar(Articulo a) {
		boolean estado = false;
		Statement stm;
		
		String sql = "INSERT INTO articulos (nombre,descripcion,precio) VALUES ('" + 
				a.getNombre() + "','" + a.getDecripcion() + "'," + a.getPrecio()  + ")";
		try {
			con.connection();
			con.getJdbcConnection().setAutoCommit(false); // Le indicamos el inicio de la transaccion
			stm = con.getJdbcConnection().createStatement();
			stm.executeUpdate(sql);
			con.getJdbcConnection().commit(); // Si todo va bien hacemos commit y guardamos los datos
			estado = true;
			stm.close();
			con.disconect();
		} catch (SQLException e) {
			try {
				estado = false;
				con.getJdbcConnection().rollback();	// Si algo paso en la transaccion hacemos rollback y no se guarda ningun registro
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return estado;
	}
	
	public boolean editar(Articulo a) {
		boolean estado = false;
		Statement stm;
		
		String sql = "UPDATE articulos SET nombre='" + a.getNombre() + "', descripcion='"+ a.getDecripcion() + "', precio=" 
				+ a.getPrecio() + " WHERE id=" + a.getId();
		try {
			con.connection();
			stm = con.getJdbcConnection().createStatement();
			stm.execute(sql);
			estado = true;
			stm.close();
			con.disconect();
		} catch (SQLException e) {
			estado = false;
			e.printStackTrace();
		}
		
		return estado;
	}
	
	public boolean eliminar(Articulo a) {
		boolean estado = false;
		Statement stm;
		
		String sql = "DELETE FROM articulos WHERE id=" + a.getId();
		
		try {
			con.connection();
			stm = con.getJdbcConnection().createStatement();
			stm.execute(sql);
			estado = true;
			stm.close();
			con.disconect();
		} catch (SQLException e) {
			estado = false;
			e.printStackTrace();
		}
		
		return estado;
	}
	
	public void obtenerArticulos() {
		Statement stm;
		Articulo a;
		ResultSet res = null;
		
		String sql = "SELECT * FROM articulos";
		
		try {
			con.connection();
			stm = con.getJdbcConnection().createStatement();
			res = stm.executeQuery(sql);
			while(res.next()) {
				a = new Articulo(res.getInt("id"), res.getString("nombre"),res.getString("descripcion"),res.getDouble("precio"));
				System.out.println(a);
			}
			stm.close();
			con.disconect();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void obtenerArticulo(int id) {
		Statement stm;
		Articulo a;
		ResultSet res = null;
		
		String sql = "SELECT * FROM articulos WHERE id=" + id;
		
		try {
			con.connection();
			stm = con.getJdbcConnection().createStatement();
			res = stm.executeQuery(sql);
			if(res.next()) {
				a = new Articulo(res.getInt("id"), res.getString("nombre"),res.getString("descripcion"),res.getDouble("precio"));
				System.out.println(a);
			}
			stm.close();
			con.disconect();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
