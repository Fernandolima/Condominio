package br.com.webhomebeta.json;

public class UsuarioJSON {
	private String nome;
	private String dataNascimento;
	private String CPF;
	private String email;
	private String ap;
	private String bloco;
	private int id;
	
	
	public UsuarioJSON(String nome, String dataNascimento, String cPF,
			String email, String ap, String bloco, int id) {
		super();
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		CPF = cPF;
		this.email = email;
		this.ap = ap;
		this.bloco = bloco;
		this.id = id;
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getCPF() {
		return CPF;
	}
	public void setCPF(String cPF) {
		CPF = cPF;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAp() {
		return ap;
	}
	public void setAp(String ap) {
		this.ap = ap;
	}
	public String getBloco() {
		return bloco;
	}
	public void setBloco(String bloco) {
		this.bloco = bloco;
	}
	
	
}
