package modelo;

import java.sql.Connection;

import java.sql.DriverManager;
public class ConnectionDB {


	Connection conexion = null;
	
		
	public ConnectionDB() {
			try {

				conexion = DriverManager.getConnection("jdbc:mysql://localhost:3307/Concesionario","root","");
				
			} catch (Exception e) {
				System.out.println("Error al cargar");
				e.printStackTrace();
			}
			
		}
	public ConnectionDB(String db) {
		try {
			conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+db,"root","");
			

		} catch (Exception e) {
			System.out.println("Error al cargar");
			e.printStackTrace();
		}
		
	}
	}