package br.com.webhomebeta.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "[dbo].[INFORMATIVO]")
public class Informativo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_INFORMATIVO")
	private int idInformativo;

	@Column(name = "INFORMATIVO")
	private String informativo;

	@Column (name = "DATA_EXPIRACAO")
	private Date dataExpiracao;
	
	@Column(name = "ID_USER")
	private int idUser;

	@Column(name = "NOME_USER")
	private String nomeUser;

	@Column(name = "DATA_PUBLICACAO")
	private Date dataPublicaco;

	@Column(name = "EMAIL")
	private String email;

	@Column(name = "TITULO")
	private String titulo;
	
	
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Date getDataExpiracao() {
		return dataExpiracao;
	}

	public void setDataExpiracao(Date dataExpiracao) {
		this.dataExpiracao = dataExpiracao;
	}

	public int getIdInformativo() {
		return idInformativo;
	}

	public String getInformativo() {
		return informativo;
	}

	public int getIdUser() {
		return idUser;
	}

	public String getNomeUser() {
		return nomeUser;
	}

	public Date getDataPublicaco() {
		return dataPublicaco;
	}

	public String getEmail() {
		return email;
	}

	public void setIdInformativo(int idInformativo) {
		this.idInformativo = idInformativo;
	}

	public void setInformativo(String informativo) {
		this.informativo = informativo;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public void setNomeUser(String nomeUser) {
		this.nomeUser = nomeUser;
	}

	public void setDataPublicaco(Date dataPublicaco) {
		this.dataPublicaco = dataPublicaco;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
