
package br.com.webhomebeta.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "[dbo].[DESCRICAO_CONDOMINIO]")
public class DescricaoCondominio implements Serializable {

	private static final long serialVersionUID = 499205724766612628L;

	@Column(name = "BLOCO")
	private String bloco;

	@Column(name = "QUATAPANDARES")
	private Integer quatApAndares;

	@Column(name = "NUMEROINICIAL")
	private String numeroInicial;

	@Column(name = "QUANTAP")
	private String quantAp;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_BLOCO")
	private int idbloco;

	public String getBloco() {
		return bloco;
	}

	/**
	 * @return the idbloco
	 */
	public int getIdbloco() {
		return idbloco;
	}


	/**
	 * @param bloco
	 *            the bloco to set
	 */
	public void setBloco(String bloco) {
		this.bloco = bloco;
	}

	/**
	 * @param idbloco
	 *            the idbloco to set
	 */
	public void setIdcondomnio(int idbloco) {
		this.idbloco = idbloco;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * @return the quatApAndares
	 */
	public Integer getQuatApAndares() {
		return quatApAndares;
	}

	/**
	 * @return the numeroInicia
	 */
	public String getNumeroInicia() {
		return numeroInicial;
	}

	/**
	 * @return the quantAp
	 */
	public String getQuantAp() {
		return quantAp;
	}

	/**
	 * @param quatApAndares the quatApAndares to set
	 */
	public void setQuatApAndares(Integer quatApAndares) {
		this.quatApAndares = quatApAndares;
	}

	/**
	 * @param numeroInicia the numeroInicia to set
	 */
	public void setNumeroInicia(String numeroInicia) {
		this.numeroInicial = numeroInicia;
	}

	/**
	 * @param quantAp the quantAp to set
	 */
	public void setQuantAp(String quantAp) {
		this.quantAp = quantAp;
	}

	/**
	 * @return the numeroInicial
	 */
	public String getNumeroInicial() {
		return numeroInicial;
	}

	/**
	 * @param numeroInicial the numeroInicial to set
	 */
	public void setNumeroInicial(String numeroInicial) {
		this.numeroInicial = numeroInicial;
	}

}