package br.com.entity;

public class Plano {
	private Integer idPlano;
	private String nomePlano;
	
	
	public Integer getIdPlano() {
		return idPlano;
	}
	public void setIdPlano(Integer idPlano) {
		this.idPlano = idPlano;
	}
	public String getNomePlano() {
		return nomePlano;
	}
	public void setNomePlano(String nomePlano) {
		this.nomePlano = nomePlano;
	}
	public Plano(Integer idPlano, String nomePlano) {
		super();
		this.idPlano = idPlano;
		this.nomePlano = nomePlano;
	}
	
	
}
