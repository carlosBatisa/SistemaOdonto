package br.com.entity;

public class Dentista {
	private Integer idDestista;
	private String cro;
	private String cpf;
	private String rg;
	
	private Endereco endereco;
	private Contato contato;
	public Dentista(Integer idDestista, String cro, String cpf, String rg,
			Endereco endereco, Contato contato) {
		super();
		this.idDestista = idDestista;
		this.cro = cro;
		this.cpf = cpf;
		this.rg = rg;
		this.endereco = endereco;
		this.contato = contato;
	}
	public Dentista() {
		super();
	}
	public Integer getIdDestista() {
		return idDestista;
	}
	public void setIdDestista(Integer idDestista) {
		this.idDestista = idDestista;
	}
	public String getCro() {
		return cro;
	}
	public void setCro(String cro) {
		this.cro = cro;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public Contato getContato() {
		return contato;
	}
	public void setContato(Contato contato) {
		this.contato = contato;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Dentista [idDestista=").append(idDestista)
				.append(", cro=").append(cro).append(", cpf=").append(cpf)
				.append(", rg=").append(rg).append(", endereco=")
				.append(endereco).append(", contato=").append(contato)
				.append("]");
		return builder.toString();
	}
	
	
}
