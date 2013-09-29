package br.com.webhomebeta.entity;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class Opcao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_OPCAO")
	private int idOpcao;

	@Column(name = "OPCAO")
	private String opcao;

	@Column(name = "ID_ENQUETE")
	private int idEnquete;

	@Column(name = "QUAT_VOTOS")
	private int quatVots;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_ENQUETE", nullable = false)
	private Enquetes enquete;

	/**
	 * @return the idOpcao
	 */
	public int getIdOpcao() {
		return idOpcao;
	}

	/**
	 * @return the opcao
	 */
	public String getOpcao() {
		return opcao;
	}

	/**
	 * @return the idEnquete
	 */
	public int getIdEnquete() {
		return idEnquete;
	}

	/**
	 * @return the quatVots
	 */
	public int getQuatVots() {
		return quatVots;
	}

	/**
	 * @param idOpcao the idOpcao to set
	 */
	public void setIdOpcao(int idOpcao) {
		this.idOpcao = idOpcao;
	}

	/**
	 * @param opcao the opcao to set
	 */
	public void setOpcao(String opcao) {
		this.opcao = opcao;
	}

	/**
	 * @param idEnquete the idEnquete to set
	 */
	public void setIdEnquete(int idEnquete) {
		this.idEnquete = idEnquete;
	}

	/**
	 * @param quatVots the quatVots to set
	 */
	public void setQuatVots(int quatVots) {
		this.quatVots = quatVots;
	}
}
