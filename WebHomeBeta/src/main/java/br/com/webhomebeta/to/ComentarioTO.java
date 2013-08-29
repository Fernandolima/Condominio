package br.com.webhomebeta.to;

import java.util.Date;

import br.com.webhomebeta.entity.Publicacao;
import br.com.webhomebeta.entity.Usuario;

public class ComentarioTO {

	private int idComentario;

	private Usuario usuarioComentario;

	private Publicacao publicacao;

	private String comentario;

	private Date data;

	public ComentarioTO() {
		// TODO Auto-generated constructor stub
	}

	public ComentarioTO(Usuario usuarioComentario, Publicacao publicacao,
			String comentario, Date data) {
		super();
		this.usuarioComentario = usuarioComentario;
		this.publicacao = publicacao;
		this.comentario = comentario;
		this.data = data;
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

}
