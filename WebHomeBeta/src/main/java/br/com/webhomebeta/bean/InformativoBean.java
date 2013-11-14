package br.com.webhomebeta.bean;

import java.util.Date;

import br.com.webhomebeta.to.InformativoTO;

public class InformativoBean {
	private String date;
	private InformativoTO informativoTO;
	private Date dataExpiracao;

	public InformativoTO getInformativoTO() {
		return informativoTO;
	}

	public void setInformativoTO(InformativoTO informativoTO) {
		this.informativoTO = informativoTO;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	

}
