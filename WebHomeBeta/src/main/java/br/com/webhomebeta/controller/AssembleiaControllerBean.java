package br.com.webhomebeta.controller;

import br.com.webhomebeta.to.AssembleiaTO;
import br.com.webhomebeta.to.AtasTo;

public class AssembleiaControllerBean {
	private AssembleiaTO assembleiaTO;
	private boolean assembleia;
	private String data;
	private boolean hasErrorForm = false;

	/**
	 * @return the assembleiaTO
	 */
	public AssembleiaTO getAssembleiaTO() {
		return assembleiaTO;
	}

	/**
	 * @param resultado 
	 * @return the assembleia
	 */
	public boolean isAssembleia(boolean resultado) {
		return assembleia;
	}

	/**
	 * @return the data
	 */
	public String getData() {
		return data;
	}

	/**
	 * @return the hasErrorForm
	 */
	public boolean isHasErrorForm() {
		return hasErrorForm;
	}

	/**
	 * @param assembleiaTO
	 *            the assembleiaTO to set
	 */
	public void setAssembleiaTO(AssembleiaTO assembleiaTO) {
		this.assembleiaTO = assembleiaTO;
	}

	/**
	 * @param assembleia
	 *            the assembleia to set
	 */
	public void setAssembleia(boolean assembleia) {
		this.assembleia = assembleia;
	}

	/**
	 * @param data
	 *            the data to set
	 */
	public void setData(String data) {
		this.data = data;
	}
	
	

	/**
	 * @param hasErrorForm
	 *            the hasErrorForm to set
	 */
	public void setHasErrorForm(boolean hasErrorForm) {
		this.hasErrorForm = hasErrorForm;
	}

	public boolean hasErrors() {
		if (assembleia == false) {
			hasErrorForm = true;
			return false;
		}
		hasErrorForm = false;
		return true;
	}

}
