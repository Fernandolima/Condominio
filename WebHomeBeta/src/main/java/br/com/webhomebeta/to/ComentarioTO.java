package br.com.webhomebeta.to;

import br.com.webhomebeta.entity.Publicacao;
import br.com.webhomebeta.entity.Usuario;

public class ComentarioTO {
	
	private int idComentario;

	private Usuario usuarioComentario;

	private Publicacao publicacao;

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

}
