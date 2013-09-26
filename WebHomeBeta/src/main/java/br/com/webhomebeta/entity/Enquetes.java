package br.com.webhomebeta.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class Enquetes {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_ENQUETE")
	private int idEquete;

	@Column(name = "ENQUETE")
	private String equete;

	@Column(name = "DATA_ENQUETE")
	private Date dataequete;

	@Column(name = "TITULO")
	private Date titulo;
	
	@Column(name = "APROVACOES")
	private String aprovacao;

	@Column(name = "REPROVACOES")
	private String reprovacao;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_USER", nullable = false)
	private Usuario usuarioEnquete;

	/**
	 * @return the titulo
	 */
	public Date getTitulo() {
		return titulo;
	}

	/**
	 * @param titulo
	 *            the titulo to set
	 */
	public void setTitulo(Date titulo) {
		this.titulo = titulo;
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
	 * @param idEquete
	 *            the idEquete to set
	 */
	public void setIdEquete(int idEquete) {
		this.idEquete = idEquete;
	}

	/**
	 * @param equete
	 *            the equete to set
	 */
	public void setEquete(String equete) {
		this.equete = equete;
	}

	/**
	 * @param dataequete
	 *            the dataequete to set
	 */
	public void setDataequete(Date dataequete) {
		this.dataequete = dataequete;
	}

	/**
	 * @return the usuarioEnquete
	 */
	public Usuario getUsuarioEnquete() {
		return usuarioEnquete;
	}

	/**
	 * @param usuarioEnquete
	 *            the usuarioEnquete to set
	 */
	public void setUsuarioEnquete(Usuario usuarioEnquete) {
		this.usuarioEnquete = usuarioEnquete;
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


}
