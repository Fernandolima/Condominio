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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.stereotype.Component;

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
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_USER")
	private Usuario usuarioPublicacao;
	
	@Column(name = "DATA_PUBLICACAO")
	@Temporal(TemporalType.TIMESTAMP)
	private Date data;
	
	@Column(name = "IMAGEM")
	private String imagem;
	// Mapeamento 1 - N
	// Utiliza Second level cache, para melhorar o desempenho do servidor
	@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "publicacao")
	private Set<Comentario> comentarios = new HashSet<>(0);

	
	
	public String getImagem() {
		return imagem;
	}
	public void setImagem(String imagem) {
		this.imagem = imagem;
	}
	public void setIdPublicacao(int idPublicacao) {
		this.idPublicacao = idPublicacao;
	}
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

	public int getIdPublicacao() {
		return idPublicacao;
	}

	public void setPublicacao(String publicacao) {
		this.publicacao = publicacao;
	}

	public void setId_PUBLICACAO(int idPublicacao) {
		this.idPublicacao = idPublicacao;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	
}
