package br.com.webhomebeta.to;

import java.util.ArrayList;
import java.util.Date;

public class EspacoCondominioTo {

	private String data;
	private String descricao;
	private String novoEspaco;
	private int idUser;
	private String nome;

	
	
	
	public EspacoCondominioTo(ArrayList<String> espaco) {
		super();
		this.espaco = espaco;
	}
	public EspacoCondominioTo() {
	
	}

	/**
	 * @return the data
	 */
	public String getData() {
		return data;
	}

	/**
	 * @param data
	 *            the data to set
	 */
	public void setData(String data) {
		this.data = data;
	}

	ArrayList<String> espaco = new ArrayList<>();

	/**
	 * @return the espaco
	 */
	public ArrayList<String> getEspaco() {
		return espaco;
	}

	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	/**
	 * @param espaco
	 *            the espaco to set
	 */
	public void setEspaco(ArrayList<String> espaco) {
		this.espaco = espaco;
	}

	public String getNovoEspaco() {
		return novoEspaco;
	}

	public int getIdUser() {
		return idUser;
	}

	public String getNome() {
		return nome;
	}

	public void setNovoEspaco(String novoEspaco) {
		this.novoEspaco = novoEspaco;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
