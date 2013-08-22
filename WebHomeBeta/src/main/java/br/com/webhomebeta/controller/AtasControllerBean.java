package br.com.webhomebeta.controller;

import br.com.webhomebeta.service.AtasService;
import br.com.webhomebeta.to.AtasTo;

public class AtasControllerBean {
	private AtasTo atasTo;
	private boolean atas;
	private String data;
	private boolean hasErrorForm = false;

	public boolean isAtas(boolean b) {
		return atas;
	}

	/**
	 * @return the data
	 */
	public String getData() {
		return data;
	}

	/**
	 * @param atas
	 *            the atas to set
	 */
	public void setAtas(boolean atas) {
		atas = atas;
	}

	/**
	 * @param data
	 *            the data to set
	 */
	public void setData(String data) {
		this.data = data;
	}

	/**
	 * @return the hasErrorForm
	 */
	public boolean isHasErrorForm() {
		return hasErrorForm;
	}

	/**
	 * @param hasErrorForm
	 *            the hasErrorForm to set
	 */

	/**
	 * @return the atasTo
	 */
	public AtasTo getAtasTo() {
		return atasTo;
	}

	/**
	 * @param atasTo
	 *            the atasTo to set
	 */
	public void setAtasTo(AtasTo atasTo) {
		this.atasTo = atasTo;
	}

	public void setHasErrorForm(boolean hasErrorForm) {
		this.hasErrorForm = hasErrorForm;
	}

	public boolean hasErrors() {
		if (atas == false) {
			hasErrorForm = true;
			return false;
		}
		hasErrorForm = false;
		return true;
	}

}
