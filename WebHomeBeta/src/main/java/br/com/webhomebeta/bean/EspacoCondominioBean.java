package br.com.webhomebeta.bean;

import br.com.webhomebeta.to.EspacoCondominioTo;

public class EspacoCondominioBean {
	private EspacoCondominioTo espacoCondominioTo;
	private boolean idEspaco = false;
	private boolean nameEspaco = false;
	private boolean hasErrorForm = false;
	private boolean validDate ;

	/**
	 * @param validDate 
	 */
	public void isValidDate(boolean validDate) {
		this.validDate = validDate;
	}

	/**
	 * @param validDate the validDate to set
	 */
	public void setValidDate(boolean validDate) {
		this.validDate = validDate;
	}

	/**
	 * @return the espacoCondominioTo
	 */
	public EspacoCondominioTo getEspacoCondominioTo() {
		return espacoCondominioTo;
	}

	/**
	 * @return the idEspaco
	 */
	public boolean isIdEspaco() {
		return idEspaco;
	}

	/**
	 * @param b 
	 */
	public void isNameEspaco(boolean nameEspaco) {
		this.nameEspaco = nameEspaco;
	}

	/**
	 * @return the hasErrorForm
	 */
	public boolean isHasErrorForm() {
		return hasErrorForm;
	}

	/**
	 * @param espacoCondominioTo
	 *            the espacoCondominioTo to set
	 */
	public void setEspacoCondominioTo(EspacoCondominioTo espacoCondominioTo) {
		this.espacoCondominioTo = espacoCondominioTo;
	}

	/**
	 * @param idEspaco
	 *            the idEspaco to set
	 */
	public void setIdEspaco(boolean idEspaco) {
		this.idEspaco = idEspaco;
	}

	/**
	 * @param nameEspaco
	 *            the nameEspaco to set
	 */
	public void setNameEspaco(boolean nameEspaco) {
		this.nameEspaco = nameEspaco;
	}

	/**
	 * @param hasErrorForm
	 *            the hasErrorForm to set
	 */
	public void setHasErrorForm(boolean hasErrorForm) {
		this.hasErrorForm = hasErrorForm;
	}

	public boolean hasErrors() {
		if (idEspaco == false || nameEspaco == false) {
			hasErrorForm = true;
			return false;
		}
		hasErrorForm = false;
		return true;
	}
}
