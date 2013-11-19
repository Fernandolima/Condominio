package br.com.webhomebeta.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Entity
public class Perfil {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_PERFIL")
	private int idPerfil;
	@Column(name = "NOME_USER")
	private String nomeUsuario;
	@Column(name = "IMAGEM")
	private String imagemUsuario;
	@Column(name = "ID_USER")
	private int idUser;
	@Column(name = "ESTILOS_MUSICAS")
	private String estilosMusicais;
	@Column(name = "LIVROS")
	private String livros;
	@Column(name = "SOBRE")
	private String sobreMim;
	@Column(name = "IDADE")
	private int idade;
	@Column(name = "PROFISSAO")
	private String profissao;
	@Column(name = "FILME")
	private String filme;
	public Perfil(){
		
	}
	
	public Perfil(String estilosMusicais, String livros, String sobreMim,
			int idade, String profissao, String nome, String imagem) {
		this.estilosMusicais = estilosMusicais;
		this.livros = livros;
		this.sobreMim = sobreMim;
		this.idade = idade;
		this.profissao = profissao;
		this.nomeUsuario = nome;
		this.imagemUsuario = imagem;
	}
	
	
	
	public String getFilme() {
		return filme;
	}

	public void setFilme(String filme) {
		this.filme = filme;
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

	public int getIdPerfil() {
		return idPerfil;
	}


	public void setIdPerfil(int idPerfil) {
		this.idPerfil = idPerfil;
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
	public String getProfissao() {
		return profissao;
	}
	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}
	
	
	
}
