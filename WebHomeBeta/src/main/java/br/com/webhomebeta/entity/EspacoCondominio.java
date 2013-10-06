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
	private int idEspaco;
	
	@Column(name = "ESPACOS")
	private String espaco;
	
	@Column(name = "QUAT_ESPACO")
	private String quatEspaco;
	
	@Column(name = "ATIVA")
	private boolean ativa;
	
	@Column(name = "ID_RESERVA")
	private int idReserva;
	
	@Column(name = "ID_USER")
	private int idUser;
	
	@Column(name = "NOME")
	private String nome;
	
	
	

	public EspacoCondominio(String espaco, String quatEspaco, boolean ativa,
			String nome) {
		super();
		this.espaco = espaco;
		this.quatEspaco = quatEspaco;
		this.ativa = ativa;
		this.nome = nome;
	}

	public int getIdEspaco() {
		return idEspaco;
	}

	public String getEspaco() {
		return espaco;
	}

	public String getQuatEspaco() {
		return quatEspaco;
	}

	public boolean isAtiva() {
		return ativa;
	}

	public int getIdReserva() {
		return idReserva;
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

	public void setQuatEspaco(String quatEspaco) {
		this.quatEspaco = quatEspaco;
	}

	public void setAtiva(boolean ativa) {
		this.ativa = ativa;
	}

	public void setIdReserva(int idReserva) {
		this.idReserva = idReserva;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	
	

	
}
