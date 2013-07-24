package br.com.webhome.entity;

import java.sql.Date;

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
public class Morador extends Usuario {
	
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
	
	@Override
	public void setDt_nascimento(Date dt_nascimento) {
		// TODO Auto-generated method stub
		super.setDt_nascimento(dt_nascimento);
	}
	
	@Override
	public void setId(Integer id) {
		// TODO Auto-generated method stub
		super.setId(id);
	}
	
	@Override
	public void setEmail(String email) {
		// TODO Auto-generated method stub
		super.setEmail(email);
	}
	
	@Override
	public void setLogin(String login) {
		// TODO Auto-generated method stub
		super.setLogin(login);
	}
	
	@Override
	public void setNome(String nome) {
		// TODO Auto-generated method stub
		super.setNome(nome);
	}
	
	@Override
	public void setPermissao(String permissao) {
		// TODO Auto-generated method stub
		super.setPermissao(permissao);
	}
	
	@Override
	public void setSenha(String senha) {
		// TODO Auto-generated method stub
		super.setSenha(senha);
	}
	@Override
	public void setStatus(boolean status) {
		// TODO Auto-generated method stub
		super.setStatus(status);
	}

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
