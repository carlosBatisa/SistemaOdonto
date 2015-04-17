package test;

import br.com.entity.Cliente;
import br.com.pesistence.ClienteDao;

public class Main {


public static void main(String[] args) {
	
	
	
	Cliente cliente = new Cliente(null, "Carlos", "123456789", "54656564", "21548745", "46464654","unimed..");
	
	
	
	
	
ClienteDao pd = new ClienteDao();
pd.inserir(cliente);
System.out.println("teste de consulta");
pd.consultar();
//pd.excluir(paciente);
	
}

}
