package br.com.webhomebeta.json;

public class PerfilJSON {
	private int idPerfil;
	private String nomeUsuario;
	private String imagemUsuario;
	private int idUser;
	private String estilosMusicais;
	private String livros;
	private String sobreMim;
	private int idade;
	private String data;
	private String email;
	

	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getIdPerfil() {
		return idPerfil;
	}
	public void setIdPerfil(int idPerfil) {
		this.idPerfil = idPerfil;
	}
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
	
	
}
