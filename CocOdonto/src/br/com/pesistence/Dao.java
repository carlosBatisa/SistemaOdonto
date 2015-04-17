package br.com.pesistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dao  {
	
	private String password="root";
	//private String url="jdbc:mysql://localhost:3306/test";
	
	private String url="jdbc:h2:libs//basededados";
	private String user="sa";
	
	Connection con;
	
public void conectar(){
	/*
	 * Conexao mysql....
	 * 
	try { 
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection(url, user, password);
		System.out.println("Conectou");
	} catch (ClassNotFoundException e) {
		System.out.println("O Class for name n�o foi indetificado...");
	} catch (SQLException e) {
		System.out.println("Erro durante a Conex�o...");
	}
	*/

	try {
		Class.forName("org.h2.Driver");
		con = DriverManager.getConnection(url, user,"");
		System.out.println("Conectou");
	} catch (ClassNotFoundException e) {
		System.out.println("O Class for name n�o foi indetificado...");
	} catch (SQLException e) {
		System.out.println("Erro durante a Conex�o..."
				+ e.getMessage());
	}



}



public void fechar(){
	try {
		con.close();
	} catch (SQLException e) {
		System.out.println("Erro ao Fechar conex�o...");
	}
	System.out.println("Fechou");
}

			
}
