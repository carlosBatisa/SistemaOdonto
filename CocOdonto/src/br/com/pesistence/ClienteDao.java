package br.com.pesistence;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.entity.Cliente;

public class ClienteDao extends Dao {
	PreparedStatement stmt;
	ResultSet rs;

	public void inserir(Cliente cliente) {
		String sql = "insert into cliente values(?,?,?,?,?,?)";
		conectar();

		try {
			
			stmt = con.prepareStatement(sql);
			
			stmt.setString(1, cliente.getData());
			stmt.setString(2, cliente.getHora());
			stmt.setString(3, cliente.getNome());
			stmt.setString(4, cliente.getTelefone());
			stmt.setString(5, cliente.getCelular());
			stmt.setString(6, cliente.getPlano());
						
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("Erro no codigo sql de inserção."
					+ e.getMessage());

		}

		System.out.println("Salvo com sucesso.");

		fechar();

	}

	public List<Cliente> consultar() {
		/*/String sql = "Select * from cliente";
		SELECT "nome_coluna"
		FROM "nome_tabela"
		[WHERE "condição"]
		ORDER BY "nome_coluna" [ASC, DESC], "nome_coluna2" [ASC, DESC];
		
		
		String sql = "SELECT * FROM cliente ORDER BY data desc, hora";
		*/
		String sql = "SELECT*, str_to_date(data, '%d/%m/%Y') AS data FROM cliente ORDER BY data desc";
		
		List<Cliente> lista = new ArrayList<Cliente>();
		conectar();

		try {
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();

			while (rs.next()) {
				Cliente p = new Cliente();
				
				p.setNome(rs.getString("nome"));
				p.setTelefone(rs.getString("telefone"));
				p.setCelular(rs.getString("celular"));
				p.setData(rs.getString("data"));
				p.setHora(rs.getString("hora"));
				p.setPlano(rs.getString("plano"));
				
				//System.out.println(p);
				lista.add(p);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/* 
		 * Teste de Consulta....
		for (Paciente paciente : lista) {

			System.out.println(paciente);
		}		
		
		 */
		
		System.out.println("Consulta com sucesso.");
		fechar();
		//Collections.sort(lista);
		return lista;

	}

	public void excluir(Cliente p) {

		String sql = "delete from Cliente where  data = ? and hora = ?";
		

		conectar();

		try {
			
			stmt = con.prepareStatement(sql);
			stmt.setString(1,p.getData());
			stmt.setString(2,p.getHora());
			
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("Erro ao Excluir "+e.getMessage());
			
		}
		
		System.out.println("Excluido com sucesso.");

		fechar();

	}
	
	public List<Cliente> consultarPorNome(Cliente cliente){
		String sql= "select * from cliente where nome = ?";
		List<Cliente> lista = new ArrayList<Cliente>();
		conectar();

		try {
			
				stmt = con.prepareStatement(sql);
				stmt.setString(1,cliente.getNome());
				rs = stmt.executeQuery();

				while (rs.next()) {
					Cliente p = new Cliente();
					
					p.setNome(rs.getString("nome"));
					p.setTelefone(rs.getString("telefone"));
					p.setCelular(rs.getString("celular"));
					p.setData(rs.getString("data"));
					p.setHora(rs.getString("hora"));
					p.setPlano(rs.getString("plano"));
					
					System.out.println(p);
					lista.add(p);			
			
				}
		} catch (SQLException e) {
			System.out.println("Erro ao Consultar por nome  "+e.getMessage());
			
		}
		
		System.out.println("Consultado  com sucesso.");

		fechar();
		Collections.sort(lista);
		return lista;
	}
	
	public List<Cliente> consultarPorData(Cliente cliente){
		
		String sql= "select * from cliente where data = ?";
		List<Cliente> lista = new ArrayList<Cliente>();
		conectar();

		try {
			
				stmt = con.prepareStatement(sql);
				stmt.setString(1,cliente.getData());
				rs = stmt.executeQuery();

				while (rs.next()) {
					Cliente p = new Cliente();
					
					p.setNome(rs.getString("nome"));
					p.setTelefone(rs.getString("telefone"));
					p.setCelular(rs.getString("celular"));
					p.setData(rs.getString("data"));
					p.setHora(rs.getString("hora"));
					p.setPlano(rs.getString("plano"));
					
					System.out.println(p);
					lista.add(p);			
			
				}
		} catch (SQLException e) {
			System.out.println("Erro ao Consultar por nome  "+e.getMessage());
			
		}
		
		System.out.println("Consultado  com sucesso.");

		fechar();
		return lista;
	}

}
