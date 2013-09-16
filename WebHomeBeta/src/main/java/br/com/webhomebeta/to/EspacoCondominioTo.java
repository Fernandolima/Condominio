package br.com.webhomebeta.to;

import java.util.ArrayList;
import java.util.Date;

public class EspacoCondominioTo {
	
	private String data;
	
	/**
	 * @return the data
	 */
	public String getData() {
		return data;
	}

	/**
	 * @param data the data to set
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
	 * @param espaco the espaco to set
	 */
	public void setEspaco(ArrayList<String> espaco) {
		this.espaco = espaco;
	}

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

}
