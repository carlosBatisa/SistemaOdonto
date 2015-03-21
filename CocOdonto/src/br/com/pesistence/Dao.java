package br.com.pesistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dao  {
	
	private String password;
	private String url;
	private String user;
	
	Connection con;
	
public void conectar() throws ClassNotFoundException, SQLException {
	
	Class.forName("Caminho da Driver.");
	
	con = DriverManager.getConnection(url, user, password);
	
}

public void fechar() throws SQLException{
	con.close();
}

			
}
