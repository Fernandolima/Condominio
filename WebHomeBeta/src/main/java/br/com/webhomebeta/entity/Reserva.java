package br.com.webhomebeta.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "[dbo].[RESERVA]")
public class Reserva {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_RESERVA")
	private int idReserva;

	@Column(name = "RESERVA")
	private String reserva;

	@Column(name = "PRE_RESERVA")
	private String preReserva;

	@Column(name = "DATA_RESERVA")
	private Date dateReserva;

	@Column(name = "ID_USER")
	private int idUser;

	@Column(name = "NOME")
	private String nome;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_ESPACO", nullable = false)
	private EspacoCondominio espacoCondominio;
	
	@Column(name = "ATIVA")
	private boolean ativa;

	

	public Reserva(String reserva, String preReserva, int idUser, String nome,
			EspacoCondominio espacoCondominio, boolean ativa) {
		super();
		this.reserva = reserva;
		this.preReserva = preReserva;
		this.idUser = idUser;
		this.nome = nome;
		this.espacoCondominio = espacoCondominio;
		this.ativa = ativa;
	}

	
	
	public boolean isAtiva() {
		return ativa;
	}

	public void setAtiva(boolean ativa) {
		this.ativa = ativa;
	}

	public String getPreReserva() {
		return preReserva;
	}

	public void setPreReserva(String preReserva) {
		this.preReserva = preReserva;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdReserva() {
		return idReserva;
	}

	public String getReserva() {
		return reserva;
	}

	public Date getDateReserva() {
		return dateReserva;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdReserva(int idReserva) {
		this.idReserva = idReserva;
	}

	public void setReserva(String reserva) {
		this.reserva = reserva;
	}

	public void setDateReserva(Date dateReserva) {
		this.dateReserva = dateReserva;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public EspacoCondominio getEspacoCondominio() {
		return espacoCondominio;
	}

	public void setEspacoCondominio(EspacoCondominio espacoCondominio) {
		this.espacoCondominio = espacoCondominio;
	}

	
}
