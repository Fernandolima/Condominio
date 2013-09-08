package br.com.webhomebeta.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "[dbo][FUNCIONARIO]")
public class Funcionario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_FUNCINARIO")
	private int idFuncionario;

	@Column(name = "NOME")
	private String name;

	@Column(name = "ENDEREÇO")
	private String endereco;

	@Column(name = "BAIRRO")
	private String bairro;

	@Column(name = "CEP")
	private String cep;

	@Column(name = "CIDADE")
	private String cidade;

	@Column(name = "TELEFONE")
	private String telefone;

	@Column(name = "DATA_ENTRADA")
	private Date data_entra;

	@Column(name = "DATA_SAIDA")
	private Date data_saida;

	/**
	 * @return the idFuncionario
	 */
	public int getIdFuncionario() {
		return idFuncionario;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the endereco
	 */
	public String getEndereco() {
		return endereco;
	}

	/**
	 * @return the bairro
	 */
	public String getBairro() {
		return bairro;
	}

	/**
	 * @return the cep
	 */
	public String getCep() {
		return cep;
	}

	/**
	 * @return the cidade
	 */
	public String getCidade() {
		return cidade;
	}

	/**
	 * @return the telefone
	 */
	public String getTelefone() {
		return telefone;
	}

	/**
	 * @param idFuncionario
	 *            the idFuncionario to set
	 */
	public void setIdFuncionario(int idFuncionario) {
		this.idFuncionario = idFuncionario;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param endereco
	 *            the endereco to set
	 */
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	/**
	 * @param bairro
	 *            the bairro to set
	 */
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	/**
	 * @param cep
	 *            the cep to set
	 */
	public void setCep(String cep) {
		this.cep = cep;
	}

	/**
	 * @param cidade
	 *            the cidade to set
	 */
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	/**
	 * @param telefone
	 *            the telefone to set
	 */
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	/**
	 * @return the data_entra
	 */
	public Date getData_entra() {
		return data_entra;
	}

	/**
	 * @return the data_saida
	 */
	public Date getData_saida() {
		return data_saida;
	}

	/**
	 * @param data_entra
	 *            the data_entra to set
	 */
	public void setData_entra(Date data_entra) {
		this.data_entra = data_entra;
	}

	/**
	 * @param data_saida
	 *            the data_saida to set
	 */
	public void setData_saida(Date data_saida) {
		this.data_saida = data_saida;
	}

}
