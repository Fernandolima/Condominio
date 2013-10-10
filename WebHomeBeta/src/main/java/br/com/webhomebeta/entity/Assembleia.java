package br.com.webhomebeta.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "[dbo].[ASSEMBLEIA]")
public class Assembleia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_ASSEMBLEIA")
	private int idAssembleia;

	@Column(name = "ASSEMBLEIA")
	private String assembleia;

	@Column(name = "TITULO")
	private String titulo;

	@Column(name = "DATA_ASSEMBLEIA")
	private Date dataAssembleia;
	
	@Column(name = "ASSEMBLEIA_ATIVA")
	private boolean assembleiaAtiva;

	

	public boolean isAssembleiaAtiva() {
		return assembleiaAtiva;
	}

	public void setAssembleiaAtiva(boolean assembleiaAtiva) {
		this.assembleiaAtiva = assembleiaAtiva;
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
	 * @param titulo
	 *            the titulo to set
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	/**
	 * @param dataAssembleia
	 *            the dataAssembleia to set
	 */
	public void setDataAssembleia(Date dataAssembleia) {
		this.dataAssembleia = dataAssembleia;
	}

	/**
	 * @return the arquivo
	 */
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_USER", nullable = false)
	private Usuario usuarioAssebleia;

	@Column(name = "DATA_CRIACAO")
	private Date dataCriacao;

	/**
	 * @return the assembleia
	 */
	public String getAssembleia() {
		return assembleia;
	}

	/**
	 * @param assembleia
	 *            the assembleia to set
	 */
	public void setAssembleia(String assembleia) {
		this.assembleia = assembleia;
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
	 * @param idAssembleia
	 *            the idAssembleia to set
	 */
	public void setIdAssembleia(int idAssembleia) {
		this.idAssembleia = idAssembleia;
	}

	/**
	 * @param usuarioAssebleia
	 *            the usuarioAssebleia to set
	 */
	public void setUsuarioAssebleia(Usuario usuarioAssebleia) {
		this.usuarioAssebleia = usuarioAssebleia;
	}

	/**
	 * @param dataCriacao
	 *            the dataCriacao to set
	 */
	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

}
