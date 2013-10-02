package br.com.webhomebeta.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="[dbo].[ENQUETES]")
public class Enquetes implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_ENQUETE")
	private int idEquete;

	@Column(name = "ENQUETE")
	private String enquete;

	@Column(name = "DATA_ENQUETE")
	private Date dataequete;

	@Column(name = "TITULO")
	private String titulo;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_USER", nullable = false)
	private Usuario usuarioEnquete;

	// Um usuario pode fazer varias opcao
	@OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER, mappedBy = "enquete")
	private Set<Opcao> opcao = new HashSet<>(0);

	
	
	public String getEnquete() {
		return enquete;
	}

	public void setEnquete(String enquete) {
		this.enquete = enquete;
	}

	public Set<Opcao> getOpcao() {
		return opcao;
	}

	public void setOpcao(Set<Opcao> opcao) {
		this.opcao = opcao;
	}

	/**
	 * @return the titulo
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * @param titulo
	 *            the titulo to set
	 */
	public void setTitulo(String titulo) {
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
