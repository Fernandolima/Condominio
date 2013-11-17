package br.com.webhomebeta.json;

import java.util.Date;

import org.joda.time.DateTime;

public class CalendarEventJSON {

	private int id;
	private String title;
	private String start;
	private boolean editable;
	private String nomeEspaco;
	private String nome;
	private int idUser;
	private boolean aprovada;
	
	
	
	public CalendarEventJSON(int id, String title, String start,
			boolean editable, String nomeEspaco, String nome, int idUser,
			boolean aprovada) {
		super();
		this.id = id;
		this.title = title;
		this.start = start;
		this.editable = editable;
		this.nomeEspaco = nomeEspaco;
		this.nome = nome;
		this.idUser = idUser;
		this.aprovada = aprovada;
	}


	public CalendarEventJSON(int id, String title, String start,
			boolean editable, String nomeEspaco) {
		super();
		this.id = id;
		this.title = title;
		this.start = start;
		this.editable = editable;
		this.nomeEspaco = nomeEspaco;
	}
	
	
	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public int getIdUser() {
		return idUser;
	}


	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}


	public boolean isAprovada() {
		return aprovada;
	}


	public void setAprovada(boolean aprovada) {
		this.aprovada = aprovada;
	}


	public String getNomeEspaco() {
		return nomeEspaco;
	}
	public void setNomeEspaco(String nomeEspaco) {
		this.nomeEspaco = nomeEspaco;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public boolean isEditable() {
		return editable;
	}
	public void setEditable(boolean editable) {
		this.editable = editable;
	}
	
}
