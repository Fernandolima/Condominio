package br.com.webhomebeta.to;

import java.util.Date;

import br.com.webhomebeta.entity.Usuario;

public class AssembleiaTO {
	private int idAssembleia;
	private String comentario;
	private Usuario usuarioAssebleia;
	private String arquivo;
	private String titulo;
	private Date dataAssembleia;
	private Date dataCriacao;
	/**
	 * @return the idAssembleia
	 */
	public int getIdAssembleia() {
		return idAssembleia;
	}
	/**
	 * @return the comentario
	 */
	public String getComentario() {
		return comentario;
	}
	/**
	 * @return the usuarioAssebleia
	 */
	public Usuario getUsuarioAssebleia() {
		return usuarioAssebleia;
	}
	/**
	 * @return the dataCriacao
	 */
	public Date getDataCriacao() {
		return dataCriacao;
	}
	/**
	 * @param idAssembleia the idAssembleia to set
	 */
	public void setIdAssembleia(int idAssembleia) {
		this.idAssembleia = idAssembleia;
	}
	/**
	 * @param comentario the comentario to set
	 */
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	/**
	 * @param usuarioAssebleia the usuarioAssebleia to set
	 */
	public void setUsuarioAssebleia(Usuario usuarioAssebleia) {
		this.usuarioAssebleia = usuarioAssebleia;
	}
	/**
	 * @param dataCriacao the dataCriacao to set
	 */
	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
}