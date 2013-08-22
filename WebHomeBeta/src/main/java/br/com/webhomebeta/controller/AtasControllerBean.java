package br.com.webhomebeta.controller;

import br.com.webhomebeta.service.AtasService;

public class AtasControllerBean {
	private AtasService atasService;
	private boolean Atas;
	private String data;
	private boolean hasErrorForm = false;

	/**
	 * @return the atasService
	 */
	public AtasService getAtasService() {
		return atasService;
	}

	/**
	 * @return the atas
	 */
	public boolean isAtas() {
		return Atas;
	}

	/**
	 * @return the data
	 */
	public String getData() {
		return data;
	}

	/**
	 * @param atasService
	 *            the atasService to set
	 */
	public void setAtasService(AtasService atasService) {
		this.atasService = atasService;
	}

	/**
	 * @param atas
	 *            the atas to set
	 */
	public void setAtas(boolean atas) {
		Atas = atas;
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
	public void setHasErrorForm(boolean hasErrorForm) {
		this.hasErrorForm = hasErrorForm;
	}

	public boolean hasErrors() {
		if (Atas == false) {
			hasErrorForm = true;
			return false;
		}
		hasErrorForm = false;
		return true;
	}
}
