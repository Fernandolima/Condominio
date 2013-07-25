package br.com.webhome.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
//Ela declara a classe como persistente e gerenciada pelo Hibernate
@Table(name = "dbo.PUBLICACAO")
//que define qual o nome da tabela no banco de dados ao qual a classe será
//mapeada
public class Publicacao {
	
	

	@Column(name = "PUBLICACAO")
	private String publicacao;
	
	@Id
	// define a propriedade que será o identificador único da classe e da
	// tabela.
	@Column(name = "ID_PUBLICACAO")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	// É uma boa prática definir uma propriedade id com um valor gerado
	// automaticamente
	private Integer id_PUBLICACAO;
	

	/**
	 * @return the publicacao
	 */
	public String getPublicacao() {
		return publicacao;
	}

	/**
	 * @return the id_PUBLICACAO
	 */
	public Integer getId_PUBLICACAO() {
		return id_PUBLICACAO;
	}

	/**
	 * @param publicacao the publicacao to set
	 */
	public void setPublicacao(String publicacao) {
		this.publicacao = publicacao;
	}

	/**
	 * @param id_PUBLICACAO the id_PUBLICACAO to set
	 */
	public void setId_PUBLICACAO(Integer id_PUBLICACAO) {
		this.id_PUBLICACAO = id_PUBLICACAO;
	}
	
	

}
