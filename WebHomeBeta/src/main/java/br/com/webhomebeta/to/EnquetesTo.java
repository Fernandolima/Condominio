package br.com.webhomebeta.to;

import java.util.Date;

import br.com.webhomebeta.entity.Usuario;

public class EnquetesTo {

	private int idEquete;
	private String equete;
	private Date dataequete;
	private Usuario usuarioEnquete;
	private Date titulo;
	private String aprovacao;
	private String reprovacao;
	/**
	 * @return the aprovacao

	/**
	 * @return the titulo
	 */
	public Date getTitulo() {
		return titulo;
	}
	/**
	 * @param titulo the titulo to set
	 */
	public void setTitulo(Date titulo) {
		this.titulo = titulo;
	}
	/**
	 * @return the aprovacao
	 */
	public String getAprovacao() {
		return aprovacao;
	}
	/**
	 * @return the reprovacao
	 */
	public String getReprovacao() {
		return reprovacao;
	}
	/**
	 * @param aprovacao the aprovacao to set
	 */
	public void setAprovacao(String aprovacao) {
		this.aprovacao = aprovacao;
	}
	/**
	 * @param reprovacao the reprovacao to set
	 */
	public void setReprovacao(String reprovacao) {
		this.reprovacao = reprovacao;
	}
	/**
	 * @return the idEquete
	 */
	public int getIdEquete() {
		return idEquete;
	}
	/**
	 * @return the equete
	 */
	public String getEquete() {
		return equete;
	}
	/**
	 * @return the dataequete
	 */
	public Date getDataequete() {
		return dataequete;
	}
	/**
	 * @return the usuarioEnquete
	 */
	public Usuario getUsuarioEnquete() {
		return usuarioEnquete;
	}
	/**
	 * @param idEquete the idEquete to set
	 */
	public void setIdEquete(int idEquete) {
		this.idEquete = idEquete;
	}
	/**
	 * @param equete the equete to set
	 */
	public void setEquete(String equete) {
		this.equete = equete;
	}
	/**
	 * @param dataequete the dataequete to set
	 */
	public void setDataequete(Date dataequete) {
		this.dataequete = dataequete;
	}
	/**
	 * @param usuarioEnquete the usuarioEnquete to set
	 */
	public void setUsuarioEnquete(Usuario usuarioEnquete) {
		this.usuarioEnquete = usuarioEnquete;
	}
	
}
