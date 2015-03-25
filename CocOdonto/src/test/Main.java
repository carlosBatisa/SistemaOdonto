package test;

import java.sql.SQLException;

import br.com.entity.Paciente;
import br.com.pesistence.PacienteDao;

public class Main {


public static void main(String[] args) {
	Paciente paciente = new Paciente();
	paciente.setIdClinte("12345");
	paciente.setNome("Carlos");
	paciente.setRg("7987564321");
	paciente.setCpf("123456789000");
PacienteDao pd = new PacienteDao();
try {
	
	pd.inserir(paciente);
	System.out.println("teste de consulta");
	pd.consultar();
	
} catch (ClassNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (SQLException e) {
	
	System.out.println(e.getMessage());
}
	
}

}
