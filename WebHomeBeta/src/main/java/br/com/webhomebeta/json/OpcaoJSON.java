package br.com.webhomebeta.json;

import java.util.ArrayList;

public class OpcaoJSON {
	
	private int idOpcao;
	private String opcao;
	private String porcentagemVotos;
	private ArrayList<OpcaoVotadaJSON> opcaoVotadaJSONs = new ArrayList<>();
	
	
	
	public OpcaoJSON(int idOpcao, String opcao, String porcentagemVotos) {
		super();
		this.idOpcao = idOpcao;
		this.opcao = opcao;
		this.porcentagemVotos = porcentagemVotos;
	}
	public int getIdOpcao() {
		return idOpcao;
	}
	public void setIdOpcao(int idOpcao) {
		this.idOpcao = idOpcao;
	}
	public String getOpcao() {
		return opcao;
	}
	public void setOpcao(String opcao) {
		this.opcao = opcao;
	}
	public String getPorcentagemVotos() {
		return porcentagemVotos;
	}
	public void setPorcentagemVotos(String porcentagemVotos) {
		this.porcentagemVotos = porcentagemVotos;
	}
	public ArrayList<OpcaoVotadaJSON> getOpcaoVotadaJSONs() {
		return opcaoVotadaJSONs;
	}
	public void setOpcaoVotadaJSONs(ArrayList<OpcaoVotadaJSON> opcaoVotadaJSONs) {
		this.opcaoVotadaJSONs = opcaoVotadaJSONs;
	}
	
	
	
}

