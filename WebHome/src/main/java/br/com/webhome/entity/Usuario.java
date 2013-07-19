package br.com.webhome.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
// Ela declara a classe como persistente e gerenciada pelo Hibernate
@Table(name = "dbo.USER")
// que define qual o nome da tabela no banco de dados ao qual a classe será
// mapeada
public class Usuario implements Serializable {

	@Column(name = "NOME")
	private String nome;

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
}
// @OneToMany(fetch=FetchType.LAZY, mappedBy="USER")

