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

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "[dbo].[ASSEMBLEIA]")
public class Assembleia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_ASSEMBLEIA")
	private int idAssembleia;

	@Column(name = "COMENTARIO")
	private String comentario;

	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_USER", nullable = false)
	private Usuario usuarioAssebleia;

	@Column(name = "DATA_CRIACAO")
	private Date dataCriacao;

	/**
	 * @return the idAssembleia
	 */
	public int getIdAssembleia() {
		return idAssembleia;
	}

	/**
	 * @return the comentario
	 */
	public String getComentario() {
		return comentario;
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
	 * @param comentario the comentario to set
	 */
	public void setComentario(String comentario) {
		this.comentario = comentario;
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
