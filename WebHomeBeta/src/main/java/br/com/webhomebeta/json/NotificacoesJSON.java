package br.com.webhomebeta.json;

public class NotificacoesJSON {

	private int idPublicacao;
	private int idComentario;
	private int idUser;
	private int idUserComentou;
	private String texto;
	private String URL;
	private String imagem;
	
	
	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public int getIdUserComentou() {
		return idUserComentou;
	}

	public void setIdUserComentou(int idUserComentou) {
		this.idUserComentou = idUserComentou;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public int getIdPublicacao() {
		return idPublicacao;
	}

	public void setIdPublicacao(int idPublicacao) {
		this.idPublicacao = idPublicacao;
	}

	public int getIdComentario() {
		return idComentario;
	}

	public void setIdComentario(int idComentario) {
		this.idComentario = idComentario;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public String getURL() {
		return URL;
	}

	public void setURL(String uRL) {
		URL = uRL;
	}

	public void SetTipo(String tipo, String nome) {
		if (tipo.equals("gostou")) {

			this.texto = nome + " gostou da sua publica��o!";

		} else if (tipo.equals("comentouse")) {

			this.texto = nome + " comentou a pr�pria publica��o!";

		} else {

			this.texto = nome + " comentou a sua publica��o!";

		}
	}

}
