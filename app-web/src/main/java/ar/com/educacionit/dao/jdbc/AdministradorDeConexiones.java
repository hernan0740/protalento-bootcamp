package ar.com.educacionit.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

import ar.com.educacionit.dao.exceptions.GenericException;

public class AdministradorDeConexiones {

	public static Connection obtenerConexion() throws GenericException {
		/* String url = "jdbc:mysql://127.0.0.1:3306/bootcamp_protalento?serverTimezone=UTC&userSSL=false";
		 * String url = "jdbc:mysql://localhost:3306/bootcamp-protalento";
		String user = "root";
		String password = "root";
		String diverName  = "com.mysql.cj.jdbc.Driver";*/
	////////////////conexion heroku-prueba//////////////////////////////////////////////////////////	
		String url = "jdbc:postgresql://ec2-34-238-37-113.compute-1.amazonaws.com:5432/dbhhd4b4oe5u5s";
		String user = "eqtdmabtbggscc";
		String password = "21f4b0e782fae7ecafa1bd9d9fd4e2c6bfab3cebdb096db4dde11df0d2b26b2f";
		String diverName  = "org.postgresql.Driver";
		
		
	///////////////////////////////////////////////////////////////////////////	
		try {
			//com.mysql.cj.jdbc.Driver.class.newInstance();
			Class.forName(diverName);
			Connection connection = DriverManager.getConnection(url, user, password);
			return connection;
		} catch (Exception  e) {
			throw new GenericException("Error oteniendo conexion: " + e.getMessage(),e);
		} 
	}
	
	public static void main(String[] args) {
		
		try (Connection con = AdministradorDeConexiones.obtenerConexion();) {			
			System.out.println("Conexion obtenida");
		}catch (Exception e) {			
			e.printStackTrace();
		}
	}
}
