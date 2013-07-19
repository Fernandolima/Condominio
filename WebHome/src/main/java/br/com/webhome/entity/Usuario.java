package br.com.webhome.entity;

import java.io.Serializable;

import javax.persistence.Entity;
@Entity //Ela declara a classe como persistente e gerenciada pelo Hibernate
public class Usuario implements Serializable {
	
	private String nome; 
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
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	//@OneToMany(fetch=FetchType.LAZY, mappedBy="USER")
	@Id //define a propriedade que será o identificador único da classe e da tabela.
	@GeneratedValue(strategy=GenerateType.IDENTITY)// É uma boa prática definir uma propriedade id com um valor gerado automaticamente
	@Table(Usuario="dbo.USER")//que define qual o nome da tabela no banco de dados ao qual a classe será mapeada 
	@Column(id="ID")
	@Column(nome="NOME")
	@Enumerated(EnumType.ORDINAL) // Ele indica que o valor a ser gravado no banco de dados é um valor numérico correspondente à posição do valor na Enum;
	

}
