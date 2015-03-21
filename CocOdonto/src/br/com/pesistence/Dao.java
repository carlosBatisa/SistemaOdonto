package br.com.pesistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dao  {
	
	private String password="root";
	private String url="jdbc:mysql://localhost:3306/test";
	private String user="root";
	
	Connection con;
	
public void conectar() throws ClassNotFoundException, SQLException {
	
	Class.forName("com.mysql.jdbc.Driver");	
	con = DriverManager.getConnection(url, user, password);
	System.out.println("Conectou");
	
}

public void fechar() throws SQLException{
	con.close();
	System.out.println("Fechou");
}

			
}
