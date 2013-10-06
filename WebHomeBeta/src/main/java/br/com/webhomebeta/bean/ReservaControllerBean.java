package br.com.webhomebeta.bean;

import java.util.List;

import br.com.webhomebeta.to.ReservaTO;

public class ReservaControllerBean {
	private List<String> listReserva;
	
	private ReservaTO reservaTO;

	public List<String> getListReserva() {
		return listReserva;
	}

	public ReservaTO getReservaTO() {
		return reservaTO;
	}

	public void setListReserva(List<String> listReserva) {
		this.listReserva = listReserva;
	}

	public void setReservaTO(ReservaTO reservaTO) {
		this.reservaTO = reservaTO;
	}

}
