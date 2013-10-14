package br.com.webhomebeta.to;

import java.sql.Date;

public class MuralTO {
	
	private int idMural;
	private String noticia;
	private int idUser;
	private Date data;
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
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	
	
	
}
