package br.com.webhomebeta.bean;

import java.util.HashMap;
import java.util.Map;

import br.com.webhomebeta.to.GastoTO;

public class GastoControllerBean {
	private GastoTO gastoTO = new GastoTO();
	private String mes;
	private int ano;
	private String gasto;
	private Map<String,String> meses = new HashMap<String, String>();


	public String getGasto() {
		return gasto;
	}
	public void setGasto(String gasto) {
		this.gasto = gasto;
	}
	public Map<String, String> getMeses() {
		return meses;
	}
	public void setMeses(Map<String, String> meses) {
		this.meses = meses;
	}
	public GastoTO getGastoTO() {
		return gastoTO;
	}
	public void setGastoTO(GastoTO gastoTO) {
		this.gastoTO = gastoTO;
	}
	public String getMes() {
		return mes;
	}
	public void setMes(String mes) {
		this.mes = mes;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	
	
}
