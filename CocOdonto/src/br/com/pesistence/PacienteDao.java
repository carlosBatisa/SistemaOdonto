package br.com.pesistence;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.entity.Paciente;

public class PacienteDao extends Dao{
	PreparedStatement stmt;	
	ResultSet rs;
	
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
	
	public List<Paciente> consultar () throws SQLException, ClassNotFoundException{
		String sql="Select * from paciente";
		List<Paciente> lista = new ArrayList<Paciente>();
		conectar();
		
		stmt = con.prepareStatement(sql);
		rs = stmt.executeQuery();
		
		while (rs.next()) {
			Paciente p = new Paciente();
			p.setIdClinte(rs.getString("idcliente"));
			p.setNome(rs.getString("nome"));
			p.setRg(rs.getString("rg"));
			p.setCpf(rs.getString("cpf"));
			lista.add(p);
			
			
		}
		
		
		for (Paciente paciente : lista) {
		
			System.out.println(paciente);
		}
			
				
		System.out.println("Consulta com sucesso.");
		
		fechar();
		return lista;
		
	}
}
