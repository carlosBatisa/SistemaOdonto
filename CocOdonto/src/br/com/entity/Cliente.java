package br.com.entity;


public class Cliente implements Comparable<Cliente>{
	
	
	private String nome;
	private String telefone;
	private String celular;
	private String plano;
	private String data;
	private String Hora;
	
	public Cliente() {
		super();
	}

	public Cliente(String nome, String telefone,
			String celular, String plano, String data, String hora) {
		super();
		
		this.nome = nome;
		this.telefone = telefone;
		this.celular = celular;
		this.plano = plano;
		this.data = data;
		Hora = hora;
	}

	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getHora() {
		return Hora;
	}

	public void setHora(String hora) {
		Hora = hora;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Cliente [nome=");
		builder.append(nome);
		builder.append(", telefone=");
		builder.append(telefone);
		builder.append(", celular=");
		builder.append(celular);
		builder.append(", plano=");
		builder.append(plano);
		builder.append(", data=");
		builder.append(data);
		builder.append(", Hora=");
		builder.append(Hora);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int compareTo(Cliente o) {
		
		return this.data.compareToIgnoreCase(o.data);
	}
	/*
	 * Forma de usar Comparable....
	@Override
	 public int compareTo(Espelho o) {
	        return this.nome.compareTo(o.nome);
	}
	*/

}

