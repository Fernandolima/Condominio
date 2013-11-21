package br.com.webhomebeta.to;

import java.util.Date;

public class InformativoTO {
	private int idInformativo;
	private String informativo;
	private int idUser;
	private String nomeUser;
	private String dataPublicaco;
	private String email;
	private Date dataExpiracao;
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

	public String getDataPublicaco() {
		return dataPublicaco;
	}

	public void setDataPublicaco(String dataPublicaco) {
		this.dataPublicaco = dataPublicaco;
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


	public void setEmail(String email) {
		this.email = email;
	}

}
