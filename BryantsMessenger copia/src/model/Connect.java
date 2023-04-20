package model;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Connect {

	private String url = "jdbc:mysql://localhost:3306/";
	private String db = "Login";
	private String usuario = "root";
	private String clave = "";

	protected Connection conexion;
	

	public Connect() throws SQLException {

		conexion = DriverManager.getConnection(url+db, usuario, clave);

	}
	
}
