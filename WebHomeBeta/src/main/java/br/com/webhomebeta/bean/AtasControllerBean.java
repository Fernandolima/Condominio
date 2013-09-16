package br.com.webhomebeta.bean;

import br.com.webhomebeta.service.AtasService;
import br.com.webhomebeta.to.AtasTo;

public class AtasControllerBean {
	private AtasTo atasTo;
	private boolean atas;
	private String data;
	private boolean validDate = true;
	private boolean arquivo;
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
		this.atas = atas;
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
	 * @return the validDate
	 */
	public boolean isValidDate() {
		return validDate;
	}

	/**
	 * @return the arquivo
	 */
	public boolean isArquivo() {
		return arquivo;
	}

	/**
	 * @param arquivo the arquivo to set
	 */
	public void setArquivo(boolean arquivo) {
		this.arquivo = arquivo;
	}

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

	/**
	 * @return the atas
	 */
	public boolean isAtas() {
		return atas;
	}

	/**
	 * @param b 
	 * @return the validDate
	 */
	public boolean isValidDate(boolean b) {
		return validDate;
	}

	/**
	 * @param validDate the validDate to set
	 */
	public void setValidDate(boolean validDate) {
		this.validDate = validDate;
	}

}
