package br.com.webhomebeta.json;

public class GostouJSON {
	
	private int id;
	private int idUsuario;
	private int idPublicacao;
	
	
	public GostouJSON(int id, int idUsuario, int idPublicacao) {
		super();
		this.id = id;
		this.idUsuario = idUsuario;
		this.idPublicacao = idPublicacao;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public int getIdPublicacao() {
		return idPublicacao;
	}
	public void setIdPublicacao(int idPublicacao) {
		this.idPublicacao = idPublicacao;
	}
	
}
