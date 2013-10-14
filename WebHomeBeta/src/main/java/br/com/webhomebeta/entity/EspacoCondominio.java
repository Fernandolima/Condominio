package br.com.webhomebeta.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "[dbo][ESPACO_CONDOMINIO]")
public class EspacoCondominio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_ESPACO_CONDOMINIO")
	private int idEspaco;

	@Column(name = "ESPACOS")
	private String espaco;
	

	@Column(name = "DESCRICAO")
	private String descricao;
	

	@Column(name = "ID_USER")
	private int idUser;

	@Column(name = "NOME")
	private String nome;
	
	

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
