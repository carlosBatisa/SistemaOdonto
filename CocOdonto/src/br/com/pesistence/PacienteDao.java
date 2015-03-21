package br.com.pesistence;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.entity.Paciente;

public class PacienteDao extends Dao{
	PreparedStatement stmt;
	String sql="insert into paciente(idcliente,nome,rg,cpf) values(?,?,?,?)";
	
	
	public void inserir (Paciente paciente) throws SQLException, ClassNotFoundException{
		conectar();
		
		stmt = con.prepareStatement(sql);
		
		stmt.setString(1, paciente.getIdClinte());
		System.out.println("passo1");
		stmt.setString(2, paciente.getNome());
		System.out.println("passo1");
		stmt.setString(3, paciente.getRg());
		System.out.println("passo1");
		stmt.setString(4, paciente.getCpf());
		System.out.println("passo4");
		stmt.executeUpdate();
		System.out.println("passo1");
		
		fechar();
		
	}
}
