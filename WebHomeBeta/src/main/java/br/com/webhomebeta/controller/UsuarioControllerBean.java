package br.com.webhomebeta.controller;

import br.com.webhomebeta.to.UsuarioTO;

public class UsuarioControllerBean {
	
	UsuarioTO usuarioTO;
	
	private String confSenha;
	private boolean validName = true;
	private boolean validEmail = true;
	private boolean validSenha = true;
	private boolean validDataNascimento = true;
	private boolean validCpf = true;
	private boolean validBloco = true;
	private boolean validApartamento = true;
	
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
	public boolean isValidApartamento() {
		return validApartamento;
	}
	public void setValidApartamento(boolean validApartamento) {
		this.validApartamento = validApartamento;
	}
	
	
}
