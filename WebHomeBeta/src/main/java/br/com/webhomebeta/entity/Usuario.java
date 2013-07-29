package br.com.webhomebeta.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import net.sourceforge.jtds.jdbc.DateTime;

	@Entity
// Ela declara a classe como persistente e gerenciada pelo Hibernate
	@Table(name = "dbo.User")
// que define qual o nome da tabela no banco de dados ao qual a classe será
// mapeada
public class Usuario implements Serializable {

	@Column(name = "NOME")
	private String nome;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "LOGIN")
	private String login;
	
	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "PERMISSAO")
	private String permissao;

	@Column(name = "SENHA")
	private String senha;
	
	@Column(name = "STATUS", columnDefinition="BOOLEAN")
	private boolean status;
	
	@Column(name = "DT_NASCIMENTO")
	private Date dt_nascimento;
	
	@Column(name = "CPF")
	private int cpf;
	
	@Column(name = "BLOCO")
	private int bloco;
	
	@Column(name = "AP")
	private int apartamento;
	
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
	
	public int getCpf() {
		return cpf;
	}


	public void setCpf(int cpf) {
		this.cpf = cpf;
	}


	public int getBloco() {
		return bloco;
	}


	public void setBloco(int bloco) {
		this.bloco = bloco;
	}


	public int getApartamento() {
		return apartamento;
	}


	public void setApartamento(int apartamento) {
		this.apartamento = apartamento;
	}


	
}


