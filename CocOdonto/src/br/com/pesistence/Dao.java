package br.com.pesistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dao {
	
	String password;
	String url;
	String user;
	
public void Conectar() throws ClassNotFoundException, SQLException {
	
	Class.forName("Caminho da Driver.");
	
	Connection con = DriverManager.getConnection(url, user, password);
	
}

			
}
