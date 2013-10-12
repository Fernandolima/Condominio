package br.com.webhomebeta.to;

import java.util.Date;

import br.com.webhomebeta.entity.Usuario;

public class AtasTo {
	private String nome;
	private int idAtas;
	private String titulo;
	private Date dataCriacao;
	private String atas;
	private String arquivo;
	private String dataFormat;
	private Usuario usuarioAtas;
	private boolean atasAtivas;
	
	

	public boolean isAtasAtivas() {
		return atasAtivas;
	}

	public void setAtasAtivas(boolean atasAtivas) {
		this.atasAtivas = atasAtivas;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the idAtas
	 */
	public int getIdAtas() {
		return idAtas;
	}

	/**
	 * @return the titulo
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * @return the dataCriacao
	 */
	public Date getDataCriacao() {
		return dataCriacao;
	}

	/**
	 * @return the atas
	 */
	public String getAtas() {
		return atas;
	}

	/**
	 * @return the arquivo
	 */
	public String getArquivo() {
		return arquivo;
	}

	/**
	 * @return the dataFormat
	 */
	public String getDataFormat() {
		return dataFormat;
	}

	/**
	 * @return the usuarioAtas
	 */
	public Usuario getUsuarioAtas() {
		return usuarioAtas;
	}

	/**
	 * @param idAtas
	 *            the idAtas to set
	 */
	public void setIdAtas(int idAtas) {
		this.idAtas = idAtas;
	}

	/**
	 * @param titulo
	 *            the titulo to set
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	/**
	 * @param dataCriacao
	 *            the dataCriacao to set
	 */
	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	/**
	 * @param atas
	 *            the atas to set
	 */
	public void setAtas(String atas) {
		this.atas = atas;
	}

	/**
	 * @param arquivo
	 *            the arquivo to set
	 */
	public void setArquivo(String arquivo) {
		this.arquivo = arquivo;
	}

	/**
	 * @param dataFormat
	 *            the dataFormat to set
	 */
	public void setDataFormat(String dataFormat) {
		this.dataFormat = dataFormat;
	}

	/**
	 * @param usuarioAtas
	 *            the usuarioAtas to set
	 */
	public void setUsuarioAtas(Usuario usuarioAtas) {
		this.usuarioAtas = usuarioAtas;
	}

}