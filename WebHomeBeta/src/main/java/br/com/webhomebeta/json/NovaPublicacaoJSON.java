package br.com.webhomebeta.json;

import java.util.Date;

public class NovaPublicacaoJSON {
	
	private int idPublicacao;
	private String publicacao;
	private String dataPublicacao;
	private int idUsuario;
	private String nome;
	private String caminhoImg;

	public NovaPublicacaoJSON(int idPublicacao, String publicacao,
			String dataPublicacao, int idUsuario, String nome) {
		this.idPublicacao = idPublicacao;
		this.publicacao = publicacao;
		this.dataPublicacao = dataPublicacao;
		this.idUsuario = idUsuario;
		this.nome = nome;
	}
	
	

	public NovaPublicacaoJSON(int idPublicacao, String publicacao,
			String dataPublicacao, int idUsuario, String nome, String caminhoImg) {
		this.idPublicacao = idPublicacao;
		this.publicacao = publicacao;
		this.dataPublicacao = dataPublicacao;
		this.idUsuario = idUsuario;
		this.nome = nome;
		this.caminhoImg = caminhoImg;
	}



	public String getCaminhoImg() {
		return caminhoImg;
	}



	public void setCaminhoImg(String caminhoImg) {
		this.caminhoImg = caminhoImg;
	}



	public int getIdPublicacao() {
		return idPublicacao;
	}

	public void setIdPublicacao(int idPublicacao) {
		this.idPublicacao = idPublicacao;
	}

	public String getPublicacao() {
		return publicacao;
	}

	public void setPublicacao(String publicacao) {
		this.publicacao = publicacao;
	}
	
	

	/**
	 * @return the dataPublicacao
	 */
	public String getDataPublicacao() {
		return dataPublicacao;
	}



	/**
	 * @param dataPublicacao the dataPublicacao to set
	 */
	public void setDataPublicacao(String dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}



	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
