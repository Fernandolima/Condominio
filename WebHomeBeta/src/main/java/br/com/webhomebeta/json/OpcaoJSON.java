package br.com.webhomebeta.json;

public class OpcaoJSON {
	
	private int idOpcao;
	private String opcao;
	private int quantidadeVotos;
	
	public OpcaoJSON(int idOpcao, String opcao, int quantidadeVotos) {
		super();
		this.idOpcao = idOpcao;
		this.opcao = opcao;
		this.quantidadeVotos = quantidadeVotos;
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
	public int getQuantidadeVotos() {
		return quantidadeVotos;
	}
	public void setQuantidadeVotos(int quantidadeVotos) {
		this.quantidadeVotos = quantidadeVotos;
	}
	
	
}

