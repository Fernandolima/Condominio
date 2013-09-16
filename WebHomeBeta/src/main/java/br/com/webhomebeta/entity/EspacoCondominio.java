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
	
	@Column(name = "ESPACOS")
	private String espacoCondominio;
	
	@Column(name = "DATA_RESERVA")
	private String dataReserva;
	

	public EspacoCondominio() {
		super();
		this.idEspacoCondominio = idEspacoCondominio;
		this.espacoCondominio = espacoCondominio;
		this.dataReserva = dataReserva;
	}

	/**
	 * @return the dataReserva
	 */
	public String getDataReserva() {
		return dataReserva;
	}

	/**
	 * @param dataReserva the dataReserva to set
	 */
	public void setDataReserva(String dataReserva) {
		this.dataReserva = dataReserva;
	}

	/**
	 * @return the idEspacoCondominio
	 */
	public int getIdEspacoCondominio() {
		return idEspacoCondominio;
	}

	/**
	 * @return the espacoCondominio
	 */
	public String getEspacoCondominio() {
		return espacoCondominio;
	}

	/**
	 * @param idEspacoCondominio the idEspacoCondominio to set
	 */
	public void setIdEspacoCondominio(int idEspacoCondominio) {
		this.idEspacoCondominio = idEspacoCondominio;
	}

	/**
	 * @param espacoCondominio the espacoCondominio to set
	 */
	public void setEspacoCondominio(String espacoCondominio) {
		this.espacoCondominio = espacoCondominio;
	}

}
