package br.com.webhomebeta.bean;

import java.util.List;

import br.com.webhomebeta.to.EspacoCondominioTo;

public class EspacoCondominioBean {
	private EspacoCondominioTo espacoCondominioTo;
	private boolean nameEspaco;
	private List<String> listEspaco;

	public List<String> getListEspaco() {
		return listEspaco;
	}

	public void setListEspaco(List<String> listEspaco) {
		this.listEspaco = listEspaco;
	}

	/**
	 * @return the espacoCondominioTo
	 */
	public EspacoCondominioTo getEspacoCondominioTo() {
		return espacoCondominioTo;
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
	 * @param nameEspaco
	 *            the nameEspaco to set
	 */
	public void setNameEspaco(boolean nameEspaco) {
		this.nameEspaco = nameEspaco;
	}

}
