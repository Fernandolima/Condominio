package br.com.webhomebeta.to;

import java.sql.Time;
import java.util.Date;

public class ReservaTO {

	private int idReserva;
	private String reserva;
	private Date dateReserva;
	private int idUser;
	private String nome;
	

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
