package br.com.webhomebeta.json;

import java.util.Date;

public class ComentarioJSON {
	
	int idUsuarioComentario;
	String nome;
	String imagemUsuario;
	int idComentario;
	Date dataComentario;
	String comentario;
	
	public ComentarioJSON(int idUsuarioComentario, String nome,
			String imagemUsuario, int idComentario, Date dataComentario,
			String comentario) {
		super();
		this.idUsuarioComentario = idUsuarioComentario;
		this.nome = nome;
		this.imagemUsuario = imagemUsuario;
		this.idComentario = idComentario;
		this.dataComentario = dataComentario;
		this.comentario = comentario;
	}
	public int getIdUsuarioComentario() {
		return idUsuarioComentario;
	}
	public void setIdUsuarioComentario(int idUsuarioComentario) {
		this.idUsuarioComentario = idUsuarioComentario;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getImagemUsuario() {
		return imagemUsuario;
	}
	public void setImagemUsuario(String imagemUsuario) {
		this.imagemUsuario = imagemUsuario;
	}
	public int getIdComentario() {
		return idComentario;
	}
	public void setIdComentario(int idComentario) {
		this.idComentario = idComentario;
	}
	public Date getDataComentario() {
		return dataComentario;
	}
	public void setDataComentario(Date dataComentario) {
		this.dataComentario = dataComentario;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	
	
}
