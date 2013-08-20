package br.com.webhomebeta.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "")
public class Comentario implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idComentario;
	
	//Mapeamento N - 1
	@ManyToOne(fetch = FetchType.LAZY) 
	@JoinColumn(name = "ID_USER", nullable = false)
	private Usuario usuarioComentario;
	
	//Mapeamento 1 - N
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_PUBLICACAO", nullable = false)
	private Publicacao publicacao;
	
	@Column(name = "COMENTARIO")
	private String comentario;

	
	
	public Publicacao getPublicacao() {
		return publicacao;
	}

	public void setPublicacao(Publicacao publicacao) {
		this.publicacao = publicacao;
	}

	public int getIdComentario() {
		return idComentario;
	}

	public void setIdComentario(int idComentario) {
		this.idComentario = idComentario;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
