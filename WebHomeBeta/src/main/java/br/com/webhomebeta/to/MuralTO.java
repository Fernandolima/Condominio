package br.com.webhomebeta.to;

import java.sql.Date;

public class MuralTO {
	
	private int idMural;
	private String noticia;
	private int idUser;
	private String data;
	private String dataAlterada;
	private String titulo;
	
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDataAlterada() {
		return dataAlterada;
	}
	public void setDataAlterada(String dataAlterada) {
		this.dataAlterada = dataAlterada;
	}
	public int getIdMural() {
		return idMural;
	}
	public void setIdMural(int idMural) {
		this.idMural = idMural;
	}
	public String getNoticia() {
		return noticia;
	}
	public void setNoticia(String noticia) {
		this.noticia = noticia;
	}
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	
	
	
}
