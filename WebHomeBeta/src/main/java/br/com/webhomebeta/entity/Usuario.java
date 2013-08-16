package br.com.webhomebeta.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

	@Entity
// Ela declara a classe como persistente e gerenciada pelo Hibernate
	@Table(name = "[dbo].[User]")
// que define qual o nome da tabela no banco de dados ao qual a classe será
// mapeada
public class Usuario implements Serializable {
		
	/**
		 * 
		 */
		private static final long serialVersionUID = 499205724766612628L;

	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_USER")	
	private int idUser;
		
	@Column(name = "NOME")
	private String nome;

	@Column(name = "LOGIN")
	private String login;
	
	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "CARGO")
	private String cargo;
	
	@Column(name = "PERMISSAO")
	private String permissao;

	@Column(name = "SENHA")
	private String senha;
	
	@Column(name = "STATUS", columnDefinition="BOOLEAN")
	private boolean status;
	
	@Column(name = "DT_NASCIMENTO")
	private Date dt_nascimento;
	
	@Column(name = "CPF")
	private String cpf;
	
	@Column(name = "BLOCO_AP")
	private String blocoEAp;
	

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


	public String getBlocoEAp() {
		return blocoEAp;
	}


	public void setBlocoEAp(String blocoEAp) {
		this.blocoEAp = blocoEAp;
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

}


