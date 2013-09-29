package br.com.webhomebeta.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

public class Enquetes {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_ENQUETE")
	private int idEquete;

	@Column(name = "ENQUETE")
	private String enquete;

	@Column(name = "DATA_ENQUETE")
	private Date dataequete;

	@Column(name = "TITULO")
	private Date titulo;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_USER", nullable = false)
	private Usuario usuarioEnquete;

	// Um usuario pode fazer varias opcao
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "enquete")
	private Set<Opcao> opcao = new HashSet<>(0);

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
		return enquete;
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
		this.enquete = equete;
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

}
