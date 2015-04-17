package br.com.entity;


public class Cliente  {
	
	
	private Long idCliente;
	private String nome;
	private String cpf;
	private String identidade;
	private String telefone;
	private String celular;
	private String plano;
	
	
	
	public Cliente() {
		super();
	}
	public Cliente(Long idCliente, String nome, String cpf, String identidade,
			String telefone, String celular, String plano) {
		super();
		idCliente = idCliente;
		this.nome = nome;
		this.cpf = cpf;
		this.identidade = identidade;
		this.telefone = telefone;
		this.celular = celular;
		this.plano = plano;
	}
	public Long getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Long IdCliente) {
		idCliente = IdCliente;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getIdentidade() {
		return identidade;
	}
	public void setIdentidade(String identidade) {
		this.identidade = identidade;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public String getPlano() {
		return plano;
	}
	public void setPlano(String plano) {
		this.plano = plano;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Cliente [IdCliente=");
		builder.append(idCliente);
		builder.append(", nome=");
		builder.append(nome);
		builder.append(", cpf=");
		builder.append(cpf);
		builder.append(", identidade=");
		builder.append(identidade);
		builder.append(", telefone=");
		builder.append(telefone);
		builder.append(", celular=");
		builder.append(celular);
		builder.append(", plano=");
		builder.append(plano);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}

