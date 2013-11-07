package br.com.webhomebeta.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="EVENTO_CALENDARIO")
public class CalendarEvent {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;
	
	@Column(name = "TITULO")
	private String title;
	
	@Column(name = "INICIO")
	private Date start;

	@Column(name = "EDITAVEL", columnDefinition = "BOOLEAN")
	private boolean editable;
	
	@Column(name = "APROVADA")
	private boolean aprovada;
	
	@Column(name = "ID_ESPACO")
	private int idEspaco;
	
	@Column(name = "ID_USER")
	private int idUser;

	
	public boolean isAprovada() {
		return aprovada;
	}
	public void setAprovada(boolean aprovada) {
		this.aprovada = aprovada;
	}
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public int getIdEspaco() {
		return idEspaco;
	}
	public void setIdEspaco(int idEspaco) {
		this.idEspaco = idEspaco;
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
	public Date getStart() {
		return start;
	}
	public void setStart(Date start) {
		this.start = start;
	}
	public boolean isEditable() {
		return editable;
	}
	public void setEditable(boolean editable) {
		this.editable = editable;
	}
	
	
	
	
}
