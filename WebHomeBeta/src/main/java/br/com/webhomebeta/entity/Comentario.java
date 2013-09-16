package br.com.webhomebeta.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "[dbo].[COMENTARIO_PUBLICACAO]")
public class Comentario implements Serializable {

	
	
	public Comentario(Usuario usuarioComentario, Publicacao publicacao,
			String comentario, Date data) {
		super();
		this.usuarioComentario = usuarioComentario;
		this.publicacao = publicacao;
		this.comentario = comentario;
		this.data = data;
	}

	public Comentario() {
		
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_COMENTARIO")
	private int idComentario;

	// Mapeamento N - 1
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_USER", nullable = false)
	private Usuario usuarioComentario;

	// Mapeamento 1 - N
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_PUBLICACAO", nullable = false)
	private Publicacao publicacao;

	@Column(name = "COMENTARIO")
	private String comentario;
	
	@Column(name = "D_DATE")
	private Date data;

	@Column(name = "IMAGEM")
	private String imagem;
	
	
	
	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public Usuario getUsuarioComentario() {
		return usuarioComentario;
	}

	public void setUsuarioComentario(Usuario usuarioComentario) {
		this.usuarioComentario = usuarioComentario;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

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
