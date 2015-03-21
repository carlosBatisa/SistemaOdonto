package br.com.entity;

public class Contrato {
	
	private Integer idContrato;
	private Paciente contrante;
	private Dentista contratada;
	public Integer getIdContrato() {
		return idContrato;
	}
	public void setIdContrato(Integer idContrato) {
		this.idContrato = idContrato;
	}
	public Paciente getContrante() {
		return contrante;
	}
	public void setContrante(Paciente contrante) {
		this.contrante = contrante;
	}
	public Dentista getContratada() {
		return contratada;
	}
	public void setContratada(Dentista contratada) {
		this.contratada = contratada;
	}
	public Contrato(Integer idContrato, Paciente contrante, Dentista contratada) {
		super();
		this.idContrato = idContrato;
		this.contrante = contrante;
		this.contratada = contratada;
	}
	public Contrato() {
		super();
	}
	
	
	

}
