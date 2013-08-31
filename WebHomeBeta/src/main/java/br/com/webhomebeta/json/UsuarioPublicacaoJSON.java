package br.com.webhomebeta.json;

public class UsuarioPublicacaoJSON {
	int idUsuarioPublicacao;
	String nome;
	
	public UsuarioPublicacaoJSON(int idUsuarioPublicacao, String nome) {
		super();
		this.idUsuarioPublicacao = idUsuarioPublicacao;
		this.nome = nome;
	}
	public int getIdUsuarioPublicacao() {
		return idUsuarioPublicacao;
	}
	public void setIdUsuarioPublicacao(int idUsuarioPublicacao) {
		this.idUsuarioPublicacao = idUsuarioPublicacao;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
