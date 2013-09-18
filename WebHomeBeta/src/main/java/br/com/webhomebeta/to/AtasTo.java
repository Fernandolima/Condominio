package br.com.webhomebeta.to;

import java.util.Date;

public class AtasTo {

	private int idAtas;
	private String comentario;
	private Date dataCriacao;
	private String atas;
	private String arquivo;
	private Date dataAtas;

	/**
	 * @return the atas
	 */
	public String getAtas() {
		return atas;
	}

	/**
	 * @return the idAtas
	 */
	public int getIdAtas() {
		return idAtas;
	}

	/**
	 * @return the comentario
	 */
	public String getComentario() {
		return comentario;
	}

	/**
	 * @return the dataCriacao
	 */
	public Date getDataCriacao() {
		return dataCriacao;
	}

	/**
	 * @return the arquivo
	 */
	public String getArquivo() {
		return arquivo;
	}

	/**
	 * @param idAtas
	 *            the idAtas to set
	 */
	public void setIdAtas(int idAtas) {
		this.idAtas = idAtas;
	}

	/**
	 * @param comentario
	 *            the comentario to set
	 */
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	/**
	 * @param dataCriacao
	 *            the dataCriacao to set
	 */
	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	/**
	 * @param arquivo
	 *            the arquivo to set
	 */
	public void setArquivo(String arquivo) {
		this.arquivo = arquivo;
	}

	/**
	 * @param atas
	 *            the atas to set
	 */
	public void setAtas(String atas) {
		this.atas = atas;
	}

	/**
	 * @param dataAtas
	 *            the dataAtas to set
	 */
	public void setDataAtas(Date dataAtas) {
		this.dataAtas = dataAtas;
	}

}
