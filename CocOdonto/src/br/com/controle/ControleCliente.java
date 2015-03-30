package br.com.controle;

import br.com.entity.Cliente;
import br.com.pesistence.ClienteDao;

public class ControleCliente {
	ClienteDao mClienteDao;
	

public void cadastrarCliente(Cliente cliente){
	
	mClienteDao= new ClienteDao();	
	mClienteDao.inserir(cliente);
	
	
}

public void excluirConsulta(Cliente cliente){
	
	mClienteDao= new ClienteDao();
	mClienteDao.excluir(cliente);
	
}

public void pesquisarPorNome(Cliente cliente){
	
	mClienteDao= new ClienteDao();
	mClienteDao.consultarPorNome(cliente);
	
}
public void pesquisarPorData(Cliente cliente){
	
	mClienteDao= new ClienteDao();
	mClienteDao.consultarPorData(cliente);
	
}

}
