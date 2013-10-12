package br.com.webhomebeta.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name = "[dbo].[ATAS]")
public class AtasEntity  {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_ATAS")
	private int idAtas;

	@Column(name = "TITULO")
	private String titulo;
	
	
	@Column(name = "DATA_FORMAT")
	private String dataFormat;


	@Column(name = "ARQUIVO")
	private String arquivo;

	@Column(name = "NOME")
	private String nome;
	
	@Column(name = "ATAS_ATIVA")
	private boolean atasAtivas;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_USER", nullable = false)
	private Usuario usuarioAtas;
	
	
	@Column(name = "DATA_CRIACAO")
	private Date dataCriacao;

	@Column(name = "ATAS")
	private String atas;

	
	public boolean isAtasAtivas() {
		return atasAtivas;
	}

	public void setAtasAtivas(boolean atasAtivas) {
		this.atasAtivas = atasAtivas;
	}

	public String getDataFormat() {
		return dataFormat;
	}

	public void setDataFormat(String dataFormat) {
		this.dataFormat = dataFormat;
	}

	/**
	 * @return the idAtas
	 */
	public int getIdAtas() {
		return idAtas;
	}
	


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the arquivo
	 */
	public String getArquivo() {
		return arquivo;
	}

	/**
	 * @return the usuarioAtas
	 */
	public Usuario getUsuarioAtas() {
		return usuarioAtas;
	}

	/**
	 * @return the dataCriacao
	 */
	public Date getDataCriacao() {
		return dataCriacao;
	}

	/**
	 * @param serialVersionUID
	 *            the serialVersionUID to set
	 */
	
	/**
	 * @param idAtas
	 *            the idAtas to set
	 */
	public void setIdAtas(int idAtas) {
		this.idAtas = idAtas;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	/**
	 * @return the titulo
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * @param arquivo
	 *            the arquivo to set
	 */
	public void setArquivo(String arquivo) {
		this.arquivo = arquivo;
	}

	/**
	 * @param usuarioAtas
	 *            the usuarioAtas to set
	 */
	public void setUsuarioAtas(Usuario usuarioAtas) {
		this.usuarioAtas = usuarioAtas;
	}

	/**
	 * @param dataCriacao
	 *            the dataCriacao to set
	 */
	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	/**
	 * @param atasEntity 
	 * @return the atas
	 */
	public String getAtas() {
		return atas;
	}

	/**
	 * @param atas
	 *            the atas to set
	 */
	public void setAtas(String atas) {
		this.atas = atas;
	}

}
