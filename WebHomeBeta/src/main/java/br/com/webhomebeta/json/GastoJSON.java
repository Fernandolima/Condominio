package br.com.webhomebeta.json;

import java.math.BigDecimal;


public class GastoJSON {

	private int idGasto;
	private String gasto;
	private String Mes;
	private int Ano;
	private int erro;
	
	
	
	public GastoJSON() {
		super();
	}
	public GastoJSON(int erro) {
		super();
		this.erro = erro;
	}
	public int getIdGasto() {
		return idGasto;
	}
	public void setIdGasto(int idGasto) {
		this.idGasto = idGasto;
	}
	
	
	public int getErro() {
		return erro;
	}
	public void setErro(int erro) {
		this.erro = erro;
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
