package br.com.webhomebeta.json;

import java.util.Date;

public class NovaPublicacaoJSON {
	private int idPublicacao;
	private String publicacao;
	private Date dataPublicacao;
	private int idUsuario;
	private String nome;

	public NovaPublicacaoJSON(int idPublicacao, String publicacao,
			Date dataPublicacao, int idUsuario, String nome) {
		super();
		this.idPublicacao = idPublicacao;
		this.publicacao = publicacao;
		this.dataPublicacao = dataPublicacao;
		this.idUsuario = idUsuario;
		this.nome = nome;
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

	public Date getDataPublicacao() {
		return dataPublicacao;
	}

	public void setDataPublicacao(Date dataPublicacao) {
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
