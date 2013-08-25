package br.com.webhomebeta.entity;

import java.io.Serializable;
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
@Table(name = "[dbo.].[ATAS]")
public class AtasEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8688347079158220711L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_ATAS")
	private int idAtas;

	@Column(name = "COMENTARIO")
	private String comentario;

	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_USER", nullable = false)
	private Usuario usuarioAtas;

	@Column(name = "DATA_CRIACAO")
	private Date dataCriacao;

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
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
	 * @param idAtas the idAtas to set
	 */
	public void setIdAtas(int idAtas) {
		this.idAtas = idAtas;
	}

	/**
	 * @param comentario the comentario to set
	 */
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	/**
	 * @param usuarioAtas the usuarioAtas to set
	 */
	public void setUsuarioAtas(Usuario usuarioAtas) {
		this.usuarioAtas = usuarioAtas;
	}

	/**
	 * @param dataCriacao the dataCriacao to set
	 */
	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}




}
