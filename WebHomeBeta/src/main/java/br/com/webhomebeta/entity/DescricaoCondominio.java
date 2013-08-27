
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
	private int QuatApAndares;

	@Column(name = "NUMEROINICIAL")
	private String NumeroInicia;

	@Column(name = "QUANTAP")
	private String QuantAp;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_CONDOMINIO")
	private int idcondomnio;

	public String getBloco() {
		return bloco;
	}

	/**
	 * @return the idcondomnio
	 */
	public int getIdcondomnio() {
		return idcondomnio;
	}


	/**
	 * @param bloco
	 *            the bloco to set
	 */
	public void setBloco(String bloco) {
		this.bloco = bloco;
	}

	/**
	 * @param idcondomnio
	 *            the idcondomnio to set
	 */
	public void setIdcondomnio(int idcondomnio) {
		this.idcondomnio = idcondomnio;
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
	public int getQuatApAndares() {
		return QuatApAndares;
	}

	/**
	 * @return the numeroInicia
	 */
	public String getNumeroInicia() {
		return NumeroInicia;
	}

	/**
	 * @return the quantAp
	 */
	public String getQuantAp() {
		return QuantAp;
	}

	/**
	 * @param quatApAndares the quatApAndares to set
	 */
	public void setQuatApAndares(int quatApAndares) {
		QuatApAndares = quatApAndares;
	}

	/**
	 * @param numeroInicia the numeroInicia to set
	 */
	public void setNumeroInicia(String numeroInicia) {
		NumeroInicia = numeroInicia;
	}

	/**
	 * @param quantAp the quantAp to set
	 */
	public void setQuantAp(String quantAp) {
		QuantAp = quantAp;
	}

}