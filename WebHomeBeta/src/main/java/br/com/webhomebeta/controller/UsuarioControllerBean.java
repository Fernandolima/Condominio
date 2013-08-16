package br.com.webhomebeta.controller;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

import br.com.webhomebeta.to.UsuarioTO;
//Bean usada na view
public class UsuarioControllerBean {

	private UsuarioTO usuarioTO;
	private String confSenha;
	private String data;
	private boolean validName = true;
	private boolean validEmail = true;
	private boolean validEmailExistente = true;
	private boolean validSenha = true;
	private boolean validConfSenha = true;
	private boolean validDataNascimento = true;
	private boolean validCpf = true;
	private boolean validBloco = true;
	private boolean hasErrorForm = false;
	
	
	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public boolean isValidConfSenha() {
		return validConfSenha;
	}

	public void setValidConfSenha(boolean validConfSenha) {
		this.validConfSenha = validConfSenha;
	}

	public boolean isHasErrorForm() {
		return hasErrorForm;
	}

	public void setHasErrorForm(boolean hasErrorForm) {
		this.hasErrorForm = hasErrorForm;
	}

	public UsuarioTO getUsuarioTO() {
		return usuarioTO;
	}

	public void setUsuarioTO(UsuarioTO usuarioTO) {
		this.usuarioTO = usuarioTO;
	}

	public String getConfSenha() {
		return confSenha;
	}

	public void setConfSenha(String confSenha) {
		this.confSenha = confSenha;
	}

	public boolean isValidName() {
		return validName;
	}

	public void setValidName(boolean validName) {
		this.validName = validName;
	}

	public boolean isValidEmail() {
		return validEmail;
	}

	public void setValidEmail(boolean validEmail) {
		this.validEmail = validEmail;
	}

	public boolean isValidSenha() {
		return validSenha;
	}

	public void setValidSenha(boolean validSenha) {
		this.validSenha = validSenha;
	}

	public boolean isValidDataNascimento() {
		return validDataNascimento;
	}

	public void setValidDataNascimento(boolean validDataNascimento) {
		this.validDataNascimento = validDataNascimento;
	}

	public boolean isValidCpf() {
		return validCpf;
	}

	public void setValidCpf(boolean validCpf) {
		this.validCpf = validCpf;
	}

	public boolean isValidBloco() {
		return validBloco;
	}

	public void setValidBloco(boolean validBloco) {
		this.validBloco = validBloco;
	}

	
	public boolean isValidEmailExistente() {
		return validEmailExistente;
	}

	public void setValidEmailExistente(boolean validEmailExistente) {
		this.validEmailExistente = validEmailExistente;
	}
	
	
	
	public boolean hasErrors() {
		if ( validBloco == false
				|| validCpf == false || validDataNascimento == false
				|| validEmail == false || validEmailExistente == false
				|| validName == false || validSenha == false){
			hasErrorForm = true;
			return false;
		}
		hasErrorForm = false;
		return true;
	}

}
