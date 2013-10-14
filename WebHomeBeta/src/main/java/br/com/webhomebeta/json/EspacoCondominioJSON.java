package br.com.webhomebeta.json;

import java.io.Serializable;

public class EspacoCondominioJSON implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4238984521369730851L;
	private String descricao;
	private String novoEspaco;
	private int idUser;
	public EspacoCondominioJSON(String descricao, String novoEspaco, int idUser) {
		super();
		this.descricao = descricao;
		this.novoEspaco = novoEspaco;
		this.idUser = idUser;
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
