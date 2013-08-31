package br.com.webhomebeta.json;

import java.util.Date;
import java.util.List;

public class JsonPublicacao {

	private String publicacao;
	private int idPublicacao;
	private Date dataPublicacao;
	private String imagemPublicacao;
	private UsuarioPublicacaoJSON usuarioPublicacao;
	private List<ComentarioJSON> comentarios;
	private boolean isProprietario;

	
	public JsonPublicacao(String publicacao, int idPublicacao,
			Date dataPublicacao, String imagemPublicacao,
			UsuarioPublicacaoJSON usuarioPublicacao) {
		super();
		this.publicacao = publicacao;
		this.idPublicacao = idPublicacao;
		this.dataPublicacao = dataPublicacao;
		this.imagemPublicacao = imagemPublicacao;
		this.usuarioPublicacao = usuarioPublicacao;
		
	}

	public boolean isProprietario() {
		return isProprietario;
	}

	public void setProprietario(boolean isProprietario) {
		this.isProprietario = isProprietario;
	}

	public UsuarioPublicacaoJSON getUsuarioPublicacao() {
		return usuarioPublicacao;
	}

	public void setUsuarioPublicacao(UsuarioPublicacaoJSON usuarioPublicacao) {
		this.usuarioPublicacao = usuarioPublicacao;
	}

	public List<ComentarioJSON> getComentarios() {
		return comentarios;
	}

	public void setComentarios(List<ComentarioJSON> comentarios) {
		this.comentarios = comentarios;
	}

	public String getPublicacao() {
		return publicacao;
	}

	public void setPublicacao(String publicacao) {
		this.publicacao = publicacao;
	}

	public int getIdPublicacao() {
		return idPublicacao;
	}

	public void setIdPublicacao(int idPublicacao) {
		this.idPublicacao = idPublicacao;
	}

	public Date getDataPublicacao() {
		return dataPublicacao;
	}

	public void setDataPublicacao(Date dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}

	public String getImagemPublicacao() {
		return imagemPublicacao;
	}

	public void setImagemPublicacao(String imagemPublicacao) {
		this.imagemPublicacao = imagemPublicacao;
	}
	
}
