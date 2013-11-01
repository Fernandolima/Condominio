package br.com.webhomebeta.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "[dbo].[MURAL]")
public class Mural {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_MURAL")
	private int idMural;
	@Column(name = "NOTICIA")
	private String noticia;
	@Column(name = "ID_USER")
	private int idUser;
	@Column(name = "DATA")
	
	private String data;
	@Column(name= "DATA_ALTERADA")
	
	private String dataAlterada;
	
	

	public String getDataAlterada() {
		return dataAlterada;
	}

	public void setDataAlterada(String dataAlterada) {
		this.dataAlterada = dataAlterada;
	}

	public int getIdMural() {
		return idMural;
	}

	public String getNoticia() {
		return noticia;
	}

	public int getIdUser() {
		return idUser;
	}

	public String getData() {
		return data;
	}

	public void setIdMural(int idMural) {
		this.idMural = idMural;
	}

	public void setNoticia(String noticia) {
		this.noticia = noticia;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public void setData(String data) {
		this.data = data;
	}

}
