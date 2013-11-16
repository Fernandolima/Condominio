package br.com.webhomebeta.json;

import java.math.BigDecimal;


public class GastoJSON {

	private int idGasto;
	private String gasto;
	private String Mes;
	private int Ano;
	
	public int getIdGasto() {
		return idGasto;
	}
	public void setIdGasto(int idGasto) {
		this.idGasto = idGasto;
	}
	
	
	public String getGasto() {
		return gasto;
	}
	public void setGasto(String gasto) {
		this.gasto = gasto;
	}
	public String getMes() {
		return Mes;
	}
	public void setMes(String mes) {
		this.Mes = mes;
	}
	public int getAno() {
		return Ano;
	}
	public void setAno(int ano) {
		this.Ano = ano;
	}
	
	
	
}
