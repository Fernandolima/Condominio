package br.com.webhomebeta.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="[dbo][ESPACO_CONDOMINIO]")
public class EspacoCondominio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_ESPACO_CONDOMINIO")
	private int idEspacoCondominio;
	
	@Column(name = "")
	private String espacoCondominio;

}
