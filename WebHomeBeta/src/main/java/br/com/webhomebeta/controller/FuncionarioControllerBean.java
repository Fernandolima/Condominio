package br.com.webhomebeta.controller;

import java.util.Date;

import br.com.webhomebeta.to.FuncionarioTo;

public class FuncionarioControllerBean {
	private FuncionarioTo funcionarioTo;
	private boolean idFuncionario;
	private boolean name;
	private boolean endereco;
	private boolean bairro;
	private boolean cep;
	private boolean cidade;
	private boolean telefone;
	private boolean dataEntra;
	private boolean dataSaida;
	private boolean hasErrorForm = false;
	

	/**
	 * @return the hasErrorForm
	 */
	public boolean isHasErrorForm() {
		return hasErrorForm;
	}

	/**
	 * @param hasErrorForm the hasErrorForm to set
	 */
	public void setHasErrorForm(boolean hasErrorForm) {
		this.hasErrorForm = hasErrorForm;
	}

	/**
	 * @return the funcionarioTo
	 */
	public FuncionarioTo getFuncionarioTo() {
		return funcionarioTo;
	}

	/**
	 * @return the idFuncionario
	 */
	public boolean isIdFuncionario() {
		return idFuncionario;
	}

	/**
	 * @return the name
	 */
	public boolean isName() {
		return name;
	}

	/**
	 * @return the endereco
	 */
	public boolean isEndereco() {
		return endereco;
	}

	/**
	 * @return the bairro
	 */
	public boolean isBairro() {
		return bairro;
	}

	/**
	 * @return the cep
	 */
	public boolean isCep() {
		return cep;
	}

	/**
	 * @return the cidade
	 */
	public boolean isCidade() {
		return cidade;
	}

	/**
	 * @return the telefone
	 */
	public boolean isTelefone() {
		return telefone;
	}

	/**
	 * @return the dataEntra
	 */
	public boolean isDataEntra() {
		return dataEntra;
	}

	/**
	 * @return the dataSaida
	 */
	public boolean isDataSaida() {
		return dataSaida;
	}

	/**
	 * @param funcionarioTo
	 *            the funcionarioTo to set
	 */
	public void setFuncionarioTo(FuncionarioTo funcionarioTo) {
		this.funcionarioTo = funcionarioTo;
	}

	/**
	 * @param idFuncionario
	 *            the idFuncionario to set
	 */
	public void setIdFuncionario(boolean idFuncionario) {
		this.idFuncionario = idFuncionario;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(boolean name) {
		this.name = name;
	}

	/**
	 * @param endereco
	 *            the endereco to set
	 */
	public void setEndereco(boolean endereco) {
		this.endereco = endereco;
	}

	/**
	 * @param bairro
	 *            the bairro to set
	 */
	public void setBairro(boolean bairro) {
		this.bairro = bairro;
	}

	/**
	 * @param cep
	 *            the cep to set
	 */
	public void setCep(boolean cep) {
		this.cep = cep;
	}

	/**
	 * @param cidade
	 *            the cidade to set
	 */
	public void setCidade(boolean cidade) {
		this.cidade = cidade;
	}

	/**
	 * @param telefone
	 *            the telefone to set
	 */
	public void setTelefone(boolean telefone) {
		this.telefone = telefone;
	}

	/**
	 * @param dataEntra
	 *            the dataEntra to set
	 */
	public void setDataEntra(boolean dataEntra) {
		this.dataEntra = dataEntra;
	}

	/**
	 * @param dataSaida
	 *            the dataSaida to set
	 */
	public void setDataSaida(boolean dataSaida) {
		this.dataSaida = dataSaida;
	}

	public boolean hasErrors() {
		if (idFuncionario == false || name == false || endereco == false
				|| bairro == false || cep == false || cidade == false
				|| telefone == false || dataEntra == false
				|| dataSaida == false) {
			hasErrorForm = true;
			return false;
		}
		hasErrorForm = false;
		return true;
	}
}
