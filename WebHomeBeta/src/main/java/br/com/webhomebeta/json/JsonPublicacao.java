package br.com.webhomebeta.json;

import java.util.List;
import java.util.Set;

import br.com.webhomebeta.entity.Gostou;
import br.com.webhomebeta.entity.NaoGostou;

public class JsonPublicacao {

	private String publicacao;
	private int idPublicacao;
	private String dataPublicacao;
	private String imagemPublicacao;
	private UsuarioPublicacaoJSON usuarioPublicacao;
	private List<ComentarioJSON> comentarios;
	private int quantidadeComentarios;
	private boolean isProprietario;
	private Set<Gostou> gostous;
	private Set<NaoGostou> naoGostous;
	private int quantidadeGostou;
	private int quantidadeNaoGostou;

	

	public JsonPublicacao(String publicacao, int idPublicacao,
			String dataPublicacao, String imagemPublicacao,
			UsuarioPublicacaoJSON usuarioPublicacao, Set<Gostou> gostous,
			Set<NaoGostou> naoGostous, int quantidadeGostou,
			int quantidadeNaoGostou) {
		super();
		this.publicacao = publicacao;
		this.idPublicacao = idPublicacao;
		this.dataPublicacao = dataPublicacao;
		this.imagemPublicacao = imagemPublicacao;
		this.usuarioPublicacao = usuarioPublicacao;
		this.gostous = gostous;
		this.naoGostous = naoGostous;
		this.quantidadeGostou = quantidadeGostou;
		this.quantidadeNaoGostou = quantidadeNaoGostou;
	}



	public int getQuantidadeGostou() {
		return quantidadeGostou;
	}



	public void setQuantidadeGostou(int quantidadeGostou) {
		this.quantidadeGostou = quantidadeGostou;
	}



	public int getQuantidadeNaoGostou() {
		return quantidadeNaoGostou;
	}



	public void setQuantidadeNaoGostou(int quantidadeNaoGostou) {
		this.quantidadeNaoGostou = quantidadeNaoGostou;
	}



	public Set<Gostou> getGostous() {
		return gostous;
	}

	public void setGostous(Set<Gostou> gostous) {
		this.gostous = gostous;
	}

	public Set<NaoGostou> getNaoGostous() {
		return naoGostous;
	}

	public void setNaoGostous(Set<NaoGostou> naoGostous) {
		this.naoGostous = naoGostous;
	}

	public String getDataPublicacao() {
		return dataPublicacao;
	}

	public int getQuantidadeComentarios() {
		return quantidadeComentarios;
	}

	public void setQuantidadeComentarios(int quantidadeComentarios) {
		this.quantidadeComentarios = quantidadeComentarios;
	}

	public void setDataPublicacao(String dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}

	public boolean isProprietario() {
		return isProprietario;
	}

	public void setProprietario(boolean isProprietario) {
		this.isProprietario = isProprietario;
	}

	public UsuarioPublicacaoJSON getUsuarioPublicacao() {
		return usuarioPublicacao;
	}

	public void setUsuarioPublicacao(UsuarioPublicacaoJSON usuarioPublicacao) {
		this.usuarioPublicacao = usuarioPublicacao;
	}

	public List<ComentarioJSON> getComentarios() {
		return comentarios;
	}

	public void setComentarios(List<ComentarioJSON> comentarios) {
		this.comentarios = comentarios;
	}

	public String getPublicacao() {
		return publicacao;
	}

	public void setPublicacao(String publicacao) {
		this.publicacao = publicacao;
	}

	public int getIdPublicacao() {
		return idPublicacao;
	}

	public void setIdPublicacao(int idPublicacao) {
		this.idPublicacao = idPublicacao;
	}

	public String getImagemPublicacao() {
		return imagemPublicacao;
	}

	public void setImagemPublicacao(String imagemPublicacao) {
		this.imagemPublicacao = imagemPublicacao;
	}

}
