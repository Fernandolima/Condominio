package br.com.webhomebeta.json;

import java.math.BigDecimal;
import java.util.Date;

public class GastoGrafico {
	private BigDecimal gasto;
	private Date data;

	
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
