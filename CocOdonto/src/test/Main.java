package test;

import br.com.entity.Cliente;
import br.com.pesistence.ClienteDao;

public class Main {


public static void main(String[] args) {
	Cliente cliente = new Cliente();
	
	
	cliente.setData("25/03/2015");

	cliente.setHora("22:11");
	cliente.setNome("Carlos de Souza Batista");
	cliente.setTelefone("2138863012");
	cliente.setCelular("21976588177");
	cliente.setPlano("Unimed-Rio");
	
	
ClienteDao pd = new ClienteDao();
pd.inserir(cliente);
System.out.println("teste de consulta");
pd.consultar();
//pd.excluir(paciente);
	
}

}
