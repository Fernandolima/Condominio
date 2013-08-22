package br.com.webhomebeta.to;

import java.util.Date;

public class UsuarioTO {
	
	
	private int idUser;
		
	private String nome;
	
	private String login;
	
	private String email;
	
	private String cargo;
	
	private String permissao;

	private String senha;
	
	private boolean status;
	
	private Date dt_nascimento;
	
	private String cpf;
	
	private String bloco;
	
	private String ap;
	

	public int getIdUser() {
		return idUser;
	}


	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}


	public String getCargo() {
		return cargo;
	}


	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
	
	
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
	
	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	/**
	 * @return the bloco
	 */
	public String getBloco() {
		return bloco;
	}


	/**
	 * @return the ap
	 */
	public String getAp() {
		return ap;
	}


	/**
	 * @param bloco the bloco to set
	 */
	public void setBloco(String bloco) {
		this.bloco = bloco;
	}


	/**
	 * @param ap the ap to set
	 */
	public void setAp(String ap) {
		this.ap = ap;
	}

}
