package br.com.auxiliar.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoFactory {
	
	
	private static final String DRIVER = "org.postgresql.Driver";   
	   private static final String URL = "jdbc:postgresql://ec2-54-197-241-239.compute-1.amazonaws.com:5432/dfq6q3d6mf2r3p?sslmode=require&sslfactory=org.postgresql.ssl.NonValidatingFactory";   
	   private static final String USERNAME = "temlpbeudtcirk";   
	   private static final String PASSWORD = "3zhrD0MRn9WOPGc-gdOc6ePGKM";   
	
	
	
	public static Connection conexao(){
		Connection connection = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","system");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		
		} catch(SQLException e) {
			e.printStackTrace();
		}

		return connection;
	}
	
	public static Connection conexaoHeroku(){
		
		Connection conn = null;
				
		try {   
			Class.forName(DRIVER);   
		} catch (ClassNotFoundException ex) {   
			System.out.println("Where is your PostgreSQL JDBC Driver? "   
					+ "Include in your library path!");   
			return null;   
		}   
		
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD); 
		
		} catch(SQLException e) {
			e.printStackTrace();
		}
		   
		return conn;   
	}   

	
	
}
