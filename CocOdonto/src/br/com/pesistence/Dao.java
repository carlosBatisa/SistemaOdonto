package br.com.pesistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dao  {
	
	private String password="root";
	private String url="jdbc:mysql://localhost:3306/test";
	private String user="root";
	
	Connection con;
	
public void conectar(){
	
	try {
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection(url, user, password);
		System.out.println("Conectou");
	} catch (ClassNotFoundException e) {
		System.out.println("O Class for name não foi indetificado...");
	} catch (SQLException e) {
		System.out.println("Erro durante a Conexão...");
	}
}

public void fechar(){
	try {
		con.close();
	} catch (SQLException e) {
		System.out.println("Erro ao Fechar conexão...");
	}
	System.out.println("Fechou");
}

			
}
