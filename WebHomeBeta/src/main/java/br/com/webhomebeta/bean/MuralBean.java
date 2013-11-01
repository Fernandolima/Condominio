package br.com.webhomebeta.bean;

import java.util.Date;

import br.com.webhomebeta.to.MuralTO;

public class MuralBean {

	private MuralTO muralTO;
	private String date;
	public MuralTO getMuralTO() {
		return muralTO;
	}
	public String getDate() {
		return date;
	}
	public void setMuralTO(MuralTO muralTO) {
		this.muralTO = muralTO;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	
}
