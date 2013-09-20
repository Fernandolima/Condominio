package br.com.webhomebeta.json;

import java.util.Date;
import java.util.List;

public class JsonPublicacao {

	private String publicacao;
	private int idPublicacao;
	private String dataPublicacao;
	private String imagemPublicacao;
	private UsuarioPublicacaoJSON usuarioPublicacao;
	private List<ComentarioJSON> comentarios;
	private int quantidadeComentarios;
	private boolean isProprietario;

	
	
	
	public JsonPublicacao(String publicacao, int idPublicacao,
			String dataPublicacao, String imagemPublicacao,
			UsuarioPublicacaoJSON usuarioPublicacao) {
		this.publicacao = publicacao;
		this.idPublicacao = idPublicacao;
		this.dataPublicacao = dataPublicacao;
		this.imagemPublicacao = imagemPublicacao;
		this.usuarioPublicacao = usuarioPublicacao;
	}

	
	
	
	public String getDataPublicacao() {
		return dataPublicacao;
	}

	public int getQuantidadeComentarios() {
		return quantidadeComentarios;
	}




	public void setQuantidadeComentarios(int quantidadeComentarios) {
		this.quantidadeComentarios = quantidadeComentarios;
	}




	public void setDataPublicacao(String dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
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

	public String getImagemPublicacao() {
		return imagemPublicacao;
	}

	public void setImagemPublicacao(String imagemPublicacao) {
		this.imagemPublicacao = imagemPublicacao;
	}
	
}
