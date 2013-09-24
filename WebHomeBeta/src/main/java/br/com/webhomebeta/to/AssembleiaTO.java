package br.com.webhomebeta.to;

import java.util.Date;

import br.com.webhomebeta.entity.Usuario;

public class AssembleiaTO {
	private int idAssembleia;
	private String assembleia;
	private Usuario usuarioAssebleia;
	private String arquivo;
	private String titulo;
	private Date dataAssembleia;
	private Date dataCriacao;
	/**
	 * @return the assembleia
	 */
	public String getAssembleia() {
		return assembleia;
	}

	/**
	 * @return the arquivo
	 */
	public String getArquivo() {
		return arquivo;
	}

	/**
	 * @return the titulo
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * @return the dataAssembleia
	 */
	public Date getDataAssembleia() {
		return dataAssembleia;
	}

	/**
	 * @param assembleia the assembleia to set
	 */
	public void setAssembleia(String assembleia) {
		this.assembleia = assembleia;
	}

	/**
	 * @param arquivo the arquivo to set
	 */
	public void setArquivo(String arquivo) {
		this.arquivo = arquivo;
	}

	/**
	 * @param titulo the titulo to set
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	/**
	 * @param dataAssembleia the dataAssembleia to set
	 */
	public void setDataAssembleia(Date dataAssembleia) {
		this.dataAssembleia = dataAssembleia;
	}

	/**
	 * @return the idAssembleia
	 */
	public int getIdAssembleia() {
		return idAssembleia;
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