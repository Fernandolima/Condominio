package br.com.webhomebeta.to;

import java.util.Date;

public class InformativoTO {
	private int idInformativo;
	private String informativo;
	private int idUser;
	private String nomeUser;
	private Date dataPublicaco;
	private String email;

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
