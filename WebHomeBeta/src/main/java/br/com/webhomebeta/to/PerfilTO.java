package br.com.webhomebeta.to;

public class PerfilTO {
	
	private int idPerfil;
	private String estilosMusicais;
	private String nomeUsuario;
	private String imagemUsuario;
	private int idUser;
	private String livros;
	private String sobreMim;
	private int idade;
	private String profissao;
	private String filme;
	
	
	
	
	public String getNomeUsuario() {
		return nomeUsuario;
	}
	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}
	public String getImagemUsuario() {
		return imagemUsuario;
	}
	public void setImagemUsuario(String imagemUsuario) {
		this.imagemUsuario = imagemUsuario;
	}
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public String getFilme() {
		return filme;
	}
	public void setFilme(String filme) {
		this.filme = filme;
	}
	public int getIdPerfil() {
		return idPerfil;
	}
	public void setIdPerfil(int idPerfil) {
		this.idPerfil = idPerfil;
	}
	public String getEstilosMusicais() {
		return estilosMusicais;
	}
	public void setEstilosMusicais(String estilosMusicais) {
		this.estilosMusicais = estilosMusicais;
	}
	public String getLivros() {
		return livros;
	}
	public void setLivros(String livros) {
		this.livros = livros;
	}
	public String getSobreMim() {
		return sobreMim;
	}
	public void setSobreMim(String sobreMim) {
		this.sobreMim = sobreMim;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public String getProfissao() {
		return profissao;
	}
	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}
	
	
}
