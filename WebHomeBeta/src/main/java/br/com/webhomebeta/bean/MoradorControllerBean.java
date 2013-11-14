package br.com.webhomebeta.bean;

import java.io.Serializable;

import br.com.webhomebeta.entity.Usuario;
import br.com.webhomebeta.to.ComentarioTO;
import br.com.webhomebeta.to.PublicacaoTO;

public class MoradorControllerBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PublicacaoTO publicacaoTO;
	private ComentarioTO comentarioTO;
	private Usuario usuario;
	private int idComentario;
	private int idPublicacao;
	private int colunaInicial;
	
	

	public int getColunaInicial() {
		return colunaInicial;
	}

	public void setColunaInicial(int colunaInicial) {
		this.colunaInicial = colunaInicial;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getIdComentario() {
		return idComentario;
	}

	public void setIdComentario(int idComentario) {
		this.idComentario = idComentario;
	}

	public int getIdPublicacao() {
		return idPublicacao;
	}

	public void setIdPublicacao(int idPublicacao) {
		this.idPublicacao = idPublicacao;
	}

	public PublicacaoTO getPublicacaoTO() {
		return publicacaoTO;
	}

	public void setPublicacaoTO(PublicacaoTO publicacaoTO) {
		this.publicacaoTO = publicacaoTO;
	}

	public ComentarioTO getComentarioTO() {
		return comentarioTO;
	}

	public void setComentarioTO(ComentarioTO comentarioTO) {
		this.comentarioTO = comentarioTO;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
