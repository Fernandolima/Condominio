package br.com.webhomebeta.to;

import java.sql.Date;

public class UsuarioTO {
	
	private String nome;

	
	private String login;
	
	
	private String email;
	
	
	private String permissao;

	
	private String senha;
	
	
	private boolean status;
	
	
	private Date dt_nascimento;


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPermissao() {
		return permissao;
	}


	public void setPermissao(String permissao) {
		this.permissao = permissao;
	}


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}


	public boolean isStatus() {
		return status;
	}


	public void setStatus(boolean status) {
		this.status = status;
	} 


	public Date getDt_nascimento() {
		return dt_nascimento;
	}


	public void setDt_nascimento(Date dt_nascimento) {
		this.dt_nascimento = dt_nascimento;
	}

}
