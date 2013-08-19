package br.com.webhomebeta.controller;

import br.com.webhomebeta.to.DescricaoCondominioTO;

public class CadastroCondominioControllerBean {

	private DescricaoCondominioTO descricaoCondominioTO;
	private boolean bloco = true;
	private boolean idcondomnio = true;
	private boolean nome_condiminio = true;
	private boolean ap = true;
	private boolean QuatApAndares = true;
	private boolean NumeroInicia = true;
	private boolean QuantAp = true;
	private boolean hasErrorCond = false;

	/**
	 * @return the descricaoCondominioTO
	 */
	public DescricaoCondominioTO getDescricaoCondominioTO() {
		return descricaoCondominioTO;
	}

	/**
	 * @return the bloco
	 */
	public boolean isBloco(boolean ValidBloco) {
		return bloco;
	}

	/**
	 * @return the idcondomnio
	 */
	public boolean isIdcondomnio() {
		return idcondomnio;
	}

	/**
	 * @return the ap
	 */
	public boolean isAp(boolean validAp) {
		return ap;
	}

	/**
	 * @return the nome_condiminio
	 */
	public boolean isNome_condiminio(boolean validNomeCondominio) {
		return nome_condiminio;
	}

	/**
	 * @return the hasErrorCond
	 */
	public boolean isHasErrorCond() {
		return hasErrorCond;
	}

	/**
	 * @param descricaoCondominioTO
	 *            the descricaoCondominioTO to set
	 */
	public void setDescricaoCondominioTO(
			DescricaoCondominioTO descricaoCondominioTO) {
		this.descricaoCondominioTO = descricaoCondominioTO;
	}

	/**
	 * @param bloco
	 *            the bloco to set
	 */
	public void setBloco(boolean bloco) {
		this.bloco = bloco;
	}

	/**
	 * @param idcondomnio
	 *            the idcondomnio to set
	 */
	public void setIdcondomnio(boolean idcondomnio) {
		this.idcondomnio = idcondomnio;
	}

	/**
	 * @param ap
	 *            the ap to set
	 */
	public void setAp(boolean ap) {
		this.ap = ap;
	}

	/**
	 * @param nome_condiminio
	 *            the nome_condiminio to set
	 */
	public void setNome_condiminio(boolean nome_condiminio) {
		this.nome_condiminio = nome_condiminio;
	}

	/**
	 * @param hasErrorCond
	 *            the hasErrorCond to set
	 */
	public void setHasErrorCond(boolean hasErrorCond) {
		this.hasErrorCond = hasErrorCond;
	}

	
	/**
	 * @return the bloco
	 */
	public boolean isBloco() {
		return bloco;
	}

	/**
	 * @return the nome_condiminio
	 */
	public boolean isNome_condiminio() {
		return nome_condiminio;
	}

	/**
	 * @return the quatApAndares
	 */
	public boolean isQuatApAndares() {
		return QuatApAndares;
	}

	/**
	 * @return the numeroInicia
	 */
	public boolean isNumeroInicia() {
		return NumeroInicia;
	}

	/**
	 * @return the quantAp
	 */
	public boolean isQuantAp() {
		return QuantAp;
	}

	/**
	 * @param quatApAndares the quatApAndares to set
	 */
	public void setQuatApAndares(boolean quatApAndares) {
		QuatApAndares = quatApAndares;
	}

	/**
	 * @param numeroInicia the numeroInicia to set
	 */
	public void setNumeroInicia(boolean numeroInicia) {
		NumeroInicia = numeroInicia;
	}

	/**
	 * @param quantAp the quantAp to set
	 */
	public void setQuantAp(boolean quantAp) {
		QuantAp = quantAp;
	}
	public boolean hasErrors() {
		if (bloco == false || idcondomnio == false || ap == false
				|| nome_condiminio == false || QuatApAndares == false
				|| NumeroInicia == false || QuantAp == false) {
			hasErrorCond = true;
			return false;
		}
		hasErrorCond = false;
		return true;
	}



}
