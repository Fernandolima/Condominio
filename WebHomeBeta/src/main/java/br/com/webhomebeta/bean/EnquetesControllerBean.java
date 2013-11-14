package br.com.webhomebeta.bean;

import java.util.List;

import br.com.webhomebeta.to.EnquetesTo;


public class EnquetesControllerBean {

	private List<String> listOpcoes;
	private EnquetesTo enquetesTo = new EnquetesTo();;
	/**
	 * @return the listOpcoes
	 */
	public List<String> getListOpcoes() {
		return listOpcoes;
	}
	/**
	 * @return the enquetesTo
	 */
	public EnquetesTo getEnquetesTo() {
		return enquetesTo;
	}
	/**
	 * @param listOpcoes the listOpcoes to set
	 */
	public void setListOpcoes(List<String> listOpcoes) {
		this.listOpcoes = listOpcoes;
	}
	/**
	 * @param enquetesTo the enquetesTo to set
	 */
	public void setEnquetesTo(EnquetesTo enquetesTo) {
		this.enquetesTo = enquetesTo;
	}
	
	
}
