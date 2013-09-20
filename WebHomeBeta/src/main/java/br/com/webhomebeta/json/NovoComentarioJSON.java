package br.com.webhomebeta.json;

public class NovoComentarioJSON {

	private String comentario;
	private int idComentario;
	private int idUser;
	private String caminhoImagem;
	private String dataComentario;
	private String nomeUsuario;

	public NovoComentarioJSON(String comentario, int idComentario, int idUser,
			String caminhoImagem, String dataComentario, String nomeUsuario) {

		this.comentario = comentario;
		this.idComentario = idComentario;
		this.idUser = idUser;
		this.caminhoImagem = caminhoImagem;
		this.dataComentario = dataComentario;
		this.nomeUsuario = nomeUsuario;
	}
	
	
	public String getNomeUsuario() {
		return nomeUsuario;
	}


	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}


	public String getDataComentario() {
		return dataComentario;
	}

	public void setDataComentario(String dataComentario) {
		this.dataComentario = dataComentario;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public int getIdComentario() {
		return idComentario;
	}

	public void setIdComentario(int idComentario) {
		this.idComentario = idComentario;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getCaminhoImagem() {
		return caminhoImagem;
	}

	public void setCaminhoImagem(String caminhoImagem) {
		this.caminhoImagem = caminhoImagem;
	}

}
