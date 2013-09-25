package br.com.webhomebeta.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
public class Perfil {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_PERFIL")
	private int idPerfil;
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
	
	public Perfil(String estilosMusicais, String livros, String sobreMim,
			int idade, String profissao) {
		this.estilosMusicais = estilosMusicais;
		this.livros = livros;
		this.sobreMim = sobreMim;
		this.idade = idade;
		this.profissao = profissao;
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
