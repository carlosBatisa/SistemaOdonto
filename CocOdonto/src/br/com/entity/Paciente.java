package br.com.entity;

public class Paciente {
	private Long idCliente;
	private String nome;
	private String rg;
	private String cpf;
	private SexoType sexo;	
	private Endereco endereco; 	
	private Contato contatos;
	public Paciente(Long idClinte, String nome, String rg, String cpf,
			SexoType sexo, Endereco endereco, Contato contatos) {
		super();
		this.idCliente = idClinte;
		this.nome = nome;
		this.rg = rg;
		this.cpf = cpf;
		this.sexo = sexo;
		this.endereco = endereco;
		this.contatos = contatos;
	}
	public Paciente() {
		super();
	}
	public Long getIdClinte() {
		return idCliente;
	}
	public void setIdClinte(Long idClinte) {
		this.idCliente = idClinte;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public SexoType getSexo() {
		return sexo;
	}
	public void setSexo(SexoType sexo) {
		this.sexo = sexo;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public Contato getContatos() {
		return contatos;
	}
	public void setContatos(Contato contatos) {
		this.contatos = contatos;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Paciente [idClinte=").append(idCliente)
				.append(", nome=").append(nome).append(", rg=").append(rg)
				.append(", cpf=").append(cpf).append(", sexo=").append(sexo)
				.append(", endereco=").append(endereco).append(", contatos=")
				.append(contatos).append("]");
		return builder.toString();
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idCliente == null) ? 0 : idCliente.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Paciente other = (Paciente) obj;
		if (idCliente == null) {
			if (other.idCliente != null)
				return false;
		} else if (!idCliente.equals(other.idCliente))
			return false;
		return true;
	}


}

