package br.com.webhomebeta.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
// Ela declara a classe como persistente e gerenciada pelo Hibernate
@Table(name = "[dbo].[USER]")
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

	@Column(name = "STATUS", columnDefinition = "BOOLEAN")
	private boolean status;

	@Column(name = "DT_NASCIMENTO")
	private Date dt_nascimento;

	@Column(name = "CPF")
	private String cpf;

	@Column(name = "BLOCO")
	private String bloco;

	@Column(name = "AP")
	private String ap;

	// Um usuario pode fazer varias publicacoes
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "usuarioPublicacao")
	private Set<Publicacao> publicacoes = new HashSet<>(0);
	// Um usuario pode fazer varios comentarios em uma publicacao
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "usuarioComentario")
	private Set<Comentario> comentarios = new HashSet<>(0);
	// Um usuario cria varias atas
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "usuarioAtas")
	private Set<AtasEntity> atas = new HashSet<>(0);
	// Um usuario cria varias Assembleia
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "usuarioAssebleia")
	private Set<Assembleia> assembleia = new HashSet<>(0);

	public Set<Assembleia> getAssembleia() {
		return assembleia;
	}

	public void setAssembleia(Set<Assembleia> assembleia) {
		this.assembleia = assembleia;
	}

	public Set<Publicacao> getPublicacoes() {
		return publicacoes;
	}

	public void setPublicacoes(Set<Publicacao> publicacoes) {
		this.publicacoes = publicacoes;
	}

	public Set<Comentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios(Set<Comentario> comentarios) {
		this.comentarios = comentarios;
	}

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
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * @return the atas
	 */
	public Set<AtasEntity> getAtas() {
		return atas;
	}

	/**
	 * @param atas
	 *            the atas to set
	 */
	public void setAtas(Set<AtasEntity> atas) {
		this.atas = atas;
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
	 * @param bloco
	 *            the bloco to set
	 */
	public void setBloco(String bloco) {
		this.bloco = bloco;
	}

	/**
	 * @param ap
	 *            the ap to set
	 */
	public void setAp(String ap) {
		this.ap = ap;
	}

}
