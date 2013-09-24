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

@Entity
@Table(name = "[dbo].[ATAS]")
public class AtasEntity implements Serializable {

	/**
	 * 
	 */
	private static long serialVersionUID = 8688347079158220711L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_ATAS")
	private int idAtas;

	@Column(name = "TITULO")
	private String titulo;
	
	@Column(name = "DATA_CRIACAO")
	private Date dataATA;
	
	@Column(name = "ARQUIVO")
	private String arquivo;

	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_USER", nullable = false)
	private Usuario usuarioAtas;

	@Column(name = "DATA_ATA")
	private Date dataCriacao;
	
	@Column(name = "ATAS")
	private String atas;

	
	/**
	 * @return the serialVersionUID
	 */
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	/**
	 * @return the idAtas
	 */
	public int getIdAtas() {
		return idAtas;
	}

	
	/**
	 * @return the dataATA
	 */
	public Date getDataATA() {
		return dataATA;
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
	 * @param serialVersionUID the serialVersionUID to set
	 */
	public static void setSerialVersionUID(long serialVersionUID) {
		AtasEntity.serialVersionUID = serialVersionUID;
	}

	/**
	 * @param idAtas the idAtas to set
	 */
	public void setIdAtas(int idAtas) {
		this.idAtas = idAtas;
	}

	/**
	 * @return the titulo
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * @param titulo the titulo to set
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	/**
	 * @param date the dataATA to set
	 */
	public void setDataATA(Date date) {
		this.dataATA = date;
	}

	/**
	 * @param arquivo the arquivo to set
	 */
	public void setArquivo(String arquivo) {
		this.arquivo = arquivo;
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

	/**
	 * @return the atas
	 */
	public String getAtas() {
		return atas;
	}

	/**
	 * @param atas the atas to set
	 */
	public void setAtas(String atas) {
		this.atas = atas;
	}
	
	
}
