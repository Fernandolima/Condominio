package br.com.webhomebeta.to;

import java.util.Date;

import br.com.webhomebeta.entity.EspacoCondominio;

public class ReservaTO {

	private int idReserva;
	private String reserva;
	private String preReserva;
	private Date dateReserva;
	private int idUser;
	private String nome;
	private EspacoCondominio condominio;
	

	public String getPreReserva() {
		return preReserva;
	}

	public void setPreReserva(String preReserva) {
		this.preReserva = preReserva;
	}

	public EspacoCondominio getCondominio() {
		return condominio;
	}

	public void setCondominio(EspacoCondominio condominio) {
		this.condominio = condominio;
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

}
