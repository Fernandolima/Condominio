package br.com.webhomebeta.to;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import br.com.webhomebeta.entity.Comentario;
import br.com.webhomebeta.entity.Usuario;

public class PublicacaoTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4876328284589933191L;



	public PublicacaoTO() {
		
	}

	public PublicacaoTO(Usuario usuarioPublicacao) {

		this.usuarioPublicacao = usuarioPublicacao;
	}
	

	private Date data;
	
	private String publicacao;

	private int idPublicacao;

	private Usuario usuarioPublicacao;

	private String imagem;
	
	private Set<Comentario> comentarios = new HashSet<>(0);

	
	
	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public Usuario getUsuarioPublicacao() {
		return usuarioPublicacao;
	}

	public void setUsuarioPublicacao(Usuario usuarioPublicacao) {
		this.usuarioPublicacao = usuarioPublicacao;
	}

	public Integer getIdPublicacao() {
		return idPublicacao;
	}

	public void setIdPublicacao(Integer idPublicacao) {
		this.idPublicacao = idPublicacao;
	}

	public Set<Comentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios(Set<Comentario> comentarios) {
		this.comentarios = comentarios;
	}

	public String getPublicacao() {
		return publicacao;
	}

	public Integer getId_PUBLICACAO() {
		return idPublicacao;
	}

	public void setPublicacao(String publicacao) {
		this.publicacao = publicacao;
	}

	void setId_PUBLICACAO(Integer idPublicacao) {
		this.idPublicacao = idPublicacao;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
	
}
