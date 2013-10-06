package br.com.webhomebeta.entity;

import java.sql.Time;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "[dbo][RESERVA]")
public class Reserva {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_RESERVA")
	private int idReserva;

	@Column(name = "RESERVA")
	private String reserva;


	@Column(name = "DATA_RESERVA")
	private Date dateReserva;

	@Column(name = "ID_USER")
	private int idUser;

	@Column(name = "NOME")
	private String nome;

	public Reserva(String reserva, Date dateReserva, String nome) {
		super();
		this.reserva = reserva;
		this.dateReserva = dateReserva;
		this.nome = nome;
		

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
