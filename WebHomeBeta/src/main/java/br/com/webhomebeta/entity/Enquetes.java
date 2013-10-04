package br.com.webhomebeta.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
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

import org.hibernate.annotations.Cascade;

@Entity
@Table(name="[dbo].[ENQUETES]")
public class Enquetes implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7501462270022936425L;

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
	
	@Column(name = "ATIVA", columnDefinition = "BOOLEAN")
	private boolean isAtiva;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_USER", nullable = false)
	private Usuario usuarioEnquete;

	// Um usuario pode criar varias opcoes
	@Cascade(org.hibernate.annotations.CascadeType.ALL)
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "enquetes", orphanRemoval = true)
	private List<Opcao> opcao;

	
	
	
	public boolean isAtiva() {
		return isAtiva;
	}

	public void setAtiva(boolean isAtiva) {
		this.isAtiva = isAtiva;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getEnquete() {
		return enquete;
	}

	public void setEnquete(String enquete) {
		this.enquete = enquete;
	}

	
	public List<Opcao> getOpcao() {
		return opcao;
	}

	public void setOpcao(List<Opcao> opcao) {
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
