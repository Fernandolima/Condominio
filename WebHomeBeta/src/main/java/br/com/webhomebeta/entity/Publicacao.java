package br.com.webhomebeta.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
// Ela declara a classe como persistente e gerenciada pelo Hibernate
@Table(name = "[dbo].[PUBLICACAO]")
// que define qual o nome da tabela no banco de dados ao qual a classe será
// mapeada
public class Publicacao implements Serializable {

	
	public Publicacao() {

	}
	public Publicacao(Integer id){
		this.idPublicacao = id;
	}
	public Publicacao(Usuario usuario) {
		this.usuarioPublicacao = usuario;
	}
	
	public Publicacao(String publicacao, Usuario usuarioPublicacao) {
		this.publicacao = publicacao;
		this.usuarioPublicacao = usuarioPublicacao;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 7669238417461113597L;

	@Column(name = "PUBLICACAO")
	private String publicacao;

	@Id
	// define a propriedade que será o identificador único da classe e da
	// tabela.
	@Column(name = "ID_PUBLICACAO")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	// É uma boa prática definir uma propriedade id com um valor gerado
	// automaticamente
	private int idPublicacao;

	// Mapeamento N - 1
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_USER")
	private Usuario usuarioPublicacao;

	// Mapeamento 1 - N
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "publicacao")
	private Set<Comentario> comentarios = new HashSet<>(0);

	public Usuario getUsuarioPublicacao() {
		return usuarioPublicacao;
	}

	public void setUsuarioPublicacao(Usuario usuarioPublicacao) {
		this.usuarioPublicacao = usuarioPublicacao;
	}

	public Set<Comentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios(Set<Comentario> comentarios) {
		this.comentarios = comentarios;
	}

	public String getPublicacao() {
		return publicacao;
	}

	public int getId_PUBLICACAO() {
		return idPublicacao;
	}

	public void setPublicacao(String publicacao) {
		this.publicacao = publicacao;
	}

	void setId_PUBLICACAO(int idPublicacao) {
		this.idPublicacao = idPublicacao;
	}

}
