package br.com.webhomebeta.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "[dbo].[ESPACO]")
public class EspacoCondominio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_ESPACO")
	private int idEspaco;

	@Column(name = "ESPACO")
	private String espaco;
	

	@Column(name = "DESCRICAO")
	private String descricao;
	

	@Column(name = "ID_USER")
	private int idUser;

	@Column(name = "NOME")
	private String nome;
	
	@Cascade(CascadeType.REMOVE)
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "espacoCondominio", orphanRemoval = true)
	private Set<Reserva> reservas = new HashSet<>(0);
	
	
	public EspacoCondominio(){
		
	}
	
	
	
	public Set<Reserva> getReservas() {
		return reservas;
	}



	public void setReservas(Set<Reserva> reservas) {
		this.reservas = reservas;
	}



	public EspacoCondominio(int idEspaco){
		this.idEspaco = idEspaco;
	}
	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public int getIdEspaco() {
		return idEspaco;
	}

	public String getEspaco() {
		return espaco;
	}

	public int getIdUser() {
		return idUser;
	}

	public String getNome() {
		return nome;
	}

	public void setIdEspaco(int idEspaco) {
		this.idEspaco = idEspaco;
	}

	public void setEspaco(String espaco) {
		this.espaco = espaco;
	}

	
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
