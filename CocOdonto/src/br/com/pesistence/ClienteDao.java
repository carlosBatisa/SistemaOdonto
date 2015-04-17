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

	public List<Cliente> ListaResultado() {
		
		List<Cliente> listar = new ArrayList<Cliente>();
		try{
		while (rs.next()) {
			Cliente c = new Cliente();
			
			c.setID(rs.getLong("IDCLIENTE"));
			c.setNome(rs.getString("nome"));
			c.setTelefone(rs.getString("telefone"));
			c.setCelular(rs.getString("celular"));
			c.setCpf(rs.getString("cpf"));
			c.setPlano(rs.getString("plano"));
			
			System.out.println(c);
			listar.add(c);
		
		}}catch(Exception e ){
			
			System.out.println("ERRO Ao LISTA");
		}
		return listar;
	}
	
	
	public void inserir(Cliente cliente) {
		String sql = "insert into cliente values(nextval('SEQ_IDCLIENTE'),?,?,?,?,?,?)";
		conectar();
		

		try {
			
			stmt = con.prepareStatement(sql);
			
			//stmt.setLong(1, cliente.getID()); retirado a id 
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getCpf());
			stmt.setString(3, cliente.getIdentidade());
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

		String sql = "SELECT * FROM cliente";
		List<Cliente> lista = new ArrayList<Cliente>();
		conectar();

		try {
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			ListaResultado();
		

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println("Consulta com sucesso.");
		fechar();
		//Collections.sort(lista);
		return lista;

	}

	public void excluir(Cliente c) {

		String sql = "delete from Cliente where  idCliente = ?";
		

		conectar();

		try {
			
			stmt = con.prepareStatement(sql);
			stmt.setLong(1,c.getIdCliente());
			
			
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("Erro ao Excluir "+e.getMessage());
			
		}
		
		System.out.println("Excluido com sucesso.");

		fechar();

	}
	
	public List<Cliente> consultarPorNome(Cliente cliente){
		String sql= "select * from cliente where nome like ?";
		List<Cliente> lista = new ArrayList<Cliente>();
		conectar();

		try {
			
				stmt = con.prepareStatement(sql);
				stmt.setString(1,cliente.getNome()+'%');
				rs = stmt.executeQuery();

				ListaResultado();
				
		} catch (SQLException e) {
			System.out.println("Erro ao Consultar por nome  "+e.getMessage());
			
		}
		
		System.out.println("Consultado  com sucesso.");

		fechar();
		//Collections.sort(lista);
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

				ListaResultado();
				
				
		} catch (SQLException e) {
			System.out.println("Erro ao Consultar por Data  "+e.getMessage());
			
		}
		
		System.out.println("Consultado  com sucesso.");

		fechar();
		return lista;
	}

}
