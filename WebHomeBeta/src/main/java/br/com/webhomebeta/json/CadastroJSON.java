package br.com.webhomebeta.json;

public class CadastroJSON {

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
	private boolean validApartamento = true;
	private boolean allCorrect = false;

	public CadastroJSON(boolean validName, boolean validEmail,
			boolean validEmailExistente, boolean validSenha,
			boolean validConfSenha, boolean validDataNascimento,
			boolean validCpf, boolean validBloco, boolean validApartamento, boolean allCorret) {
		this.validName = validName;
		this.validEmail = validEmail;
		this.validEmailExistente = validEmailExistente;
		this.validSenha = validSenha;
		this.validConfSenha = validConfSenha;
		this.validDataNascimento = validDataNascimento;
		this.validCpf = validCpf;
		this.validBloco = validBloco;
		this.validApartamento = validApartamento;
		this.allCorrect = allCorret;
	}
	
	

	public CadastroJSON(boolean allCorrect) {
		super();
		this.allCorrect = allCorrect;
	}



	public boolean isAllCorrect() {
		return allCorrect;
	}

	public void setAllCorrect(boolean allCorrect) {
		this.allCorrect = allCorrect;
	}

	public String getConfSenha() {
		return confSenha;
	}

	public void setConfSenha(String confSenha) {
		this.confSenha = confSenha;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
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

	public boolean isValidEmailExistente() {
		return validEmailExistente;
	}

	public void setValidEmailExistente(boolean validEmailExistente) {
		this.validEmailExistente = validEmailExistente;
	}

	public boolean isValidSenha() {
		return validSenha;
	}

	public void setValidSenha(boolean validSenha) {
		this.validSenha = validSenha;
	}

	public boolean isValidConfSenha() {
		return validConfSenha;
	}

	public void setValidConfSenha(boolean validConfSenha) {
		this.validConfSenha = validConfSenha;
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
