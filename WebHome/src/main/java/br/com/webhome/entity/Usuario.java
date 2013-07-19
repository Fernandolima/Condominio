package br.com.webhome.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import net.sourceforge.jtds.jdbc.DateTime;

@Entity
// Ela declara a classe como persistente e gerenciada pelo Hibernate
@Table(name = "dbo.USER")
// que define qual o nome da tabela no banco de dados ao qual a classe será
// mapeada
public class Usuario implements Serializable {

	@Column(name = "NOME")
	private String nome;

	@Column(USUAARIOLOGIN = "LOGIN")
	private String USUAARIOLOGIN;
	
	@Column(email = "EMAIL")
	private String email;
	
	@Column(permissao = "PERMISSAO")
	private String permissao;
	
	@Column(senha = "SENHA")
	private String senha;
	
	@Column(dtNascimento = "DT_NASCIMENTO")
	private DateTime dtNascimento;
	
	@Id
	// define a propriedade que será o identificador único da classe e da
	// tabela.
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	// É uma boa prática definir uma propriedade id com um valor gerado
	// automaticamente
	private Integer id;

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param nome
	 *            the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the uSUAARIOLOGIN
	 */
	public String getUSUAARIOLOGIN() {
		return USUAARIOLOGIN;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @return the permissao
	 */
	public String getPermissao() {
		return permissao;
	}

	/**
	 * @return the senha
	 */
	public String getSenha() {
		return senha;
	}

	/**
	 * @return the dtNascimento
	 */
	public DateTime getDtNascimento() {
		return dtNascimento;
	}

	/**
	 * @param uSUAARIOLOGIN the uSUAARIOLOGIN to set
	 */
	public void setUSUAARIOLOGIN(String uSUAARIOLOGIN) {
		USUAARIOLOGIN = uSUAARIOLOGIN;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @param permissao the permissao to set
	 */
	public void setPermissao(String permissao) {
		this.permissao = permissao;
	}

	/**
	 * @param senha the senha to set
	 */
	public void setSenha(String senha) {
		this.senha = senha;
	}

	/**
	 * @param dtNascimento the dtNascimento to set
	 */
	public void setDtNascimento(DateTime dtNascimento) {
		this.dtNascimento = dtNascimento;
	}
}
// @OneToMany(fetch=FetchType.LAZY, mappedBy="USER")

