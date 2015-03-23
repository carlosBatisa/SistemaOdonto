package br.com.pesistence;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.entity.Paciente;

public class PacienteDao extends Dao{
	PreparedStatement stmt;	
	
	public void inserir (Paciente paciente) throws SQLException, ClassNotFoundException{
		String sql="insert into paciente(idcliente,nome,rg,cpf) values(?,?,?,?)";
		
		conectar();
		
		stmt = con.prepareStatement(sql);
		
		stmt.setString(1, paciente.getIdClinte());		
		stmt.setString(2, paciente.getNome());
		stmt.setString(3, paciente.getRg());		
		stmt.setString(4, paciente.getCpf());
		
		stmt.executeUpdate();
		System.out.println("Salvo com sucesso.");
		
		fechar();
		
	}
}
