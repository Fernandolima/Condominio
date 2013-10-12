package br.com.webhomebeta.json;

import java.util.List;

public class EnqueteJSON {

	private String titulo;
	private int idEnquete;
	private int idUser;
	private List<OpcaoJSON> opcoes;
	private int totalVotos;

	
	public EnqueteJSON(String titulo, int idEnquete, int idUser, int totalVotos) {
		super();
		this.titulo = titulo;
		this.idEnquete = idEnquete;
		this.idUser = idUser;
		this.totalVotos = totalVotos;
	}

	public int getTotalVotos() {
		return totalVotos;
	}

	public void setTotalVotos(int totalVotos) {
		this.totalVotos = totalVotos;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getIdEnquete() {
		return idEnquete;
	}

	public void setIdEnquete(int idEnquete) {
		this.idEnquete = idEnquete;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public List<OpcaoJSON> getOpcoes() {
		return opcoes;
	}

	public void setOpcoes(List<OpcaoJSON> opcoes) {
		this.opcoes = opcoes;
	}

}
