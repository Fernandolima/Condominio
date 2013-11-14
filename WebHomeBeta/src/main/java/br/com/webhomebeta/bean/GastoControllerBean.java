package br.com.webhomebeta.bean;

import java.util.HashMap;
import java.util.Map;

import br.com.webhomebeta.to.GastoTO;

public class GastoControllerBean {
	private GastoTO gastoTO;
	private String mes;
	private int ano;
	private Map<String,String> meses = new HashMap<String, String>();
	
	
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
