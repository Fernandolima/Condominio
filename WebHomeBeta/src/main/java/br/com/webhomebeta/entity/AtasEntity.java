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

	@Column(name = "ATAS")
	private String atas;

	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_USER", nullable = false)
	private Usuario usuarioAtas;

	@Column(name = "DATA_ATAS")
	private Date dataAtas;

	/**
	 * @return the idAtas
	 */
	public int getIdAtas() {
		return idAtas;
	}

	/**
	 * @return the atas
	 */
	public String getAtas() {
		return atas;
	}


	/**
	 * @return the dataAtas
	 */
	public Date getDataAtas() {
		return dataAtas;
	}

	/**
	 * @param idAtas
	 *            the idAtas to set
	 */
	public void setIdAtas(int idAtas) {
		this.idAtas = idAtas;
	}

	/**
	 * @param atas
	 *            the atas to set
	 */
	public void setAtas(String atas) {
		this.atas = atas;
	}


	/**
	 * @param dataAtas
	 *            the dataAtas to set
	 */
	public void setDataAtas(Date dataAtas) {
		this.dataAtas = dataAtas;
	}

}
