package br.com.webhomebeta.controller;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import br.com.webhomebeta.to.UsuarioTO;

public class UsuarioControllerBean {
	
	UsuarioTO usuarioTO;
	
	private String confSenha;
	private boolean validName = true;
	private boolean validEmail = true;
	private boolean validEmailExistente = true;
	private boolean validSenha = true;
	private boolean validDataNascimento = true;
	private boolean validCpf = true;
	private boolean validBloco = true;
	private boolean validApartamento = true;
	
	private DateFormat format = new SimpleDateFormat("MM/dd/yyyy");
	private String data;
	
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
		try {
			Date date = (Date) format.parse(data);
			usuarioTO.setDt_nascimento(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
	public boolean isValidApartamento() {
		return validApartamento;
	}
	public void setValidApartamento(boolean validApartamento) {
		this.validApartamento = validApartamento;
	}
	/**
	 * @return the validEmailExistente
	 */
	public boolean isValidEmailExistente() {
		return validEmailExistente;
	}
	/**
	 * @param validEmailExistente the validEmailExistente to set
	 */
	public void setValidEmailExistente(boolean validEmailExistente) {
		this.validEmailExistente = validEmailExistente;
	}
	
	
}
