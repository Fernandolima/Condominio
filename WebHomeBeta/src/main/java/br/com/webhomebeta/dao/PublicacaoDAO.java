package br.com.webhomebeta.dao;

import java.util.List;

import br.com.webhomebeta.entity.Publicacao;

public interface PublicacaoDAO {
	
	public Publicacao salvarPublicacao(Publicacao publicacao);
	public void deletarPublicacao(int idUsuario, int idPublicacao);
	public List<Publicacao> getPublicacoes();
	public List<Publicacao> getPublicacao(int idUser);
	public Publicacao getUnicaPublicacao(int idPublicacao);
	public void update(int id, String imagem);
}
		
	

