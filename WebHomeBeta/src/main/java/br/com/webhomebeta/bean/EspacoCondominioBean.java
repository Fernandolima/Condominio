package br.com.webhomebeta.bean;

import java.util.List;

import br.com.webhomebeta.to.EspacoCondominioTo;

public class EspacoCondominioBean {
	private EspacoCondominioTo espacoCondominioTo;
	private boolean idEspaco;
	private boolean nameEspaco;
	private boolean validDate ;
	private List<String> listEspaco;
	
	

	public List<String> getListEspaco() {
		return listEspaco;
	}

	public void setListEspaco(List<String> listEspaco) {
		this.listEspaco = listEspaco;
	}

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

	}
