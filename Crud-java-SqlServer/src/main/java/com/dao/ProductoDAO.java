package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.conexion.Conexion;
import com.model.Producto;

public class ProductoDAO {
	private Connection connection;
	private PreparedStatement statement;
	private boolean estadoOperacion;
	
	// guardar producto
	public boolean guardar(Producto producto) throws SQLException {
		String sql = null;
		estadoOperacion = false;
		connection = obtenerConexion();
		
		connection.setAutoCommit(false);
		sql = "INSERT INTO productos (nombre,cantidad,precio,fechar_crear,fechar_actualizar) VALUES (?,?,?,?,?)";
		statement.setString(1, producto.getNombre());
		statement.setDouble(2, producto.getCantidad());
		statement.setDouble(3, producto.getPrecio());
		statement.setDate(4, producto.getFechaCrear());
		statement.setDate(5, producto.getFechaActualizar());

		connection.commit();
		return true;
	}
	// editar producto
	public boolean editar(Producto producto) {
			
		return true;
	}
	
	// eliminar producto
	public boolean eliminar(int idProducto) {
			
		return true;
	}
	
	// obtener lista de productos
	public List<Producto> obtenerProductos() {
			
		return null;
	}	
	
	// obtener lista de productos
	public Producto obtenerProducto(int idProducto) {
				
		return null;
	}
	
	// Obtener conexion pool
	private Connection obtenerConexion() throws SQLException {
		return Conexion.getConexion();
	}
}	
