package br.com.webhomebeta.json;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

public class EspacoCondominioJSON implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4238984521369730851L;
	private String descricao;
	private String novoEspaco;
	private int idUser;
	private int idEspaco;
	
	

	public int getIdEspaco() {
		return idEspaco;
	}

	public void setIdEspaco(int idEspaco) {
		this.idEspaco = idEspaco;
	}

	public String getDescricao() {
		return descricao;
	}

	public String getNovoEspaco() {
		return novoEspaco;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setNovoEspaco(String novoEspaco) {
		this.novoEspaco = novoEspaco;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

}
