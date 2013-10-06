package br.com.webhomebeta.to;

import java.util.ArrayList;
import java.util.Date;

public class EspacoCondominioTo {

	private String data;
	private int idEspaco;
	private String novoEspaco;
	private String quatEspaco;
	private boolean ativa;
	private int idReserva;
	private int idUser;
	private String nome;

	public EspacoCondominioTo() {
		espaco.add("Piscina");
		espaco.add("Salão de festa");
		espaco.add("Quadra poliesportiva");
		espaco.add("Hipicas");
		espaco.add("Campo de golf");
		espaco.add("Salão de jogos");
		espaco.add("Hidromassagem");
		espaco.add("Quadra de futebol");
		espaco.add("Quadra de vôlei de areia");
		espaco.add("Quadra de basquete");
		espaco.add("Pista de cooper");
		espaco.add("Cinema");
		espaco.add("Academina");
		espaco.add("Área exclusiva para cachorros");
		espaco.add("Vagas para visitantes");
		espaco.add("Churrasqueira");

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

	/**
	 * @param espaco
	 *            the espaco to set
	 */
	public void setEspaco(ArrayList<String> espaco) {
		this.espaco = espaco;
	}

	public int getIdEspaco() {
		return idEspaco;
	}

	public String getNovoEspaco() {
		return novoEspaco;
	}

	public String getQuatEspaco() {
		return quatEspaco;
	}

	public boolean isAtiva() {
		return ativa;
	}

	public int getIdReserva() {
		return idReserva;
	}

	public int getIdUser() {
		return idUser;
	}

	public String getNome() {
		return nome;
	}

	public void setIdEspaco(int idEspaco) {
		this.idEspaco = idEspaco;
	}

	public void setNovoEspaco(String novoEspaco) {
		this.novoEspaco = novoEspaco;
	}

	public void setQuatEspaco(String quatEspaco) {
		this.quatEspaco = quatEspaco;
	}

	public void setAtiva(boolean ativa) {
		this.ativa = ativa;
	}

	public void setIdReserva(int idReserva) {
		this.idReserva = idReserva;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	
}
