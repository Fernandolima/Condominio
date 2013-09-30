package br.com.webhomebeta.entity;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class NaoGostou {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_NAOGOSTOU")
	private int id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_PUBLICACAO", nullable = false)
	private Publicacao publicacao;

	@Column(name = "ID_USER")
	private int idUsuario;

	public NaoGostou(Publicacao publicacao, int idUsuario) {
		super();
		this.publicacao = publicacao;
		this.idUsuario = idUsuario;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Publicacao getPublicacao() {
		return publicacao;
	}

	public void setPublicacao(Publicacao publicacao) {
		this.publicacao = publicacao;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

}
