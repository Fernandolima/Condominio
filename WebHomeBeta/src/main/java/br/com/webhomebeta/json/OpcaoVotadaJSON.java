package br.com.webhomebeta.json;

public class OpcaoVotadaJSON {
	
	private int idOpcaoVotada;
	private int idUser;
	
	public OpcaoVotadaJSON(int idOpcaoVotada, int idUser) {
		super();
		this.idOpcaoVotada = idOpcaoVotada;
		this.idUser = idUser;
	}
	public int getIdOpcaoVotada() {
		return idOpcaoVotada;
	}
	public void setIdOpcaoVotada(int idOpcaoVotada) {
		this.idOpcaoVotada = idOpcaoVotada;
	}
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
}
