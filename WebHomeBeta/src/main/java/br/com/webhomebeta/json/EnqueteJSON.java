package br.com.webhomebeta.json;

import java.util.ArrayList;
import java.util.List;

public class EnqueteJSON {

	private String enquete;
	private int idEnquete;
	private int idUser;
	private List<OpcaoJSON> opcoes;
	private int totalVotos;
	private List<Integer> idVoto = new ArrayList<>();
	private boolean erro;

	
	public EnqueteJSON(int idEnquete, int idUser, int totalVotos, String enquete) {
		super();
		this.idEnquete = idEnquete;
		this.idUser = idUser;
		this.totalVotos = totalVotos;
		this.enquete = enquete;
	}
	
	
	
	
	public EnqueteJSON(boolean erro) {
		super();
		this.erro = erro;
	}




	public boolean isErro() {
		return erro;
	}




	public void setErro(boolean erro) {
		this.erro = erro;
	}




	public String getEnquete() {
		return enquete;
	}



	public void setEnquete(String enquete) {
		this.enquete = enquete;
	}



	public List<Integer> getIdVoto() {
		return idVoto;
	}

	public void setIdVoto(List<Integer> idVoto) {
		this.idVoto = idVoto;
	}


	public int getTotalVotos() {
		return totalVotos;
	}

	public void setTotalVotos(int totalVotos) {
		this.totalVotos = totalVotos;
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
