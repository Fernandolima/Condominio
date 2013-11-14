package br.com.webhomebeta.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "[dbo].[VISITANTE]")
public class Visitante {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_VISITANTE")
	private int idVisitante;

	@Column(name = "NOME_VISITANTE")
	private String nomeVisitante;

	@Column(name = "PLACA_DO_CARRO")
	private String placaDoCarro;

	@Column(name = "RG")
	private String rg;

	
	@Column(name = "AP")
	private String ap;

	@Column(name = "BLOCO")
	private String bloco;

	@Column(name = "DATA_VISITANTE")
	private String data;
	
			
	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public int getIdVisitante() {
		return idVisitante;
	}

	public String getNomeVisitante() {
		return nomeVisitante;
	}

	public String getPlacaDoCarro() {
		return placaDoCarro;
	}

	public String getRg() {
		return rg;
	}

	public String getAp() {
		return ap;
	}

	public String getBloco() {
		return bloco;
	}

	public void setIdVisitante(int idVisitante) {
		this.idVisitante = idVisitante;
	}

	public void setNomeVisitante(String nomeVisitante) {
		this.nomeVisitante = nomeVisitante;
	}

	public void setPlacaDoCarro(String placaDoCarro) {
		this.placaDoCarro = placaDoCarro;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public void setAp(String ap) {
		this.ap = ap;
	}

	public void setBloco(String bloco) {
		this.bloco = bloco;
	}

}
