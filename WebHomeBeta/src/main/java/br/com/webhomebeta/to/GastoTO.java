package br.com.webhomebeta.to;

import java.math.BigDecimal;
import java.util.Date;

public class GastoTO {

	private int idGasto;
	private BigDecimal gasto;
	private Date data;

	
	public int getIdGasto() {
		return idGasto;
	}
	public void setIdGasto(int idGasto) {
		this.idGasto = idGasto;
	}
	
	public BigDecimal getGasto() {
		return gasto;
	}
	public void setGasto(BigDecimal gasto) {
		this.gasto = gasto;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	
	
	
}
