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
	@Temporal(value = TemporalType.DATE)
	private Date data;
	
}
